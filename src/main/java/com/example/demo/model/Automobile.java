package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "automobile")
public class Automobile {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
    private String cognome;
    private String targa;
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
