
package com.coris.facturation.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coris.facturation.impls.UtilisateurServiceImpl;
import com.coris.facturation.models.Utilisateur;

@Controller
public class HomeController {

	// @Autowired
	// private BCryptPasswordEncoder encoder;

	@Autowired
	private UtilisateurServiceImpl userService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public void addUser(@RequestParam Map<String, String> body) {

		Utilisateur user = new Utilisateur();

		/*
		 * user.setDate_creation(body.get("date_creation"));
		 * user.setUser_creation(body.get("user_creation"));
		 * user.setUser_modification(body.get("user_modification"));
		 * user.setDate_modification(body.get("date_creation"));
		 */


		userService.create(user);
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/index")
	public String index2() {
		return "index";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/emp")
	public String emp() {
		return "emp";
	}

	@GetMapping("/mgr")
	public String mgr() {
		return "mgr";
	}

	@GetMapping("/hr")
	public String hr() {
		return "hr";
	}

	@GetMapping("/common")
	public String common() {
		return "common";
	}

	@GetMapping("/accessDenied")
	public String getAccessDenied() {
		return "accessDenied";
	}
}
