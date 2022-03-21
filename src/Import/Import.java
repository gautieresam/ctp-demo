package Import;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;


public class Import {

    public static void importJson() throws SQLException {

        JSONParser jsonP = new JSONParser();
        try {

            JSONObject jsonO = (JSONObject) jsonP.parse(new FileReader("/home/gautier/Documents/LA2/POO/ctp-demo/src/data/data.json"));
            String id_competition = (String) jsonO.get("id_competition");
            System.out.println(id_competition);

            String adresse_competition = (String) jsonO.get("adresse_competition");
            System.out.println(adresse_competition);

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
