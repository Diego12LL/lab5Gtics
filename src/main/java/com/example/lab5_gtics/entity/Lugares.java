package com.example.lab5_gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "lugares")
@Getter
@Setter
public class Lugares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares",nullable = false)
    private Integer idlugar;

    @Column(name = "nombre_lugar",nullable = false,length =45)
    private String nombrelugar;

    @Column(name = "descrip_lugar",nullable = false,length =45)
    private String descriplugar;

    @Column(name = "fecha_lugar",nullable = false)
    private Date fechalugar;

}
