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
public class CategoriePenchere {
    String typecategorie;
    int nbcategorie;

    public String getTypecategorie() {
        return typecategorie;
    }

    public void setTypecategorie(String typecategorie) {
        this.typecategorie = typecategorie;
    }

    public int getNbcategorie() {
        return nbcategorie;
    }

    public void setNbcategorie(int nbcategorie) {
        this.nbcategorie = nbcategorie;
    }

    public static DataRetour<List<CategoriePenchere>> listCategoriePEnchere() throws Exception {
        Connexion c = new Connexion();
        List<CategoriePenchere> l = new ArrayList<>();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try {
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "select * from CategoriePenchere";
            result = stat.executeQuery(requete);
            while (result.next()) {
                CategoriePenchere categoriepenchere = new CategoriePenchere();
                categoriepenchere.setNbcategorie(result.getInt("nbcategorie"));
                categoriepenchere.setTypecategorie(result.getString("typecategorie"));

                l.add(categoriepenchere);
            }
        } catch (SQLException e) {
        } finally {
            if (result != null) {
                result.close();
            }
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
        return new DataRetour<List<CategoriePenchere>>(l);
    }

}
