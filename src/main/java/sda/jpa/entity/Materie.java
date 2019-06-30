package sda.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="materie")
public class Materie {

    @Id
    @Column(name = "idMaterie",
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
    Integer idMaterie;

    String numeMaterie;

    @OneToMany(mappedBy = "materie")
    List<Profesori> profesoriList;

    @OneToMany(mappedBy = "materie")
    List<Note> note;

    @OneToMany(mappedBy = "materie", fetch = FetchType.EAGER)
    List<Medii> medii;

    public Materie() {
    }

    public Materie(String numeMaterie) {
        this.numeMaterie = numeMaterie;
    }

    @Override
    public String toString() {
        return "Materie{" +
                "idMaterie=" + idMaterie +
                ", numeMaterie='" + numeMaterie + '\'' +
                //", profesoriList=" + profesoriList +
                ", note=" + //note +
                ", medii=" + medii +
                '}';
    }

    public Integer getIdMaterie() {
        return idMaterie;
    }

    public String getNumeMaterie() {
        return numeMaterie;
    }
}
