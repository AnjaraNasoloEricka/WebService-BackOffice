package enchere.enchere.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enchere.enchere.exception.ErrorJson;
import enchere.enchere.model.PourcentageDuree;

@RestController
@CrossOrigin("*")
@RequestMapping("/pourcentage")
public class PourcentageDureeController {

    @GetMapping
    public ResponseEntity<?> getPourcentageDuree() throws Exception {
        Map<String, Object> ob = new HashMap<>();
        PourcentageDuree pd = null;
        try {
            pd = PourcentageDuree.selectPourcentage();
            ob.put("data", pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(ob, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<?> updatePourcentageDuree(@RequestBody PourcentageDuree pd) throws Exception {
        System.out.println("pourc" + pd.getPourcentage());
        Map<String, Object> ob = new HashMap<>();
        try {
            PourcentageDuree.updatePourcentage(pd);
            ob.put("success", new ErrorJson(200, "Pourcentage modifié avec succès"));
        } catch (Exception e) {
            ob.put("error", new ErrorJson(500, "Erreur lors de la modification du pourcentage"));
        }
        return new ResponseEntity<>(ob, HttpStatus.OK);

    }

}
