package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ditta;
import com.example.demo.repository.DittaRepository;

@Service
public class DittaService {
     
	@Autowired
	private DittaRepository dittaRepository;

	public List<Ditta> findAll() {
		return dittaRepository.findAll();
	}
}
