package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value = {"id", "name", "surname", "company", "plate"})
public class AutomobileDto {
	
	private Long id;
	@JsonProperty(value = "name")
	private String nome;
	@JsonProperty(value = "surname")
	private String cognome;
	@JsonProperty(value = "plate")
	private String targa;
	@JsonProperty(value = "company")
	private String ditta;
    
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
	
   public String getCognome() {
		return cognome;
	}
	
   public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
   public String getTarga() {
		return targa;
	}
	
   public void setTarga(String targa) {
		this.targa = targa;
	}
	
   public String getDitta() {
		return ditta;
	}
	
   public void setDitta(String ditta) {
		this.ditta = ditta;
	}
}
