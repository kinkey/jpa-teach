package sda.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import sda.jpa.entity.Elevi;

import java.util.List;

public interface EleviRepository extends CrudRepository<Elevi, Integer> {

    List<Elevi> findByClasa_NumeClasa(String numeClasa);

}
