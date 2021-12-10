package com.WorldBeauty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.WorldBeauty.models.Cliente;
import com.WorldBeauty.models.Serviço;
import com.WorldBeauty.repository.ClienteRepository;
import com.WorldBeauty.repository.ServiçoRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository cr;
	@Autowired
	private ServiçoRepository sr;

	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String form(){
		return "cliente/formcliente";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Cliente cliente, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarCliente";
		}
		cr.save(cliente);
		attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
		return "redirect:/cadastrarCliente";
	}
	
	@RequestMapping("/Clientes")
	public ModelAndView listaclientes(){
		ModelAndView mv = new ModelAndView("listaClientes");
		Iterable<Cliente> clientes = cr.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView serviçoscliente(@PathVariable("id") long id){
		Cliente cliente = cr.findByid(id);
		ModelAndView mv = new ModelAndView("Cliente/serviços");
		mv.addObject("cliente", cliente);
		
		Iterable<Serviço> serviços = sr.findByCliente(cliente);
		mv.addObject("serviços", serviços);
		
		return mv;
	}
	
	@RequestMapping("/deletarCliente")
	public String deletarCliente(long id){
		Cliente cliente = cr.findByid(id);
		cr.delete(cliente);
		return "redirect:/clientes";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("id") long id,  Serviço serviço,  BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{id}";
		}
		Cliente cliente = cr.findByid(id);
		serviço.setCliente(cliente);
		sr.save(serviço);
		attributes.addFlashAttribute("mensagem", "Serviço adicionado com sucesso!");
		return "redirect:/{id}";
	}
	
	@RequestMapping("/deletarServiço")
	public String deletarServiço(String identificaçã){
		Serviço serviço = sr.findByid(identificaçã);
		sr.delete(serviço);
		
		Cliente cliente = serviço.getCliente();
		long idLong = cliente.getId();
		String id = "" + idLong;
		return "redirect:/" + id;
	}
		
}
