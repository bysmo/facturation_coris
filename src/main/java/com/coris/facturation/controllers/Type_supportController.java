
package com.coris.facturation.controllers;

import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Type_support;
import com.coris.facturation.services.IType_supportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

@Controller
@RequestMapping("/type_support")
public class Type_supportController {

  @Autowired
  private IType_supportService type_supportService;

  @GetMapping("/all")

  public String getAll(Model model) {

    try {
      List<Type_support> datas = new ArrayList<Type_support>();
      type_supportService.readAll().forEach(datas::add);

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "type_support";

  }

  @GetMapping("/new")
  public String addType_support(Model model) {
    Type_support type_support = new Type_support();
    // type_support.setPublished(true);

    model.addAttribute("type_support", type_support);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Type_support");

    return "type_support-form";
  }

  @PostMapping("/save")
  public String saveType_support(@ModelAttribute @Valid Type_support type_support,
      RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      type_supportService.create(type_support);

      redirectAttributes.addFlashAttribute("message",
          "Les données de la table Type_support ont été enregistrées avec succès!");
      System.out.println("Les données de la table Type_support ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Type_support :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "type_support-form";
    }
    return "redirect:/type_support/all";
  }

  @GetMapping("/{id}")
  public String editType_support(@PathVariable("id") String supp_code, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      Type_support type_support = type_supportService.readOneById(supp_code);

      model.addAttribute("type_support", type_support);
      model.addAttribute("pageTitle", "Modification de Type_support (ID: " + supp_code + ")");

      return "type_support-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/type_support/all";
    }
  }

  @GetMapping("/delete/{id}")
  public String deleteType_support(@PathVariable("id") String supp_code, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      type_supportService.delete(supp_code);

      redirectAttributes.addFlashAttribute("message",
          "La donnée sur Type_support avec id=" + supp_code + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/type_support/all";
  }

  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Type_support> datas = new ArrayList<Type_support>();

      if (keyword == null) {
        type_supportService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "type_support";
  }

}
