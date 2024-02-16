

package com.coris.facturation.controllers;


import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Utilisateur;
import com.coris.facturation.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

    @Controller
    @RequestMapping("/utilisateur")
    public class UtilisateurController {
    
        @Autowired
        private IUtilisateurService utilisateurService;
    
        @GetMapping("/all")
        
        public String getAll (Model model) {

          try {
            List<Utilisateur> datas = new ArrayList<Utilisateur>();
            utilisateurService.readAll().forEach(datas::add);
      
            model.addAttribute("datas", datas);
          } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
          }
      
          return "utilisateur";

        }


  @GetMapping("/new")
  public String addUtilisateur(Model model) {
    Utilisateur utilisateur = new Utilisateur();
    // utilisateur.setPublished(true);

    model.addAttribute("utilisateur", utilisateur);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Utilisateur");

    return "utilisateur-form";
  }

  @PostMapping("/save")
  public String saveUtilisateur(@ModelAttribute @Valid Utilisateur utilisateur, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      utilisateurService.create(utilisateur);

      redirectAttributes.addFlashAttribute("message", "Les données de la table Utilisateur ont été enregistrées avec succès!");
      System.out.println("Les données de la table Utilisateur ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Utilisateur :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "utilisateur-form";
    }
    return "redirect:/utilisateur/all";
  }

  @GetMapping("/{id}")
  public String editUtilisateur(@PathVariable("id") Long user_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Utilisateur utilisateur = utilisateurService.readOneById(user_id);

      model.addAttribute("utilisateur", utilisateur);
      model.addAttribute("pageTitle", "Modification de Utilisateur (ID: " + user_id + ")");

      return "utilisateur-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/utilisateur/all";
    }
  }




  @GetMapping("/delete/{id}")
  public String deleteUtilisateur(@PathVariable("id") Long user_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      utilisateurService.delete(user_id);

      redirectAttributes.addFlashAttribute("message", "La donnée sur Utilisateur avec id=" + user_id + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/utilisateur/all";
  }



  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Utilisateur> datas = new ArrayList<Utilisateur>();

      if (keyword == null) {
        utilisateurService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "utilisateur";
  }
    
        
    }
    