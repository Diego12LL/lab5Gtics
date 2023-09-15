package com.example.lab5_gtics.controllers;

import com.example.lab5_gtics.entity.Viajes;
import com.example.lab5_gtics.repository.LugaresRepository;
import com.example.lab5_gtics.repository.PersonaRepository;
import com.example.lab5_gtics.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ViajesController {


    final ViajesRepository viajesRepository;
    final PersonaRepository personaRepository;
    final LugaresRepository lugaresRepository;
    public ViajesController(ViajesRepository viajesRepository, PersonaRepository personaRepository, LugaresRepository lugaresRepository) {
        this.viajesRepository =viajesRepository ;
        this.personaRepository=personaRepository;
        this.lugaresRepository=lugaresRepository;
    }
    @GetMapping(value = { "/listaViajes"})
    public String listaViajes(Model model) {
        model.addAttribute("listaViajes", viajesRepository.findAll());

        return "lab5/listaViajes";
    }

    @GetMapping(value = { "/newViaje"})
    public String newViaje(Model model) {

        model.addAttribute("listaPersonas", personaRepository.findAll());
        model.addAttribute("listaLugares", lugaresRepository.findAll());
        return "lab5/crearViaje";
    }

    @PostMapping("/guardarViaje")
    public String guardarViaje(Viajes viaje, RedirectAttributes attr) {
        viajesRepository.save(viaje);
        return "redirect:/listaViajes";
    }


    @GetMapping("/editarViaje")
    public String editarViaje(Model model, @RequestParam("id") int id) {

        Optional<Viajes> optViaje = viajesRepository.findById(id);


        if (optViaje.isPresent()) {
            Viajes viaje = optViaje.get();
            model.addAttribute("listaPersonas", personaRepository.findAll());
            model.addAttribute("listaLugares", lugaresRepository.findAll());
            model.addAttribute("viaje", viaje);
            return "lab5/editarViaje";
        } else {
            return "redirect:/listaViajes";
        }
    }

    @PostMapping("/actualizarViaje")
    public String actualizarViaje(Viajes viaje,@RequestParam("persona") int idPersona, @RequestParam("lugar") int idLugar) {

        viajesRepository.actualizarViaje(viaje.getPuntorecojo(), viaje.getCantpersonas(), viaje.getCantperros(),idPersona, idLugar, viaje.getIdviaje() );

        return "redirect:/listaViajes";
    }




    @GetMapping(value = { "/newMascota"})
    public String newMascota(Model model) {

        model.addAttribute("listaPersonas", personaRepository.findAll());
        model.addAttribute("listaLugares", lugaresRepository.findAll());
        return "lab5/crearViaje";
    }



    @GetMapping("/eliminarViaje")
    public String eliminarViaje(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Viajes> optViaje = viajesRepository.findById(id);

        if (optViaje.isPresent()) {
            viajesRepository.deleteById(id);
        }
        return "redirect:/listaViajes";

    }


}
