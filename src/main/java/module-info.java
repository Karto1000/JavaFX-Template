module com.fx_template {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    requires mysql.connector.j;
    requires jakarta.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;

    requires static lombok;

    opens com.fx_template.controller to javafx.fxml;
    opens com.fx_template.models;

    exports com.fx_template.data;
    exports com.fx_template.models;
    exports com.fx_template.controller;

    exports com.fx_template.data.repository.model;
    exports com.fx_template.data.repository.user;

    exports com.fx_template;
}