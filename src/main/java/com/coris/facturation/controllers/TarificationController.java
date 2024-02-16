
package com.coris.facturation.controllers;

import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Tarification;
import com.coris.facturation.models.TarificationPK;
import com.coris.facturation.services.ITarificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

@Controller
@RequestMapping("/tarification")
public class TarificationController {

  @Autowired
  private ITarificationService tarificationService;

  @GetMapping("/all")

  public String getAll(Model model) {

    try {
      List<Tarification> datas = new ArrayList<Tarification>();
      tarificationService.readAll().forEach(datas::add);

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "tarification";

  }

  @GetMapping("/new")
  public String addTarification(Model model) {
    Tarification tarification = new Tarification();
    // tarification.setPublished(true);

    model.addAttribute("tarification", tarification);
    model.addAttribute("pageTitle", "Create new Tarification");

    return "tarification_form";
  }

  @PostMapping("/save")
  public String saveTarification(@ModelAttribute @Valid Tarification tarification,
      RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      tarificationService.create(tarification);

      redirectAttributes.addFlashAttribute("message",
          "Les données de la table Tarification ont été enregistrées avec succès!");
      System.out.println("Les données de la table Tarification ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Tarification :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "tarification_form";
    }
    return "redirect:/tarification/all";
  }

  @GetMapping("/{id}")
  public String editTarification(@PathVariable("id") TarificationPK tarif_code, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      Tarification tarification = tarificationService.readOneById(tarif_code);

      model.addAttribute("tarification", tarification);
      model.addAttribute("pageTitle", "Edit Tarification (ID: " + tarif_code + ")");

      return "tarification_form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/tarification/all";
    }
  }

  @GetMapping("/delete/{id}")
  public String deleteTarification(@PathVariable("id") TarificationPK tarif_code, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      tarificationService.delete(tarif_code);

      redirectAttributes.addFlashAttribute("message",
          "The Tarification with id=" + tarif_code + " has been deleted successfully!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/tarification/all";
  }

  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Tarification> datas = new ArrayList<Tarification>();

      if (keyword == null) {
        tarificationService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "tarification";
  }

}
