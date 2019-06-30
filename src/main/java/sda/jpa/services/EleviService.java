package sda.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.jpa.entity.Elevi;
import sda.jpa.model.ClasaDTO;
import sda.jpa.model.EleviDTO;
import sda.jpa.repository.EleviRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EleviService {

    @Autowired
    EleviRepository eleviRepository;

    public List<EleviDTO> getEleviByClassName(String className) {
        List<Elevi> byClasa_numeClasa = eleviRepository.findByClasa_NumeClasa(className);
        List<EleviDTO> eleviDTOS = new ArrayList<>();

        for (Elevi e : byClasa_numeClasa) {
            eleviDTOS.add(new EleviDTO(e.getNumeElev(), e.getIdElev()));
        }

        return eleviDTOS;
    }


}
