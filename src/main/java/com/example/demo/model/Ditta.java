package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "ditta")
public class Ditta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
