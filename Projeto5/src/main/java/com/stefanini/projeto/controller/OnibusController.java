package com.stefanini.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Onibus;
import com.stefanini.projeto.service.OnibusService;

@CrossOrigin
@Controller
@RequestMapping(value = "/Onibus")
public class OnibusController {

	@Autowired
	private OnibusService service;
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Onibus> findAll() throws TreinaException {
		return service.findAll();
	}	
	@RequestMapping(value ="/Consultar/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Optional<Onibus> findById(@PathVariable long id) throws TreinaException{
	return service.findById(id);
	
}
	@RequestMapping(value="/salvar",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Onibus salvar(@RequestBody Onibus onibus)throws TreinaException{
	return service.salvar(onibus);}
	
	@RequestMapping(method = RequestMethod.PUT,value=("/alterar/{id}"), produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Onibus alterar(@RequestBody Onibus onibus) throws TreinaException{
		return service.alterar(onibus);
	}  
	@RequestMapping(method = RequestMethod.DELETE, value=("/excluir/{id}"), produces =MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String excluir(@PathVariable Long id) throws TreinaException{
		return service.excluir(id);
	}
	
		
	}