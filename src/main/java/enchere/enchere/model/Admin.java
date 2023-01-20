package enchere.enchere.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enchere.enchere.connexion.Connexion;

public class Admin {
    private long id;
    private String logins;
    private String mdp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogins() {
        return logins;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public static Admin login(String logins, String mdp) throws Exception {
        Connexion c = new Connexion();
        PreparedStatement stat = null;
        Connection co = null;
        ResultSet rs = null;
        Admin admin = null;

        try {
            co = c.getConnection();
            String requete = "select * from Admin where logins=? and mdp=md5(?)";
            stat = co.prepareStatement(requete);
            stat.setString(1, logins);
            stat.setString(2, mdp);
            System.out.println(stat);
            rs = stat.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getLong("id"));
                admin.setLogins(rs.getString("logins"));
                admin.setMdp(rs.getString("mdp"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                stat.close();
            }
            co.close();
        }
        return admin;
    }
}
