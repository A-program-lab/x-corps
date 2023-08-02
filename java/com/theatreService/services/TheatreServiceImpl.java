package com.theatreService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.theatreService.repository.TheatreRepository;
import com.theatreService.entity.City;
import com.theatreService.entity.Theatre;
import com.theatreService.repository.CityRepository;

@Service
public class TheatreServiceImpl implements TheatreService {
    
    private final TheatreRepository theatreRepository;
    private final CityRepository cityRepository;

    @Autowired
    public TheatreServiceImpl(TheatreRepository theatreRepository, CityRepository cityRepository) {
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
    }

//    @Override
//    @Transactional
//    public void addTheatreInCity(String cityId, Theatre theatre) {
//        City city = cityRepository.findById(cityId).orElse(null);
//        if (city != null) {
//            theatre.setCity(city);
//            city.addTheatre(theatre);
//            theatreRepository.save(theatre);
//        }
//    }
    @Override
    @Transactional
    public void addTheatreInCity(String cityId, Theatre theatre) {
        City city = cityRepository.findById(cityId).orElse(null);
        if (city != null) {
        	theatre.setCity(city);
            theatreRepository.save(theatre);
            city.addTheatre(theatre);
            cityRepository.save(city);
        }
    }
//   



    @Override
//    @Transactional(readOnly = true)
    public List<Theatre> getTheatreInCity(String cityId) {
        City city = cityRepository.findById(cityId).orElse(null);
        if (city != null) {
            return city.getTheatres();
        }
        return new ArrayList<>();
    }
    
//    public List<Theatre> getTheatreInCity(String cityName){
//		return theatreRepository.findByCity(cityName);
//	}

    @Override
    @Transactional
    public void removeTheatreInCity(String cityId, String theatreId) {
        City city = cityRepository.findById(cityId).orElse(null);
        if (city != null) {
            Theatre theatre = theatreRepository.findById(theatreId).orElse(null);
            if (theatre != null) {
                city.removeTheatre(theatre);
                theatreRepository.delete(theatre);
            }
        }
    }
}

