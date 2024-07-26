package br.com.fk.churchmanagement.api.entity;

import jakarta.persistence.*;

@Entity(name = "config")
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String term;

    private String value;

}
