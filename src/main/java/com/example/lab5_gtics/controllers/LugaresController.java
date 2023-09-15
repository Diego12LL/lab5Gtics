package com.example.lab5_gtics.controllers;

import com.example.lab5_gtics.entity.Lugares;
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
public class LugaresController {
    final ViajesRepository viajesRepository;
    final PersonaRepository personaRepository;
    final LugaresRepository lugaresRepository;
    final MascotasRepository mascotasRepository;

    public LugaresController(ViajesRepository viajesRepository, PersonaRepository personaRepository, LugaresRepository lugaresRepository, MascotasRepository mascotasRepository) {
        this.viajesRepository = viajesRepository;
        this.personaRepository = personaRepository;
        this.lugaresRepository = lugaresRepository;
        this.mascotasRepository = mascotasRepository;
    }

    @GetMapping(value = {"/pagPrincipal"})
    public String verPagPrincipal(Model model) {
        return "lab5/pagPrincipal";
    }

    @GetMapping(value = {"/listaLugares"})
    public String listaLugares(Model model) {
        model.addAttribute("listaLugares", lugaresRepository.findAll());

        return "lab5/listaLugares";
    }


    @GetMapping("/eliminarLugar")
    public String eliminarLugar(Model model,
                                  @RequestParam("id") int id,
                                  RedirectAttributes attr) {

        Optional<Lugares> optLugar = lugaresRepository.findById(id);

        if (optLugar.isPresent()) {
            lugaresRepository.deleteById(id);
        }
        return "redirect:/listaLugares";

    }
}