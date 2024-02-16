

package com.coris.facturation.controllers;


import java.util.List;
import java.util.ArrayList;
// Importing required classes
import com.coris.facturation.models.Role;
import com.coris.facturation.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.*;

    @Controller
    @RequestMapping("/role")
    public class RoleController {
    
        @Autowired
        private IRoleService roleService;
    
        @GetMapping("/all")
        
        public String getAll (Model model) {

          try {
            List<Role> datas = new ArrayList<Role>();
            roleService.readAll().forEach(datas::add);
      
            model.addAttribute("datas", datas);
          } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
          }
      
          return "role";

        }


  @GetMapping("/new")
  public String addRole(Model model) {
    Role role = new Role();
    // role.setPublished(true);

    model.addAttribute("role", role);
    model.addAttribute("pageTitle", "Créer un nouvelle donnée pour Role");

    return "role-form";
  }

  @PostMapping("/save")
  public String saveRole(@ModelAttribute @Valid Role role, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
    try {
      roleService.create(role);

      redirectAttributes.addFlashAttribute("message", "Les données de la table Role ont été enregistrées avec succès!");
      System.out.println("Les données de la table Role ont été enregistrées avec succès!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
      System.out.println("**************************** ERREUR lors de l'enregistrement de la table Role :");
      System.out.println(e.getMessage());
    }

    if (bindingResult.hasErrors()) {
      System.out.println("**************************** ERREUR bindingResult");
      return "role-form";
    }
    return "redirect:/role/all";
  }

  @GetMapping("/{id}")
  public String editRole(@PathVariable("id") String role_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Role role = roleService.readOneById(role_id);

      model.addAttribute("role", role);
      model.addAttribute("pageTitle", "Modification de Role (ID: " + role_id + ")");

      return "role-form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/role/all";
    }
  }




  @GetMapping("/delete/{id}")
  public String deleteRole(@PathVariable("id") String role_id, Model model, RedirectAttributes redirectAttributes) {
    try {
      roleService.delete(role_id);

      redirectAttributes.addFlashAttribute("message", "La donnée sur Role avec id=" + role_id + " a été supprimée avec succès!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/role/all";
  }



  @GetMapping("/search")
  public String search(Model model, @Param("keyword") String keyword) {
    try {
      List<Role> datas = new ArrayList<Role>();

      if (keyword == null) {
        roleService.findAll().forEach(datas::add);
      }

      model.addAttribute("datas", datas);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "role";
  }
    
        
    }
    