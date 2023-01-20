package enchere.enchere.controller;

import enchere.enchere.model.CategoriePenchere;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import enchere.enchere.retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/CategoriePE")
public class CategoriePenchereController {

    @GetMapping
    public ResponseEntity<DataRetour> listeCategoriePE() throws Exception {

        return ResponseEntity.accepted().body(new CategoriePenchere().listCategoriePEnchere());

    }

}
