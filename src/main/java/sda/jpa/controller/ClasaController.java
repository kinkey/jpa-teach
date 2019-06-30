package sda.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import sda.jpa.model.ClasaDTO;
import sda.jpa.services.ClasaService;

@Controller
public class ClasaController {

    @Autowired
    ClasaService clasaService;

    @GetMapping("/clasa/{clasaId}")
    public String homePage(Model model, @PathVariable("clasaId") Integer clasaId) {
        ClasaDTO clasaById = clasaService.getClasaById(clasaId);

        model.addAttribute("clasaName", clasaById.numeClasa);
        return "home";
    }

    @GetMapping("/clase")
    public String homePage(Model model) {
        List<ClasaDTO> allClase = clasaService.getAllClase();
        System.out.println("Some other message");
        model.addAttribute("clase", allClase);

        return "home2";

    }

    @GetMapping(name = "/clase/json",produces = "application/json")
    @ResponseBody
    public List<ClasaDTO> getAllClase() {
        List<ClasaDTO> allClase = clasaService.getAllClase();

        return allClase;
    }
}
