package com.example.lab5_gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona",nullable = false)
    private Integer idpersona;

    @Column(name = "nombre",nullable = false,length =45)
    private String nombrepersona;

    @Column(name = "dni",nullable = false,length =45)
    private String dni;

    @Column(name = "celular",nullable = false,length =45)
    private String celular;

    @Column(name = "tipo_persona",nullable = false,length =45)
    private String tipopersona;


}