package com.fx_template.data;

import com.fx_template.data.repository.model.MemoryModelRepository;
import com.fx_template.data.repository.model.ModelRepository;
import com.fx_template.data.repository.user.MemoryUserRepository;
import com.fx_template.data.repository.user.UserRepository;
import com.fx_template.models.Model;

import java.util.HashMap;

public class MemoryDatasource implements Datasource {
    private final MemoryModelRepository memoryModelRepository = new MemoryModelRepository();
    private final MemoryUserRepository memoryUserRepository = new MemoryUserRepository();

    @Override
    public ModelRepository models() {
        return memoryModelRepository;
    }

    @Override
    public UserRepository users() {
        return memoryUserRepository;
    }
}
