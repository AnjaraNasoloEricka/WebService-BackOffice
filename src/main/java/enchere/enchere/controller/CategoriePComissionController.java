package enchere.enchere.controller;


import enchere.enchere.model.CategoriePComission;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import enchere.enchere.retour.DataRetour;

@RestController
@CrossOrigin("*")
@RequestMapping("/CategoriePC")
public class CategoriePComissionController {

    @GetMapping
    public ResponseEntity<DataRetour> lsCategoriePC() throws Exception {
        return ResponseEntity.accepted().body(new CategoriePComission().listCategoriePComission());

    }

}
