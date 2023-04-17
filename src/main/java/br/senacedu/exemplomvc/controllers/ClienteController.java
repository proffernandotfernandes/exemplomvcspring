package br.senacedu.exemplomvc.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.senacedu.exemplomvc.models.Cliente;
import br.senacedu.exemplomvc.repositories.ClienteRepository;

@Controller
public class ClienteController {

	//injeta a dependência. Cria o objeto clienteRepository automaticamente
	@Autowired 
	private ClienteRepository clienteRepository; 
	
	//Listar Clientes
	@GetMapping("/clientes")  //Mapeia a rota para a View index.html
	public ModelAndView index() {
		
		List<Cliente> listaClientes = this.clienteRepository.findAll();
		
		ModelAndView mv = new ModelAndView("clientes/index");
		mv.addObject("clientes",listaClientes);
		
		return mv;
	}
	
	//Redireciona para o formulário de cadastro	
	@GetMapping("/clientes/new")
	public String novo() {
		return "clientes/new";
	}
	
	//Recebe os dados da view de cadastro e salva no banco de dados
	@PostMapping("/clientes")
	public String create(Cliente objCliente) {
		System.out.println(objCliente);
		
		//Salvo o cliente no banco de dados usando o repositório
		clienteRepository.save(objCliente);
		
		//Chamo a página de listagem de clientes novamente
		return "redirect:/clientes";
	}
	
}
