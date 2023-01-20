package mapping;

import connexion.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComissionCategorie {
    int id;
    int idCategorie ;
    float pourcentage ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }

    public static void modifComissionCategorie(int idCategorie,ComissionCategorie v) throws Exception{
        Connexion c=new Connexion();
        PreparedStatement stat = null;
        Connection co = null;

        try{
            co = c.getConnection();
            String requete = "update Comission_Categorie set pourcentage=? where idCategorie="+idCategorie+";";
            stat = co.prepareStatement(requete);
            stat.setFloat(1,v.getPourcentage());
            stat.executeUpdate();
        }catch(SQLException e){}
        finally{
            if(stat != null){
                stat.close();
            }
            co.close();
        }
    }
}
