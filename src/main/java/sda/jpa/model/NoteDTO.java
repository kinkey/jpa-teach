package sda.jpa.model;

public class NoteDTO {


    public NoteDTO(Integer noteValue, String profesorName) {
        this.noteValue = noteValue;
        this.profesorName = profesorName;
    }

    public Integer noteValue;
    public String profesorName;
}
