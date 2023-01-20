package enchere.enchere.controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enchere.enchere.connexion.Connexion;
import enchere.enchere.exception.ErrorJson;
import enchere.enchere.model.Admin;
import enchere.enchere.retour.*;;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping
    public Map<String, Object> logins(@RequestBody Admin ad) throws Exception {
        System.out.println("etoo aloah" + ad.getLogins() + "mdp" + ad.getMdp());
        Map<String, Object> map = new HashMap<String, Object>();
        Admin u = Admin.login(ad.getLogins(), ad.getMdp());
        if (u != null) {
            try {
                System.out.println("etoo indray");

                map.put("data", u);
            } catch (Exception e) {
                map.put("erreur", new ErrorJson(500, "Informations non valides"));
            }
        } else {
            map.put("erreur", new ErrorJson(500, "Informations non valides"));
        }
        return map;
    }

}
