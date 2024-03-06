package com.fx_template.data.repository.model;

import com.fx_template.data.SQLDataSource;
import com.fx_template.models.Model;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class SqlModelRepository implements ModelRepository {
    private final SQLDataSource sqlDataSource;

    public SqlModelRepository(SQLDataSource sqlDataSource) {
        this.sqlDataSource = sqlDataSource;
    }

    @Override
    public Optional<Model> getModel(Integer id) {
        Session session = this.sqlDataSource.getSession();

        try {
            Query<Model> query = session.createQuery("FROM model WHERE testId = :id", Model.class);
            query.setParameter("id", id);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
