package com.bf1el.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bf1el.model.Nationality;
import com.bf1el.repository.NationalityRepository;

@Service
public class NationalityService {

	private NationalityRepository nationalityRepository;
	
	@Autowired
	public NationalityService(NationalityRepository nationalityRepository) {
		this.nationalityRepository = nationalityRepository;
	}
	
	public List<Nationality> getAll(){
		return this.nationalityRepository.findAll();
	}
}
