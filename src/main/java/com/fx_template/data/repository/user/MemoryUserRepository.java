package com.fx_template.data.repository.user;

public class MemoryUserRepository implements UserRepository {
    @Override
    public boolean login(String username, String password) {
        return true;
    }
}
