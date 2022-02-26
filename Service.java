package com.prog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.prog.Entity.Pateint_entity;
import com.prog.Repository.PatRepo;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private PatRepo repo;
	
	public void addPat(Pateint_entity p) {
		repo.save(p);
	}
	
	public List<Pateint_entity> getALLPat(){
		return repo.findAll();
	}
	
	public Pateint_entity getPatById(int id) {
		Optional<Pateint_entity> p=repo.findById(id);
		if(p.isPresent())
		{
			return p.get();
		}
		return null;
	}
	
	public void deletePat(int id) {
		repo.deleteById(id);
	}
}
