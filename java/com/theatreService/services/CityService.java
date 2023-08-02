package com.theatreService.services;
import java.util.List;

import com.theatreService.entity.*;
public interface CityService {
    void addCity(City city);
    List<City> getAllCity();
    void removeCity(String cityId);
	City findOne(String cityId);
	List<Theatre> getTheatreByCity(City theCity);
	//List<Theatre> getTheatreByCity1(City theCity);
}


