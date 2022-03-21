package Import;

import dao.DaoCycliste;
import entites.TCycliste;
import jpaDao.JpaDaoCycliste;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;


public class Import2 {

    public static void importJson() throws SQLException {

        JSONParser jsonP = new JSONParser();
        try {

            // GET squadName
            JSONObject jsonO = (JSONObject) jsonP.parse(new FileReader("/home/gautier/Documents/LA2/POO/ctp-demo/src/data/data-2.json"));
            String squadName = (String) jsonO.get("squadName");
            System.out.println(squadName);

            // Importer les cyclistes du json data-2.json
            JSONArray tableau_des_membres = (JSONArray) jsonO.get("members");
            System.out.println(tableau_des_membres);

            // Itteration sur tous les membres
            JSONObject o;
            Iterator iterator = tableau_des_membres.iterator();
            while (iterator.hasNext()) {

                o = (JSONObject) iterator.next();
                System.out.println(o);

                DaoCycliste cyclisteManager = new JpaDaoCycliste();
                TCycliste toto = new TCycliste();

                // Avec les arguements que l'on recup
                toto.setNom((String) o.get("nom")); // OK
                toto.setPrenom((String) o.get("prenom")); // OK

                // Recuperer l'age
                int age = Integer.parseInt(String.valueOf(o.get("age"))); // OK
                toto.setAge(age); // OK

                cyclisteManager.create(toto);

            }


            } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            importJson();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
