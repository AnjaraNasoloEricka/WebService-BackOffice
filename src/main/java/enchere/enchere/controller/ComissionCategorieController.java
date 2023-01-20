package enchere.enchere.controller;

import enchere.enchere.exception.NullException;
import enchere.enchere.exception.ShowError;
import enchere.enchere.model.ComissionCategorie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/Comission")
public class ComissionCategorieController {

    @PutMapping("/{id}")
    public ResponseEntity<?> listecomission(@PathVariable(value = "id") int id, @RequestBody ComissionCategorie v) {
        try {
            v.modifComissionCategorie(id, v);
        } catch (Exception ex) {
            return new ResponseEntity(new ShowError(new NullException(404, "Comission not found")),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
