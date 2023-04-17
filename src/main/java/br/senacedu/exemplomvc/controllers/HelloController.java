package br.senacedu.exemplomvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public ModelAndView hello() {
		
		//Empacota dados com a view
		ModelAndView mv = new ModelAndView("hello"); //view a ser renderizada
		mv.addObject("nome", "mv");
		
		return mv;		
	}
	
	
	@GetMapping("/hello-model")
	public String hello(Model model) {
		model.addAttribute("nome","Fernando");
		return "hello";		
	}
	
	//Métodos legados - HttpServlet
	@GetMapping("/hello-servlet")
	public String hello(HttpServletRequest request) {
		request.setAttribute("nome","Fer");
		return "hello";		
	}

}
