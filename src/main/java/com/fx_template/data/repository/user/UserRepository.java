package com.fx_template.data.repository.user;

import com.fx_template.models.User;

public interface UserRepository {
    boolean login(String username, String password);

    User register(String username, String password);

    User get(String username);
}
