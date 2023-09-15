package com.example.lab5_gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "viajes")
@Getter
@Setter
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes",nullable = false)
    private Integer idviaje;

    @Column(name = "punto_Recojo",nullable = false,length =45)
    private String puntorecojo;

    @Column(name = "cant_personas",nullable = false)
    private String cantpersonas;

    @Column(name = "cant_perros",nullable = false)
    private String cantperros;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona",nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "Lugares_idLugares",nullable = false)
    private Lugares lugar;


}
