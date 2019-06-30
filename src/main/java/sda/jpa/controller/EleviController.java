package sda.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sda.jpa.model.EleviDTO;
import sda.jpa.services.EleviService;

import java.util.List;

@Controller
public class EleviController {

    @Autowired
    EleviService eleviService;

    @GetMapping("/elevi/{className}")
    public String homePage(Model model, @PathVariable("className") String className) {
        List<EleviDTO> elevi = eleviService.getEleviByClassName(className);

        model.addAttribute("elevi", elevi);
        return "elevi";
    }
}
