
package com.coris.facturation.controllers;

import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Direction;
import com.coris.facturation.models.Personnel;
import com.coris.facturation.services.IDirectionService;
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
@RequestMapping("/direction")
public class DirectionController {

  @Autowired
  private IDirectionService directionService;
  @Autowired
  private IPersonnelService personnelService;

  @GetMapping("/all")

  public String getAll(Model model) {

    try {
      List<Direction> datas = new ArrayList<Direction>();
      directionService.readAll().forEach(datas::add);

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "direction";

  }

  @GetMapping("/new")
  public String addDirection(Model model) {
    Direction direction = new Direction();
    // direction.setPublished(true);
    List<Personnel> personnes = new ArrayList<Personnel>();
    personnelService.readAll().forEach(personnes::add);

    model.addAttribute("personnes", personnes);
    model.addAttribute("direction", direction);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Direction");

    return "direction-form";
  }

  @PostMapping("/save")
  public String saveDirection(@ModelAttribute @Valid Direction direction, RedirectAttributes redirectAttributes,
      BindingResult bindingResult) {

    Direction direction1 = new Direction();

    direction1.setDirect_id(null);
    direction1.setDirect_code(direction.getDirect_code());
    direction1.setDirect_libelle(direction.getDirect_libelle());
    direction1.setDirect_description(direction.getDirect_description());
    direction1.setMatricule_directeur(direction.getMatricule_directeur());

    System.out.println("**************************** Détails de l'objet à enregistrer : " + direction1.toString());

    try {
      directionService.create(direction1);

      redirectAttributes.addFlashAttribute("message",
          "Les données de la table Direction ont été enregistrées avec succès!");
      System.out.println("Les données de la table Direction ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Direction :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "direction-form";
    }
    return "redirect:/direction/all";
  }

  @GetMapping("/{id}")
  public String editDirection(@PathVariable("id") Integer direct_id, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      Direction direction = directionService.readOneById(direct_id);

      model.addAttribute("direction", direction);
      model.addAttribute("pageTitle", "Modification de Direction (ID: " + direct_id + ")");

      return "direction-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/direction/all";
    }
  }

  @GetMapping("/delete/{id}")
  public String deleteDirection(@PathVariable("id") Integer direct_id, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      directionService.delete(direct_id);

      redirectAttributes.addFlashAttribute("message",
          "La donnée sur Direction avec id=" + direct_id + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/direction/all";
  }

  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Direction> datas = new ArrayList<Direction>();

      if (keyword == null) {
        directionService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "direction";
  }

}
