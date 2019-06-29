package sda.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sda.jpa.model.ClasaDTO;
import sda.jpa.entity.Clasa;
import sda.jpa.repository.ClasaRepository;

@Service
public class ClasaService {

    @Autowired
    ClasaRepository clasaRepository;

    public ClasaDTO getClasaById(Integer id) {
        Optional<Clasa> byId = clasaRepository.findById(id);

        if (byId.isPresent()) {
            return new ClasaDTO(byId.get().numeClasa);
        }
        return new ClasaDTO("Nu exista");

    }

    public List<ClasaDTO> getAllClase(){
        List<ClasaDTO> allClase = new ArrayList<>();

        List<Clasa> all = clasaRepository.findByOrderByNumeClasaAsc();

        for(Clasa c : all){
            allClase.add(new ClasaDTO(c.numeClasa));
        }

        return allClase;
    }

}
