package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AutomobileDto;
import com.example.demo.model.Automobile;
import com.example.demo.service.AutomobileService;

@RestController
@RequestMapping("/api/")
public class AutomobileRestController {

	@Autowired
	private AutomobileService automobileService;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	@RequestMapping("/proprietario")
	public String getProprietarioAutomobile(@RequestBody AutomobileDto automobile) {
		return "Il proprietario è " + automobile.getNome() + " " + automobile.getCognome();
	}

	@PostMapping
	@RequestMapping("/ditta")
	public String getDittaAutomobile(@RequestBody AutomobileDto automobile) {
		return "La ditta è " + automobile.getDitta();
	}

	@PostMapping
	@RequestMapping("/targa")
	public String getTargaAutomobile(@RequestBody AutomobileDto automobile) {
		return "La targa è " + automobile.getTarga();
	}

	@GetMapping(path = "/{id}")
	public AutomobileDto getObjById(@PathVariable Long id) {
		return mapper.map(automobileService.findById(id), AutomobileDto.class);
	}

	@GetMapping(value = "/getCompany")
	public AutomobileDto getDemoAutomobile() {
		AutomobileDto automobile = new AutomobileDto();
		automobile.setDitta("Ferrari");
		return automobile;
	}

	/*
	 * @GetMapping(value = "/all") public List<Automobile> getAll() { return
	 * (List<Automobile>) automobileService.findAll(); }
	 */

	@GetMapping(value = "/all")
	public List<AutomobileDto> getAll() {
		List<Automobile> cars = automobileService.findAll();
		List<AutomobileDto> carsDto = new ArrayList<>();

		for (Automobile automobile : cars) {
			AutomobileDto dto = mapper.map(automobile, AutomobileDto.class);
			carsDto.add(dto);
		}
		return carsDto;
	}
}
