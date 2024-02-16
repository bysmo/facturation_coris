

package com.coris.facturation.controllers;


import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Type_tarif;
import com.coris.facturation.services.IType_tarifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

    @Controller
    @RequestMapping("/type_tarif")
    public class Type_tarifController {
    
        @Autowired
        private IType_tarifService type_tarifService;
    
        @GetMapping("/all")
        
        public String getAll (Model model) {

          try {
            List<Type_tarif> datas = new ArrayList<Type_tarif>();
            type_tarifService.readAll().forEach(datas::add);
      
            model.addAttribute("datas", datas);
          } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
          }
      
          return "type_tarif";

        }


  @GetMapping("/new")
  public String addType_tarif(Model model) {
    Type_tarif type_tarif = new Type_tarif();
    // type_tarif.setPublished(true);

    model.addAttribute("type_tarif", type_tarif);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Type_tarif");

    return "type_tarif-form";
  }

  @PostMapping("/save")
  public String saveType_tarif(@ModelAttribute @Valid Type_tarif type_tarif, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      type_tarifService.create(type_tarif);

      redirectAttributes.addFlashAttribute("message", "Les données de la table Type_tarif ont été enregistrées avec succès!");
      System.out.println("Les données de la table Type_tarif ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Type_tarif :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "type_tarif-form";
    }
    return "redirect:/type_tarif/all";
  }

  @GetMapping("/{id}")
  public String editType_tarif(@PathVariable("id") String tarif_code, Model model, RedirectAttributes redirectAttributes) {
    try {
      Type_tarif type_tarif = type_tarifService.readOneById(tarif_code);

      model.addAttribute("type_tarif", type_tarif);
      model.addAttribute("pageTitle", "Modification de Type_tarif (ID: " + tarif_code + ")");

      return "type_tarif-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/type_tarif/all";
    }
  }




  @GetMapping("/delete/{id}")
  public String deleteType_tarif(@PathVariable("id") String tarif_code, Model model, RedirectAttributes redirectAttributes) {
    try {
      type_tarifService.delete(tarif_code);

      redirectAttributes.addFlashAttribute("message", "La donnée sur Type_tarif avec id=" + tarif_code + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/type_tarif/all";
  }



  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Type_tarif> datas = new ArrayList<Type_tarif>();

      if (keyword == null) {
        type_tarifService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "type_tarif";
  }
    
        
    }
    