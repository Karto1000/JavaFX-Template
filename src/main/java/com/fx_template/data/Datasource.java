package com.fx_template.data;


import com.fx_template.data.repository.model.ModelRepository;
import com.fx_template.data.repository.user.UserRepository;

public interface Datasource {
    /**
     * Initialize the Datasource
     */
    default void init() {
    }

    /**
     * Get the ModelRepository
     *
     * @return The ModelRepository
     */
    ModelRepository models();

    UserRepository users();
}
