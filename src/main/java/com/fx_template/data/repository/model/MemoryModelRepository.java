package com.fx_template.data.repository.model;

import com.fx_template.models.Model;

import java.util.HashMap;
import java.util.Optional;

public class MemoryModelRepository implements ModelRepository {
    private final HashMap<Integer, Model> models = new HashMap<>();
    @Override
    public Optional<Model> getModel(Integer id) {
        return Optional.ofNullable(models.get(id));
    }
}
