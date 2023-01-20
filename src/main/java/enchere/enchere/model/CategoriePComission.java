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
public class CategoriePComission {
    String typecategorie;
    int pourcentage;

    public String getTypecategorie() {
        return typecategorie;
    }

    public void setTypecategorie(String typecategorie) {
        this.typecategorie = typecategorie;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public static DataRetour<List<CategoriePComission>> listCategoriePComission() throws Exception{
        Connexion c=new Connexion();
        List<CategoriePComission> l = new ArrayList<>();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try{
            co = c.getConnection();
            stat = co.createStatement();
            String requete = "select*from CategoriePComission";
            result = stat.executeQuery(requete);
            while(result.next()){
                CategoriePComission categoriepcomission = new CategoriePComission();
                categoriepcomission.setPourcentage(result.getInt("pourcentage"));
                categoriepcomission.setTypecategorie(result.getString("typecategorie"));
                l.add(categoriepcomission);
            }
        }catch(SQLException e){}
        finally{
            if(result != null){
                result.close();
            }
            if(stat != null){
                stat.close();
            }
            co.close();
        }
        return new DataRetour<List<CategoriePComission>>(l);
    }


}
