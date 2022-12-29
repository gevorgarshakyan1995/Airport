package com.connectto.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    }