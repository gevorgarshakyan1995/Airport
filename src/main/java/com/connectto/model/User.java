package com.connectto.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Book> book;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_authoriti",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authoriti_id"))
    private List<Authority> authoriti;
}