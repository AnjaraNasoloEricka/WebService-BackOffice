/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.enchere.model;

import enchere.enchere.connexion.Connexion;
import enchere.enchere.retour.DataRetour;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author P14A-GOLD
 */
public class listeCategorieComission {
    String typecategorie;

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypecategorie() {
        return typecategorie;
    }

    public void setTypecategorie(String typecategorie) {
        this.typecategorie = typecategorie;
    }

    public static DataRetour<List<listeCategorieComission>> listeCategorieComission() throws Exception {
        Connexion c = new Connexion();
        List<listeCategorieComission> l = new ArrayList<>();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try {
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "select * from testview ";
            System.out.println(requete);
            result = stat.executeQuery(requete);
            System.out.println("tafaaaa");
            while (result.next()) {

                listeCategorieComission listecategorie = new listeCategorieComission();
                listecategorie.setTypecategorie(result.getString("typecategorie"));
                listecategorie.setId(result.getInt("id"));

                l.add(listecategorie);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                result.close();
            }
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
        return new DataRetour<List<listeCategorieComission>>(l);
    }

}
