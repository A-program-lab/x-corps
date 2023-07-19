package com.theatreService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theatreService.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, String>{

//	List<Theatre> findByCity(String cityId);

	

//	List<Theatre> findAll();
  // List<String> findByCityName(String cityName);


}
