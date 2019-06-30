package sda.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.jpa.entity.Note;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {


    @Query(value = "" +
            "select * from note" +
            " join elevi e on note.idElev = e.idElev" +
            " join materie m on note.idMaterie = m.idMaterie" +
            " join profesori p on m.idMaterie = p.idMateriePredata" +
            " where note.idProfesor = p.idProfesor and" +
            "  e.idElev=?1 and m.numeMaterie=?2", nativeQuery = true)
    List<Note> getNoteByStudentIdAndMaterieNume(Integer studentId,
                                                String materieNume);

}
