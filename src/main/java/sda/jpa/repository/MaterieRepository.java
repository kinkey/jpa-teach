package sda.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sda.jpa.entity.Materie;

import java.util.List;

public interface MaterieRepository extends CrudRepository<Materie, Integer> {

    @Query(
            value = "select  m.idMaterie, m.numeMaterie from note" +
                    " join materie m on note.idMaterie = m.idMaterie" +
                    " join elevi e on note.idElev = e.idElev where e.idElev=?1",
            nativeQuery = true)
    List<Materie> findMaterieWhereElevHasNote(Integer idElev);
}
