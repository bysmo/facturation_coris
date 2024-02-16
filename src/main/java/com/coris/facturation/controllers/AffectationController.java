
package com.coris.facturation.controllers;

import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Affectation;
import com.coris.facturation.models.AffectationPK;
import com.coris.facturation.services.IAffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

@Controller
@RequestMapping("/affectation")
public class AffectationController {

  @Autowired
  private IAffectationService affectationService;

  @GetMapping("/all")

  public String getAll(Model model) {

    try {
      List<Affectation> datas = new ArrayList<Affectation>();
      affectationService.readAll().forEach(datas::add);

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "affectation";

  }

  @GetMapping("/new")
  public String addAffectation(Model model) {
    Affectation affectation = new Affectation();
    // affectation.setPublished(true);

    model.addAttribute("affectation", affectation);
    model.addAttribute("pageTitle", "Create new Affectation");

    return "affectation_form";
  }

  @PostMapping("/save")
  public String saveAffectation(@ModelAttribute @Valid Affectation affectation, RedirectAttributes redirectAttributes,
      BindingResult bindingResult) {
    try {
      affectationService.create(affectation);

      redirectAttributes.addFlashAttribute("message",
          "Les données de la table Affectation ont été enregistrées avec succès!");
      System.out.println("Les données de la table Affectation ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Affectation :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "affectation_form";
    }
    return "redirect:/affectation/all";
  }

  @GetMapping("/{id}")
  public String editAffectation(@PathVariable("id") AffectationPK affectationid, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      Affectation affectation = affectationService.readOneById(affectationid);

      model.addAttribute("affectation", affectation);
      model.addAttribute("pageTitle", "Edit Affectation (ID: " + affectationid + ")");

      return "affectation_form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/affectation/all";
    }
  }

  @GetMapping("/delete/{id}")
  public String deleteAffectation(@PathVariable("id") AffectationPK affectationid, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      affectationService.delete(affectationid);

      redirectAttributes.addFlashAttribute("message",
          "The Affectation with id=" + affectationid + " has been deleted successfully!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/affectation/all";
  }

  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Affectation> datas = new ArrayList<Affectation>();

      if (keyword == null) {
        affectationService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "affectation";
  }

}
