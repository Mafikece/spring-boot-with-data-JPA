package com.mafik.main.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mafik.main.Repository.ProgrammerRepo;
import com.mafik.main.model.Programmer;


@Controller
public class MyController {
	
	@Autowired
	ProgrammerRepo pr;
	
	
	@GetMapping("/index")
	public String homePage(Model model) {
		model.addAttribute("index", "Welcome to Srping Boot Web Project");
		return "index";
	}
	
	@GetMapping("/AddProgrammer")
	public String addProgrammer() {
		return "addProgrammer";
	}
	@GetMapping("/ProgrammerInfo")
	public String addSuccess(@ModelAttribute Programmer programmer) {
		pr.save(programmer);
		return "programmerInfo";
	}
	
	@GetMapping("/ViewProgrammer")
	public String viewProgrammer() {
		return "viewProgrammer";
	}
	
	@PostMapping("/ViewById")
	public String viewById(@RequestParam int pId, Model m) {
		Programmer p=pr.getOne(pId);
		m.addAttribute("programmer", p);
		return "programmerInfo";
	}
	
	@GetMapping("/DeleteProgrammer")
	public String deleteProgrammer() {
		return "deleteProgrammer";
	}

	@PostMapping("/DeleteById")
	public String deleteById(@RequestParam int pId) {
		pr.deleteById(pId);
		return "redirect:/index";
	}
	
	@GetMapping("/UpdateProgrammer")
	public String updateProgrammer() {
		return "updateProrammer";
	}
	
	@PostMapping("/updateProgrammer")
	public String updateProgrammer(@ModelAttribute Programmer programmer) {
		Programmer p=pr.findById(programmer.getpId()).orElse(null);
		  p.setpName(programmer.getpName()); 
		  p.setpLang(programmer.getpLang());
		  pr.save(p);
		 
		return "programmerInfo";
	}
	
	//view all
	
	@GetMapping("/viewall") 
	public ModelAndView viewAllProgrammers() {
		List<Programmer> programmers=pr.findAll();
		System.out.println(programmers);
		return new ModelAndView("rspn","list",programmers);
	}
}	

