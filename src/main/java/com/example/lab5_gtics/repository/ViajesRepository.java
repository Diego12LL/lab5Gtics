package com.example.lab5_gtics.repository;

import com.example.lab5_gtics.entity.Lugares;
import com.example.lab5_gtics.entity.Viajes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ViajesRepository extends JpaRepository<Viajes, Integer> {


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE viajes SET punto_recojo = ?1 , cant_personas= ?2 , cant_perros=?3, Persona_idPersona=?4, Lugares_idLugares=?5 WHERE idViajes = ?4")
    void actualizarViaje(String puntoRecojo, String cantPersonas,String catPerros, int idPersona, int idLugar, int idViaje);
}
