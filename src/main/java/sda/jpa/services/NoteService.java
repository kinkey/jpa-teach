package sda.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.jpa.entity.Note;
import sda.jpa.model.NoteDTO;
import sda.jpa.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<NoteDTO> getNoteForStudentIdAndMaterieName(Integer studentId,
                                                           String materieName) {
        List<Note> noteByStudentIdAndMaterieNume = noteRepository.getNoteByStudentIdAndMaterieNume(studentId, materieName);
        List<NoteDTO> noteDTOS = new ArrayList<>();
        for (Note n : noteByStudentIdAndMaterieNume) {
            noteDTOS.add(new NoteDTO(n.getValoareNota(), n.getProfesorName()));
        }

        return noteDTOS;
    }
}
