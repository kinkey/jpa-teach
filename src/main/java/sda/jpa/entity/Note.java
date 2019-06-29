package sda.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="note")
public class Note {

    @Id
    @Column(name = "idNote",
            unique = true,
            nullable = false)
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    Integer idNote;

    @Column(name="valoareNota")
    Integer valoareNota;

    @ManyToOne
    @JoinColumn(name = "idProfesor")
    Profesori profesori;

    @ManyToOne
    @JoinColumn(name = "idMaterie")
    Materie materie;

    @ManyToOne
    @JoinColumn(name = "idElev")
    Elevi elevi;

    @Override
    public String toString() {
        return "Note{" +
                "idNote=" + idNote +
                ",\n  valoareNota='" + valoareNota + '\'' +
                ",\n  profesor=" + profesori.numeProfesor +
                ",\n  materie=" + materie.numeMaterie +
                ",\n  elev=" + elevi.numeElev +
                '}';
    }
}
