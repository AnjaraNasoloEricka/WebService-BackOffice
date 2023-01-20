package enchere.enchere.controller;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enchere.enchere.connexion.Connexion;
import enchere.enchere.model.SoldeUtilisateur;
import enchere.enchere.retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/soldeUtilisateur")
public class SoldeUtilisateurController {

    @GetMapping
    public ResponseEntity<?> selectNotConfirmed() {
        try {
            return new ResponseEntity<>(SoldeUtilisateur.listNonConfirme(), HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSoldeUtilisateur(@PathVariable int id) throws SQLException {
        try {
            SoldeUtilisateur.updateStatut(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSoldeUtilisateur(@PathVariable int id) throws SQLException {
        try {
            SoldeUtilisateur.deleteSolde(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * @PutMapping("/{id}")
     * public ResponseEntity<?> updateSoldeUtilisateur(@PathVariable int id) throws
     * SQLException {
     * try {
     * SoldeUtilisateur.updateStatut(id);
     * } catch (Exception ex) {
     * ex.printStackTrace();
     * return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     * }
     * return new ResponseEntity<>(HttpStatus.OK);
     * }
     */
}
