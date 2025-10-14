package sample.data.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Utilisateur;
import sample.data.jpa.dto.UtilisateurDTO;
import sample.data.jpa.mapper.IUtilisateurMapper;
import sample.data.jpa.repository.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private IUtilisateurMapper utilisateurMapper;

    @RequestMapping("/create")
    @ResponseBody
    public String create(@RequestParam String name) {
        try {
            Utilisateur user = new Utilisateur(name);
            utilisateurRepository.save(user);
        }
        catch (Exception ex) {
            return "Erreur lors de la création d'un Utilisateur ";
        }
        return "Utilisateur crée avec succès !";
    }

    @RequestMapping("/utilisateurs")
    @ResponseBody
    public List<Utilisateur> recupererTousLesUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @RequestMapping("/utilisateur")
    @ResponseBody
    public UtilisateurDTO recupererUnUtilisateurEnParticulier(@RequestParam Long idUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(idUtilisateur);
        return IUtilisateurMapper.INSTANCE.toDto(utilisateur);
    }

}
