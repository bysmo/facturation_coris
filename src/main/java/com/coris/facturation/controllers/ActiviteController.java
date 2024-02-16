
package com.coris.facturation.controllers;

import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Activite;
import com.coris.facturation.models.Direction;
import com.coris.facturation.services.IActiviteService;
import com.coris.facturation.services.IDirectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

@Controller
@RequestMapping("/activite")
public class ActiviteController {

  @Autowired
  private IActiviteService activiteService;

  @Autowired
  private IDirectionService directionService;

  @GetMapping("/all")

  public String getAll(Model model) {

    try {
      List<Activite> datas = new ArrayList<Activite>();
      activiteService.readAll().forEach(datas::add);

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "activite";

  }

  @GetMapping("/new")
  public String addActivite(Model model) {
    Activite activite = new Activite();
    // activite.setPublished(true);

    List<Direction> directions = new ArrayList<Direction>();
    directionService.readAll().forEach(directions::add);

    model.addAttribute("directions", directions);
    model.addAttribute("activite", activite);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Activite");

    return "activite-form";
  }

  @PostMapping("/save")
  public String saveActivite(@ModelAttribute @Valid Activite activite, RedirectAttributes redirectAttributes,
      BindingResult bindingResult) {
    try {
      activiteService.create(activite);

      redirectAttributes.addFlashAttribute("message",
          "Les données de la table Activite ont été enregistrées avec succès!");
      System.out.println("Les données de la table Activite ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Activite :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "activite-form";
    }
    return "redirect:/activite/all";
  }

  @GetMapping("/{id}")
  public String editActivite(@PathVariable("id") Integer activ_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Activite activite = activiteService.readOneById(activ_id);

      model.addAttribute("activite", activite);
      model.addAttribute("pageTitle", "Modification de Activite (ID: " + activ_id + ")");

      return "activite-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/activite/all";
    }
  }

  @GetMapping("/delete/{id}")
  public String deleteActivite(@PathVariable("id") Integer activ_id, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      activiteService.delete(activ_id);

      redirectAttributes.addFlashAttribute("message",
          "La donnée sur Activite avec id=" + activ_id + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/activite/all";
  }

  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Activite> datas = new ArrayList<Activite>();

      if (keyword == null) {
        activiteService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "activite";
  }

}
