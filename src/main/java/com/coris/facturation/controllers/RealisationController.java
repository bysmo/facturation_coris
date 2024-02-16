

package com.coris.facturation.controllers;


import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Realisation;
import com.coris.facturation.services.IRealisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

    @Controller
    @RequestMapping("/realisation")
    public class RealisationController {
    
        @Autowired
        private IRealisationService realisationService;
    
        @GetMapping("/all")
        
        public String getAll (Model model) {

          try {
            List<Realisation> datas = new ArrayList<Realisation>();
            realisationService.readAll().forEach(datas::add);
      
            model.addAttribute("datas", datas);
          } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
          }
      
          return "realisation";

        }


  @GetMapping("/new")
  public String addRealisation(Model model) {
    Realisation realisation = new Realisation();
    // realisation.setPublished(true);

    model.addAttribute("realisation", realisation);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Realisation");

    return "realisation-form";
  }

  @PostMapping("/save")
  public String saveRealisation(@ModelAttribute @Valid Realisation realisation, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      realisationService.create(realisation);

      redirectAttributes.addFlashAttribute("message", "Les données de la table Realisation ont été enregistrées avec succès!");
      System.out.println("Les données de la table Realisation ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Realisation :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "realisation-form";
    }
    return "redirect:/realisation/all";
  }

  @GetMapping("/{id}")
  public String editRealisation(@PathVariable("id") Long real_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Realisation realisation = realisationService.readOneById(real_id);

      model.addAttribute("realisation", realisation);
      model.addAttribute("pageTitle", "Modification de Realisation (ID: " + real_id + ")");

      return "realisation-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/realisation/all";
    }
  }




  @GetMapping("/delete/{id}")
  public String deleteRealisation(@PathVariable("id") Long real_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      realisationService.delete(real_id);

      redirectAttributes.addFlashAttribute("message", "La donnée sur Realisation avec id=" + real_id + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/realisation/all";
  }



  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Realisation> datas = new ArrayList<Realisation>();

      if (keyword == null) {
        realisationService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "realisation";
  }
    
        
    }
    