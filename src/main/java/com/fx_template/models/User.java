package com.fx_template.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String salt;
}
