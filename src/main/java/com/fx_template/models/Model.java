package com.fx_template.models;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "model")
@Table(name = "models")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer testId;

    @Column(name = "field", nullable = false)
    private String test;
}
