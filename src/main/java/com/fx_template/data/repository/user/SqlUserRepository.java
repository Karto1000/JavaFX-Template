package com.fx_template.data.repository.user;

import com.fx_template.data.SQLDataSource;

public class SqlUserRepository implements UserRepository {
    private final SQLDataSource sqlDataSource;

    public SqlUserRepository(SQLDataSource sqlDataSource) {
        this.sqlDataSource = sqlDataSource;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }
}
