package testDao;

import dao.DaoCycliste;
import entites.TCycliste;
import jpaDao.JpaDaoCycliste;

public class testDaoCycliste {

    public static void main(String[] args) {

        // Create
        DaoCycliste cyclisteManager = new JpaDaoCycliste();
        TCycliste toto = new TCycliste();
        toto.setNom("nada");
        toto.setAge(23);
        toto.setPrenom("dd");
        cyclisteManager.create(toto);

        // Update
        toto.setPrenom("Gautier");
        cyclisteManager.update(toto);

        // Delete
        //categorieManager.delete(maCategorie);

        // Find all
        //System.out.println(categorieManager.findAll(TCategorie.class).toString());
        //System.out.println(categorieManager.findAll(TCompetence.class).toString());


        // Nombre de competences

        // Fermeture de la session
        //categorieManager.close();




    }
}

