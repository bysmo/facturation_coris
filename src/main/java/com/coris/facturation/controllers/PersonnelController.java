

package com.coris.facturation.controllers;


import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Personnel;
import com.coris.facturation.services.IPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

    @Controller
    @RequestMapping("/personnel")
    public class PersonnelController {
    
        @Autowired
        private IPersonnelService personnelService;
    
        @GetMapping("/all")
        
        public String getAll (Model model) {

          try {
            List<Personnel> datas = new ArrayList<Personnel>();
            personnelService.readAll().forEach(datas::add);
      
            model.addAttribute("datas", datas);
          } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
          }
      
          return "personnel";

        }


  @GetMapping("/new")
  public String addPersonnel(Model model) {
    Personnel personnel = new Personnel();
    // personnel.setPublished(true);

    model.addAttribute("personnel", personnel);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Personnel");

    return "personnel-form";
  }

  @PostMapping("/save")
  public String savePersonnel(@ModelAttribute @Valid Personnel personnel, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      personnelService.create(personnel);

      redirectAttributes.addFlashAttribute("message", "Les données de la table Personnel ont été enregistrées avec succès!");
      System.out.println("Les données de la table Personnel ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Personnel :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "personnel-form";
    }
    return "redirect:/personnel/all";
  }

  @GetMapping("/{id}")
  public String editPersonnel(@PathVariable("id") String matricule, Model model, RedirectAttributes redirectAttributes) {
    try {
      Personnel personnel = personnelService.readOneById(matricule);

      model.addAttribute("personnel", personnel);
      model.addAttribute("pageTitle", "Modification de Personnel (ID: " + matricule + ")");

      return "personnel-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/personnel/all";
    }
  }




  @GetMapping("/delete/{id}")
  public String deletePersonnel(@PathVariable("id") String matricule, Model model, RedirectAttributes redirectAttributes) {
    try {
      personnelService.delete(matricule);

      redirectAttributes.addFlashAttribute("message", "La donnée sur Personnel avec id=" + matricule + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/personnel/all";
  }



  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Personnel> datas = new ArrayList<Personnel>();

      if (keyword == null) {
        personnelService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "personnel";
  }
    
        
    }
    