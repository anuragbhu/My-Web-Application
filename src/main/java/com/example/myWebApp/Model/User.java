package com.example.myWebApp.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(nullable = false, name = "first_name", length = 45)
    private String firstName;

    @Column(nullable = false, name = "last_name", length = 45)
    private String lastName;

    @Column(name = "enabled", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean enabled;
}
