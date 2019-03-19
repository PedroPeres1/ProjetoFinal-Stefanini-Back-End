package com.stefanini.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.TreinaException;

import com.stefanini.projeto.model.Onibus;
import com.stefanini.projeto.repository.OnibusRepository;

@Service
public class OnibusService {

	@Autowired
	private OnibusRepository repository;
	
	public List<Onibus> findAll() throws TreinaException {
		return (List<Onibus>) repository.findAll();
	}

	public Optional<Onibus> findById(Long id) throws TreinaException{
		return repository.findById(id);
	}
	
	public String excluir(Long id) throws TreinaException{
		 repository.deleteById(id);
		return "Deletado com sucesso!";
		
	}
	
	public Onibus salvar(Onibus onibus) throws TreinaException{
		return repository.save(onibus);
		
	}
	public Onibus alterar(Onibus onibus) throws TreinaException{
		if(repository.findById(onibus.getId())!=null){
			return repository.save(onibus);
		}else{throw new TreinaException("Onibus não existente."); 
		
	}
	
}}