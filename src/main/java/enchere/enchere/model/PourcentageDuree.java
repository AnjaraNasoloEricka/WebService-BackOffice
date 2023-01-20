package enchere.enchere.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enchere.enchere.connexion.Connexion;

public class PourcentageDuree {
    private long id;
    private double pourcentage;

    // getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    // select pourcentage function
    public static PourcentageDuree selectPourcentage() throws Exception {
        Connexion c = new Connexion();
        PreparedStatement stat = null;
        Connection co = null;
        ResultSet rs = null;
        PourcentageDuree pourcentageDuree = null;

        try {
            co = c.getConnection();
            String requete = "select * from PourcentageDuree";
            stat = co.prepareStatement(requete);
            rs = stat.executeQuery();
            if (rs.next()) {
                pourcentageDuree = new PourcentageDuree();
                pourcentageDuree.setId(rs.getLong("id"));
                pourcentageDuree.setPourcentage(rs.getDouble("pourcentage"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
        return pourcentageDuree;
    }

    // update pourcentage function
    public static void updatePourcentage(PourcentageDuree pourcentageDuree) throws Exception {
        Connexion c = new Connexion();
        PreparedStatement stat = null;
        Connection co = null;

        try {
            co = c.getConnection();
            String requete = "update PourcentageDuree set pourcentage=? where id=1;";
            stat = co.prepareStatement(requete);
            stat.setDouble(1, pourcentageDuree.getPourcentage());
            System.out.println(requete);
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
}
