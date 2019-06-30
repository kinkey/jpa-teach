package sda.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.jpa.entity.Materie;
import sda.jpa.model.MaterieDTO;
import sda.jpa.repository.MaterieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterieService {

    @Autowired
    MaterieRepository materieRepository;


    public List<MaterieDTO> getActiveMateriiByElevId(Integer elevId) {

        List<Materie> materieWhereElevHasNote = materieRepository.findMaterieWhereElevHasNote(elevId);

        List<Materie> listWithoutDuplicates = materieWhereElevHasNote.stream()
                .distinct()
                .collect(Collectors.toList());


        List<MaterieDTO> materieDTOS = new ArrayList<>();

        for (Materie m : listWithoutDuplicates) {
            materieDTOS.add(new MaterieDTO(m.getNumeMaterie(), m.getNumeMaterie().toLowerCase()));
        }

        return materieDTOS;
    }


}
