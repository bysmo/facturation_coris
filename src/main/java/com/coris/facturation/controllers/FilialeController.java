
package com.coris.facturation.controllers;

import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Filiale;
import com.coris.facturation.services.IFilialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

@Controller
@RequestMapping("/filiale")
public class FilialeController {

  @Autowired
  private IFilialeService filialeService;

  @GetMapping("/all")

  public String getAll(Model model) {

    try {
      List<Filiale> datas = new ArrayList<Filiale>();
      filialeService.readAll().forEach(datas::add);

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "filiale";

  }

  @GetMapping("/new")
  public String addFiliale(Model model) {
    Filiale filiale = new Filiale();
    // filiale.setPublished(true);

    model.addAttribute("filiale", filiale);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Filiale");

    return "filiale-form";
  }

  @PostMapping("/save")
  public String saveFiliale(@ModelAttribute @Valid Filiale filiale, RedirectAttributes redirectAttributes,
      BindingResult bindingResult) {
    try {
      filialeService.create(filiale);

      redirectAttributes.addFlashAttribute("message",
          "Les données de la table Filiale ont été enregistrées avec succès!");
      System.out.println("Les données de la table Filiale ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Filiale :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "filiale-form";
    }
    return "redirect:/filiale/all";
  }

  @GetMapping("/{id}")
  public String editFiliale(@PathVariable("id") Integer filiale_id, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      Filiale filiale = filialeService.readOneById(filiale_id);

      model.addAttribute("filiale", filiale);
      model.addAttribute("pageTitle", "Modification de Filiale (ID: " + filiale_id + ")");

      return "filiale-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/filiale/all";
    }
  }

  @GetMapping("/delete/{id}")
  public String deleteFiliale(@PathVariable("id") Integer filiale_id, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      filialeService.delete(filiale_id);

      redirectAttributes.addFlashAttribute("message",
          "La donnée sur Filiale avec id=" + filiale_id + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/filiale/all";
  }

  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Filiale> datas = new ArrayList<Filiale>();

      if (keyword == null) {
        filialeService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "filiale";
  }

}
