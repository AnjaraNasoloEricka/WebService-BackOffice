package enchere.enchere.controller;

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

import enchere.enchere.model.Categorie;
import enchere.enchere.retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/categorie")
public class CategorieController {

    @GetMapping
    public ResponseEntity<DataRetour> listCategorie() throws Exception {
        new Categorie();
        return ResponseEntity.accepted().body(Categorie.listCategorie());
    }

    @PostMapping
    public ResponseEntity<?> insertCategorie(@RequestBody Categorie ctg)throws SQLException {
        try {
           Categorie.insertCategorie(ctg);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable (value = "id")int id) throws SQLException {

        try {
            Categorie.deleteCategorie(id);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateT(@RequestBody Categorie ctg,
                                     @PathVariable (value = "id")int id) throws Exception {
        try {
            Categorie.modifCategorie(id, ctg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
