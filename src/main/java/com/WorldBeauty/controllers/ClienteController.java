package com.WorldBeauty.controllers;

import javax.validation.Valid;

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
		return "Cliente/formCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes){
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
		ModelAndView mv = new ModelAndView("Cliente/ListaClientes");
		Iterable<Cliente> clientes = cr.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@RequestMapping("/Clientes")
	public ModelAndView listaclientesgenero(String genero){
		ModelAndView mv = new ModelAndView("Cliente/ListaClientes");
		Iterable<Cliente> clientes = cr.findAllBygenero(genero);
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@RequestMapping(value="/Cliente/{id}", method=RequestMethod.GET)
	public ModelAndView serviçoscliente(@PathVariable("id") long id){
		Cliente cliente = cr.findByid(id);
		ModelAndView mv = new ModelAndView("Cliente/DetalhesCliente");
		mv.addObject("cliente", cliente);
		
		Iterable<Serviço> serviços = sr.findByCliente(cliente);
		mv.addObject("serviços", serviços);
		
		return mv;
	}
	
	@RequestMapping(value="/Cliente/{id}", method=RequestMethod.POST)
	public String detalhesServiçoPost(@PathVariable("id") long id,  Serviço serviço,  BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/Cliente/{id}";
		}
		Cliente cliente = cr.findByid(id);
		serviço.setCliente(cliente);
		sr.save(serviço);
		attributes.addFlashAttribute("mensagem", "Serviço adicionado com sucesso!");
		return "redirect:/Cliente/{id}";
	}
	
	@RequestMapping("/deletarCliente")
	public String deletarCliente(long id){
		Cliente cliente = cr.findByid(id);
		cr.delete(cliente);
		return "redirect:/Clientes";
	}
	
	@RequestMapping("/deletarServiço")
	public String deletarServiço(String identificação){
		Serviço serviço = sr.findByid(identificação);
		sr.delete(serviço);
		
		Cliente cliente = serviço.getCliente();
		long idLong = cliente.getId();
		String id = "" + idLong;
		return "redirect:/Cliente/" + id;
	}
		
}
