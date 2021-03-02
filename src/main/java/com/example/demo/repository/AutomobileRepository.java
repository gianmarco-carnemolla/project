package com.example.demo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Automobile;

@Repository
public interface AutomobileRepository extends CrudRepository<Automobile, Long>{
	public List <Automobile> findAll();
}