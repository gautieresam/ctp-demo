package metier;

import java.util.Objects;

public class cycliste {

    private int numDossard ;
    private String nomCycliste;

    public int getNumDossard() {
        return numDossard;
    }

    // Pour instancier
    public cycliste(){

    }

    // PAs de JPQL design pattern à mettre en place
    //  Kahoot voir les json comment on fait

    public String getNomCycliste() {
        return nomCycliste;
    }

    public void setNumDossard(int numDossard) {
        this.numDossard = numDossard;
    }

    public void setNomCycliste(String nomCycliste) {
        this.nomCycliste = nomCycliste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cycliste cycliste = (cycliste) o;
        return numDossard == cycliste.numDossard && Objects.equals(nomCycliste, cycliste.nomCycliste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numDossard, nomCycliste);
    }

    @Override
    public String toString() {
        return "cycliste{" +
                "numDossard=" + numDossard +
                ", nomCycliste='" + nomCycliste + '\'' +
                '}';
    }
}
