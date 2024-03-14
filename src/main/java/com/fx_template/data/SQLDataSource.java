package com.fx_template.data;

import com.fx_template.data.repository.model.ModelRepository;
import com.fx_template.data.repository.model.SqlModelRepository;
import com.fx_template.data.repository.user.SqlUserRepository;
import com.fx_template.data.repository.user.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SQLDataSource implements Datasource {
    private SessionFactory sessionFactory;
    private SqlModelRepository sqlModelRepository;
    private SqlUserRepository sqlUserRepository;

    public Session getSession() {
        if (sessionFactory == null) {
            init();
        }
        return sessionFactory.openSession();
    }

    @Override
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        this.sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        sqlModelRepository = new SqlModelRepository(this);
        sqlUserRepository = new SqlUserRepository(this);

        // Create admin user
        if (!sqlUserRepository.login("admin", "admin")) {
            sqlUserRepository.register("admin", "admin");
        }
    }

    @Override
    public ModelRepository models() {
        return sqlModelRepository;
    }

    @Override
    public UserRepository users() {
        return sqlUserRepository;
    }
}
