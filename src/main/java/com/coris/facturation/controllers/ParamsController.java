

package com.coris.facturation.controllers;


import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Params;
import com.coris.facturation.services.IParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

    @Controller
    @RequestMapping("/params")
    public class ParamsController {
    
        @Autowired
        private IParamsService paramsService;
    
        @GetMapping("/all")
        
        public String getAll (Model model) {

          try {
            List<Params> datas = new ArrayList<Params>();
            paramsService.readAll().forEach(datas::add);
      
            model.addAttribute("datas", datas);
          } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
          }
      
          return "params";

        }


  @GetMapping("/new")
  public String addParams(Model model) {
    Params params = new Params();
    // params.setPublished(true);

    model.addAttribute("params", params);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Params");

    return "params-form";
  }

  @PostMapping("/save")
  public String saveParams(@ModelAttribute @Valid Params params, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      paramsService.create(params);

      redirectAttributes.addFlashAttribute("message", "Les données de la table Params ont été enregistrées avec succès!");
      System.out.println("Les données de la table Params ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Params :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "params-form";
    }
    return "redirect:/params/all";
  }

  @GetMapping("/{id}")
  public String editParams(@PathVariable("id") String PARAMCODE, Model model, RedirectAttributes redirectAttributes) {
    try {
      Params params = paramsService.readOneById(PARAMCODE);

      model.addAttribute("params", params);
      model.addAttribute("pageTitle", "Modification de Params (ID: " + PARAMCODE + ")");

      return "params-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/params/all";
    }
  }




  @GetMapping("/delete/{id}")
  public String deleteParams(@PathVariable("id") String PARAMCODE, Model model, RedirectAttributes redirectAttributes) {
    try {
      paramsService.delete(PARAMCODE);

      redirectAttributes.addFlashAttribute("message", "La donnée sur Params avec id=" + PARAMCODE + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/params/all";
  }



  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Params> datas = new ArrayList<Params>();

      if (keyword == null) {
        paramsService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "params";
  }
    
        
    }
    