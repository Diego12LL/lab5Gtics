package com.example.lab5_gtics.controllers;

import com.example.lab5_gtics.entity.Mascotas;
import com.example.lab5_gtics.entity.Viajes;
import com.example.lab5_gtics.repository.LugaresRepository;
import com.example.lab5_gtics.repository.MascotasRepository;
import com.example.lab5_gtics.repository.PersonaRepository;
import com.example.lab5_gtics.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MascotaController {
    final ViajesRepository viajesRepository;
    final PersonaRepository personaRepository;
    final LugaresRepository lugaresRepository;
    final MascotasRepository mascotasRepository;
    public MascotaController(ViajesRepository viajesRepository, PersonaRepository personaRepository, LugaresRepository lugaresRepository, MascotasRepository mascotasRepository) {
        this.viajesRepository =viajesRepository ;
        this.personaRepository=personaRepository;
        this.lugaresRepository=lugaresRepository;
        this.mascotasRepository=mascotasRepository;
    }
    @GetMapping(value = { "/listaMascotas"})
    public String listaMascotas(Model model) {
        model.addAttribute("listaMascotas", mascotasRepository.findAll());

        return "lab5/listaMascotas";
    }





    @GetMapping("/eliminarMascotaUU")
    public String eliminarMascota(Model model,
                                @RequestParam("id") int id,
                                RedirectAttributes attr) {

        Optional<Mascotas> optMascota = mascotasRepository.findById(id);

        if (optMascota.isPresent()) {
            mascotasRepository.deleteById(id);
        }
        return "redirect:/listaMascotas";

    }
}
