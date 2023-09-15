package com.example.lab5_gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "mascotas")
@Getter
@Setter
public class Mascotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascotas",nullable = false)
    private Integer idmascota;

    @Column(name = "nombre_mascota",nullable = false,length =45)
    private String nombremascota;
    @Column(name = "genero",nullable = false,length =45)
    private String genero;

    @Column(name = "edad",nullable = false,length =45)
    private String edad;

    @Column(name = "fecha_nacimiento",nullable = false,length =45)
    private String fechanacimiento;

    @Column(name = "Vacunado",nullable = false,length =45)
    private String vacunado;

    @Column(name = "Desparasitado",nullable = false,length =45)
    private String desparasitado;
    @ManyToOne
    @JoinColumn(name = "Persona_idPersona",nullable = false)
    private Persona dueno;


}
