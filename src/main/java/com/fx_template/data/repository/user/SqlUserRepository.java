package com.fx_template.data.repository.user;

import com.fx_template.data.SQLDataSource;
import com.fx_template.models.User;
import org.hibernate.Session;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class SqlUserRepository implements UserRepository {
    private final SQLDataSource sqlDataSource;

    public SqlUserRepository(SQLDataSource sqlDataSource) {
        this.sqlDataSource = sqlDataSource;
    }

    @Override
    public boolean login(String username, String password) {
        Session session = sqlDataSource.getSession();

        User user = session.bySimpleNaturalId(User.class).load(username);

        if (user == null) {
            return false;
        }

        Base64.Decoder decoder = Base64.getDecoder();

        byte[] salt = decoder.decode(user.getSalt());
        byte[] hash = decoder.decode(user.getPassword());

        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);

        SecretKeyFactory keyFactory;
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (Exception ignored) {
            // Should never happen
            System.exit(1);
            return false;
        }

        byte[] testHash;
        try {
            testHash = keyFactory.generateSecret(keySpec).getEncoded();
        } catch (Exception ignored) {
            // Should never happen
            System.exit(1);
            return false;
        }

        if (hash.length != testHash.length) {
            return false;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != testHash[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public User register(String username, String password) {
        Session session = sqlDataSource.getSession();

        User user = new User();
        user.setUsername(username);

        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);

        SecretKeyFactory keyFactory;
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (Exception ignored) {
            // Should never happen
            System.exit(1);
            return null;
        }

        byte[] hash;
        try {
            hash = keyFactory.generateSecret(keySpec).getEncoded();
        } catch (Exception ignored) {
            // Should never happen
            System.exit(1);
            return null;
        }

        Base64.Encoder encoder = Base64.getEncoder();

        user.setSalt(encoder.encodeToString(salt));
        user.setPassword(encoder.encodeToString(hash));

        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();

        return user;
    }
}
