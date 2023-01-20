package enchere.enchere.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enchere.enchere.connexion.Connexion;
import enchere.enchere.retour.DataRetour;

public class SoldeUtilisateur implements Serializable {
    private int id;
    private int idUtilisateur;
    private String nom;
    private String prenom;
    private String tel;
    private double solde;
    private Date daterecharge;
    private int statut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int stat) {
        this.statut = stat;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDaterecharge() {
        return daterecharge;
    }

    public void setDaterecharge(Date daterecharge) {
        this.daterecharge = daterecharge;
    }

    public SoldeUtilisateur(int id, int idUtilisateur, double solde, Date daterecharge) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.solde = solde;
        this.daterecharge = daterecharge;
    }

    public SoldeUtilisateur() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public static DataRetour<ArrayList<SoldeUtilisateur>> listNonConfirme() throws Exception {
        ArrayList<SoldeUtilisateur> listC = new ArrayList<SoldeUtilisateur>();
        Connection con = Connexion.getConnection();
        try {
            Statement statement = con.createStatement();
            String requete = "select*from V_Solde where statut=0";
            ResultSet resultS = statement.executeQuery(requete);
            while (resultS.next()) {
                SoldeUtilisateur solde = new SoldeUtilisateur();
                solde.setId(resultS.getInt("id"));
                solde.setIdUtilisateur(resultS.getInt("idutilisateur"));
                solde.setNom(resultS.getString("nom"));
                solde.setPrenom(resultS.getString("prenom"));
                solde.setTel(resultS.getString("tel"));
                solde.setSolde(resultS.getDouble("solde"));
                solde.setDaterecharge(resultS.getDate("daterecharge"));
                listC.add(solde);
            }
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DataRetour<ArrayList<SoldeUtilisateur>>(listC);
    }

    public static void updateStatut(int id) throws Exception {
        Connection con = Connexion.getConnection();
        try {
            String requete = "update soldeutilisateur set statut=1 where id=?";
            Statement stat = con.createStatement();
            stat.executeUpdate("BEGIN");
            PreparedStatement statement = con.prepareStatement(requete);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            stat.executeUpdate("COMMIT");
            stat.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSolde(int id) throws Exception {
        Connection con = Connexion.getConnection();
        try {
            String requete = "delete from soldeutilisateur where id=?";
            Statement stat = con.createStatement();
            stat.executeUpdate("BEGIN");
            PreparedStatement statement = con.prepareStatement(requete);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            stat.executeUpdate("COMMIT");
            stat.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
