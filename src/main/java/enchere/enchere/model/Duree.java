package enchere.enchere.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import enchere.enchere.connexion.Connexion;

public class Duree implements Serializable {
    private int id;
    private int dureemin;
    private int dureemax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDureemin() {
        return dureemin;
    }

    public void setDureemin(int dureemin) {
        this.dureemin = dureemin;
    }

    public int getDureemax() {
        return dureemax;
    }

    public void setDureemax(int dureemax) {
        this.dureemax = dureemax;
    }

    public Duree(int id, int dureemin, int dureemax) {
        this.id = id;
        this.dureemin = dureemin;
        this.dureemax = dureemax;
    }

    public Duree() {
    }

    public static void modifDuree(Duree d) throws Exception {
        PreparedStatement stat = null;
        Connection co = null;

        try {
            co = Connexion.getConnection();
            String requete = "update duree set dureemin=?,dureemax=?,datechangement=default";
            stat = co.prepareStatement(requete);
            stat.setInt(1, (int) d.getDureemin());
            stat.setInt(2, (int) d.getDureemax());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
    }

    public static Duree getCurrent() throws Exception {
        Statement stat = null;
        Connection co = null;
        ResultSet result = null;
        Duree d = new Duree();
        try {
            co = Connexion.getConnection();
            stat = co.createStatement();
            String requete = "select*from Duree";
            result = stat.executeQuery(requete);
            if (result.next()) {
                d.setDureemax(result.getInt("dureemax"));
                d.setDureemin(result.getInt("dureemin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
        return d;
    }
}
