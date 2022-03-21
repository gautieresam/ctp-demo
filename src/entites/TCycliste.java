package entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_CYCLISTE", schema = "cyclisme", catalog = "")
public class TCycliste {
    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;
    @Basic
    @Column(name = "age", nullable = false)
    private int age;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic
    @Column(name = "id", nullable = false)
    private int id;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TCycliste tCycliste = (TCycliste) o;
        return age == tCycliste.age && Objects.equals(nom, tCycliste.nom) && Objects.equals(prenom, tCycliste.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
