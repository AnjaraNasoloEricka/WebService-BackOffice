package enchere.enchere.model;

import java.sql.Statement;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enchere.enchere.connexion.Connexion;
import enchere.enchere.retour.DataRetour;

public class Categorie implements Serializable {
    private long id;
    private String typeCategorie;

    public Categorie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeCategorie() {
        return typeCategorie;
    }

    public void setTypeCategorie(String typeCategorie) {
        this.typeCategorie = typeCategorie;
    }

    public static void insertCategorie(Categorie ctg) throws Exception {
        PreparedStatement stat = null;
        Connection co = null;

        try {
            co = Connexion.getConnection();
            String requete = "INSERT INTO Categorie VALUES(default,?)";
            stat = co.prepareStatement(requete);
            stat.setString(1, ctg.getTypeCategorie());
            stat.executeUpdate();
        } catch (SQLException e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
    }

    public static void modifCategorie(int id, Categorie ctg) throws Exception {
        PreparedStatement stat = null;
        Connection co = null;

        try {
            co = Connexion.getConnection();
            String requete = "update Categorie set id=?,typecategorie=? where id=" + id;
            stat = co.prepareStatement(requete);
            stat.setInt(1, (int) ctg.getId());
            stat.setString(2, ctg.getTypeCategorie());
            stat.executeUpdate();
        } catch (SQLException e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
    }

    public static void deleteCategorie(int id) throws Exception {
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try {
            co = Connexion.getConnection();
            stat = co.createStatement();
            String requete = "delete from Categorie where id=" + id;
            stat.executeUpdate(requete);
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
    }

    public static DataRetour<ArrayList<Categorie>> listCategorie() throws Exception {
        ArrayList<Categorie> listC = new ArrayList<Categorie>();
        Statement stat = null;
        ResultSet result = null;
        Connection co = null;

        try {
            co = Connexion.getConnection();
            stat = co.createStatement();
            String requete = "select*from categorie";
            result = stat.executeQuery(requete);
            while (result.next()) {
                Categorie ctg = new Categorie();
                ctg.setId(result.getInt("id"));
                ctg.setTypeCategorie(result.getString("typecategorie"));
                listC.add(ctg);
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
        return new DataRetour<ArrayList<Categorie>>(listC);
    }

}
