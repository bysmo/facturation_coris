

package com.coris.facturation.controllers;


import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Sous_activite;
import com.coris.facturation.services.ISous_activiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

    @Controller
    @RequestMapping("/sous_activite")
    public class Sous_activiteController {
    
        @Autowired
        private ISous_activiteService sous_activiteService;
    
        @GetMapping("/all")
        
        public String getAll (Model model) {

          try {
            List<Sous_activite> datas = new ArrayList<Sous_activite>();
            sous_activiteService.readAll().forEach(datas::add);
      
            model.addAttribute("datas", datas);
          } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
          }
      
          return "sous_activite";

        }


  @GetMapping("/new")
  public String addSous_activite(Model model) {
    Sous_activite sous_activite = new Sous_activite();
    // sous_activite.setPublished(true);

    model.addAttribute("sous_activite", sous_activite);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Sous_activite");

    return "sous_activite-form";
  }

  @PostMapping("/save")
  public String saveSous_activite(@ModelAttribute @Valid Sous_activite sous_activite, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      sous_activiteService.create(sous_activite);

      redirectAttributes.addFlashAttribute("message", "Les données de la table Sous_activite ont été enregistrées avec succès!");
      System.out.println("Les données de la table Sous_activite ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Sous_activite :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "sous_activite-form";
    }
    return "redirect:/sous_activite/all";
  }

  @GetMapping("/{id}")
  public String editSous_activite(@PathVariable("id") Integer ssact_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Sous_activite sous_activite = sous_activiteService.readOneById(ssact_id);

      model.addAttribute("sous_activite", sous_activite);
      model.addAttribute("pageTitle", "Modification de Sous_activite (ID: " + ssact_id + ")");

      return "sous_activite-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/sous_activite/all";
    }
  }




  @GetMapping("/delete/{id}")
  public String deleteSous_activite(@PathVariable("id") Integer ssact_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      sous_activiteService.delete(ssact_id);

      redirectAttributes.addFlashAttribute("message", "La donnée sur Sous_activite avec id=" + ssact_id + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/sous_activite/all";
  }



  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Sous_activite> datas = new ArrayList<Sous_activite>();

      if (keyword == null) {
        sous_activiteService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "sous_activite";
  }
    
        
    }
    