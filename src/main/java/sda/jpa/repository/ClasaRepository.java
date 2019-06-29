package sda.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sda.jpa.entity.Clasa;

public interface ClasaRepository extends JpaRepository<Clasa, Integer> {

    Clasa findClasaByNumeClasaAndIdClasa(String a, Integer b);


    List<Clasa> findByOrderByNumeClasaAsc();
}
