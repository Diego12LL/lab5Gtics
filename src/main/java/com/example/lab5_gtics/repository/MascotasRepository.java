package com.example.lab5_gtics.repository;
import com.example.lab5_gtics.entity.Mascotas;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MascotasRepository extends JpaRepository<Mascotas, Integer> {
}
