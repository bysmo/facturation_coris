

package com.coris.facturation.controllers;


import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Mode_assistance;
import com.coris.facturation.services.IMode_assistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

    @Controller
    @RequestMapping("/mode_assistance")
    public class Mode_assistanceController {
    
        @Autowired
        private IMode_assistanceService mode_assistanceService;
    
        @GetMapping("/all")
        
        public String getAll (Model model) {

          try {
            List<Mode_assistance> datas = new ArrayList<Mode_assistance>();
            mode_assistanceService.readAll().forEach(datas::add);
      
            model.addAttribute("datas", datas);
          } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
          }
      
          return "mode_assistance";

        }


  @GetMapping("/new")
  public String addMode_assistance(Model model) {
    Mode_assistance mode_assistance = new Mode_assistance();
    // mode_assistance.setPublished(true);

    model.addAttribute("mode_assistance", mode_assistance);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Mode_assistance");

    return "mode_assistance-form";
  }

  @PostMapping("/save")
  public String saveMode_assistance(@ModelAttribute @Valid Mode_assistance mode_assistance, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      mode_assistanceService.create(mode_assistance);

      redirectAttributes.addFlashAttribute("message", "Les données de la table Mode_assistance ont été enregistrées avec succès!");
      System.out.println("Les données de la table Mode_assistance ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Mode_assistance :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "mode_assistance-form";
    }
    return "redirect:/mode_assistance/all";
  }

  @GetMapping("/{id}")
  public String editMode_assistance(@PathVariable("id") Integer assmod_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Mode_assistance mode_assistance = mode_assistanceService.readOneById(assmod_id);

      model.addAttribute("mode_assistance", mode_assistance);
      model.addAttribute("pageTitle", "Modification de Mode_assistance (ID: " + assmod_id + ")");

      return "mode_assistance-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/mode_assistance/all";
    }
  }




  @GetMapping("/delete/{id}")
  public String deleteMode_assistance(@PathVariable("id") Integer assmod_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      mode_assistanceService.delete(assmod_id);

      redirectAttributes.addFlashAttribute("message", "La donnée sur Mode_assistance avec id=" + assmod_id + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/mode_assistance/all";
  }



  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Mode_assistance> datas = new ArrayList<Mode_assistance>();

      if (keyword == null) {
        mode_assistanceService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "mode_assistance";
  }
    
        
    }
    