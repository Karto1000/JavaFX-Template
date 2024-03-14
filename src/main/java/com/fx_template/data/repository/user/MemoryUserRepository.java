package com.fx_template.data.repository.user;

import com.fx_template.models.User;

public class MemoryUserRepository implements UserRepository {
    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public User register(String username, String password) {
        return null;
    }

    @Override
    public User get(String username) {
        return null;
    }
}
