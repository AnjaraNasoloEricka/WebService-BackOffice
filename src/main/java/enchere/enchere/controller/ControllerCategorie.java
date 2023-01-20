package enchere.enchere.controller;

import enchere.enchere.exception.NullException;
import enchere.enchere.exception.ShowError;
import enchere.enchere.model.CategoriePenchere;
import enchere.enchere.model.listeCategorieComission;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import enchere.enchere.retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/catcom")
public class ControllerCategorie {

    @GetMapping
    public ResponseEntity<DataRetour> listeCategoriePE() throws Exception {
        System.out.println("ato ooo");
        return ResponseEntity.accepted().body(new listeCategorieComission().listeCategorieComission());

    }

}
