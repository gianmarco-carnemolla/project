package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Automobile;
import com.example.demo.repository.AutomobileRepository;

@Service
public class AutomobileService {

	@Autowired
	private AutomobileRepository automobileRepository;

	public Automobile findById(Long id) {
		Optional<Automobile> obj = automobileRepository.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		} else {
			return new Automobile();
		}
	}

	public List<Automobile> findAll() {
		return automobileRepository.findAll();
	}

	public Object insertAutomobile(Automobile automobile) {
		return automobileRepository.save(automobile);
	}
}