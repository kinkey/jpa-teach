package sda.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sda.jpa.model.MaterieDTO;
import sda.jpa.services.MaterieService;

import java.util.List;

@Controller
public class MaterieController {

    @Autowired
    MaterieService materieService;

    @GetMapping("/materie/{elevId}")
    public String homePage(Model model, @PathVariable("elevId") Integer elevId) {
        List<MaterieDTO> activeMateriiByElevId = materieService.getActiveMateriiByElevId(elevId);

        model.addAttribute("materii", activeMateriiByElevId);
        model.addAttribute("elevId", elevId);
        return "materie";
    }
}
