package com.theatreService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theatreService.entity.City;
import com.theatreService.entity.Screen;
import com.theatreService.entity.Theatre;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
	
	//List<String> getCity(String cityName);
    // Custom query methods can be defined here if needed

}