package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DittaDto;
import com.example.demo.model.Ditta;
import com.example.demo.service.DittaService;

@RestController
@RequestMapping("/api/ditta")
public class DittaRestController {
     
	@Autowired
	private DittaService dittaService;

	@Autowired
	private ModelMapper mapper;
	
	@GetMapping(value = "/all")
	@ResponseStatus(HttpStatus.OK)
	public List<DittaDto> getAll() {
		List<Ditta> companies = dittaService.findAll();
		List<DittaDto> companiesDto = new ArrayList<>();

		for (Ditta ditta : companies) {
			DittaDto dto = mapper.map(ditta, DittaDto.class);
			companiesDto.add(dto);
		}
		return companiesDto;
	}
}
