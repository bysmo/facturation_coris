

package com.coris.facturation.controllers;


import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Type_conv;
import com.coris.facturation.services.IType_convService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

    @Controller
    @RequestMapping("/type_conv")
    public class Type_convController {
    
        @Autowired
        private IType_convService type_convService;
    
        @GetMapping("/all")
        
        public String getAll (Model model) {

          try {
            List<Type_conv> datas = new ArrayList<Type_conv>();
            type_convService.readAll().forEach(datas::add);
      
            model.addAttribute("datas", datas);
          } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
          }
      
          return "type_conv";

        }


  @GetMapping("/new")
  public String addType_conv(Model model) {
    Type_conv type_conv = new Type_conv();
    // type_conv.setPublished(true);

    model.addAttribute("type_conv", type_conv);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Type_conv");

    return "type_conv-form";
  }

  @PostMapping("/save")
  public String saveType_conv(@ModelAttribute @Valid Type_conv type_conv, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      type_convService.create(type_conv);

      redirectAttributes.addFlashAttribute("message", "Les données de la table Type_conv ont été enregistrées avec succès!");
      System.out.println("Les données de la table Type_conv ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Type_conv :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "type_conv-form";
    }
    return "redirect:/type_conv/all";
  }

  @GetMapping("/{id}")
  public String editType_conv(@PathVariable("id") Integer conv_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Type_conv type_conv = type_convService.readOneById(conv_id);

      model.addAttribute("type_conv", type_conv);
      model.addAttribute("pageTitle", "Modification de Type_conv (ID: " + conv_id + ")");

      return "type_conv-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/type_conv/all";
    }
  }




  @GetMapping("/delete/{id}")
  public String deleteType_conv(@PathVariable("id") Integer conv_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      type_convService.delete(conv_id);

      redirectAttributes.addFlashAttribute("message", "La donnée sur Type_conv avec id=" + conv_id + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/type_conv/all";
  }



  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Type_conv> datas = new ArrayList<Type_conv>();

      if (keyword == null) {
        type_convService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "type_conv";
  }
    
        
    }
    