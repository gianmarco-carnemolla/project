package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value = {"id", "name"})
public class DittaDto {
	
	
	private Long id;
	@JsonProperty(value = "name")
	private String nome;
    
    public Long getId() {
		return id;
	}
	
   public void setId(Long id) {
		this.id = id;
	}
    
   public String getNome() {
		return nome;
	}
	
  public void setNome(String nome) {
		this.nome = nome;
	}
}
