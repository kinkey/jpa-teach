package sda.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sda.jpa.model.MaterieDTO;
import sda.jpa.model.NoteDTO;
import sda.jpa.services.MaterieService;
import sda.jpa.services.NoteService;

import java.util.List;

@Controller
public class NoteControler {
    @Autowired
    NoteService noteService;

    @GetMapping("/note/{elevId}/{materieNume}")
    public String homePage(Model model, @PathVariable("elevId") Integer elevId,
                           @PathVariable("materieNume") String materieNume) {
        List<NoteDTO> note = noteService.getNoteForStudentIdAndMaterieName(elevId, materieNume);

        model.addAttribute("note", note);
        return "note";
    }
}
