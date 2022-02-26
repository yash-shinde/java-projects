package com.prog.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.Entity.Pateint_entity;

@Controller
public class EmpController {

	@Autowired
	private com.prog.Service.Service service;
	
	@GetMapping("/")
	public String home(Model p) {
		
		List<Pateint_entity> pat = service.getALLPat();
		p.addAttribute("pat",pat);
		return "index";
	}
	
	@GetMapping("/addPatient")
	public String addPatient() {
		return "patient_add";
	}
	
	@PostMapping("/register")
	public String mapPatient(@ModelAttribute Pateint_entity p, HttpSession session )
	{
		System.out.println(p);
		service.addPat(p);
		
		session.setAttribute("msg", "Record Added Successfully..");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		
		Pateint_entity p =service.getPatById(id);
		
		m.addAttribute("pat",p);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updatePat(@ModelAttribute Pateint_entity p,HttpSession session)
	{
		service.addPat(p);
		session.setAttribute("msg","Pat updated successfully");
		return "redirect:/";
	}

	@GetMapping("/delete/id")
	public String deletePat(@PathVariable int id,HttpSession session)
	{
		service.deletePat(id);
		session.setAttribute("msg","Pat deleted successfully");
		return "redirect:/";
	}

}
