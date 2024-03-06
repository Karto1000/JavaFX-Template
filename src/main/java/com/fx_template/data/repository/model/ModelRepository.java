package com.fx_template.data.repository.model;

import com.fx_template.models.Model;

import java.util.Optional;

public interface ModelRepository {
    Optional<Model> getModel(Integer id);
}
