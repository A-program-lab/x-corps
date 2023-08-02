package com.theatreService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.theatreService.entity.City;
import com.theatreService.entity.Screen;
import com.theatreService.entity.Theatre;
import com.theatreService.services.CityService;
import com.theatreService.services.CityServiceImpl;
import com.theatreService.services.ScreenService;
import com.theatreService.services.TheatreService;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private final TheatreService theatreService;
    private final CityService cityService;
    private final ScreenService screenService;

    @Autowired
    public TheatreController(TheatreService theatreService, CityService cityService, ScreenService screenService) {
        this.theatreService = theatreService;
        this.cityService = cityService;
        this.screenService = screenService;
    }
    
    @GetMapping("/")
    String return1(){
        return "Hello World";
    }

    // City endpoints
    @PostMapping("/cities")
    public ResponseEntity<String> addCity(@RequestBody City city) {
        cityService.addCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body("City added successfully");
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCity();
        return ResponseEntity.ok(cities);
    }
//    @GetMapping("/cities")
//	public List<City> getAllCities(){
//		
//    	return cityService.getAllCity();
//	}

    @DeleteMapping("/cities/{cityId}")
    public ResponseEntity<String> removeCity(@PathVariable String cityId) {
        cityService.removeCity(cityId);
        return ResponseEntity.ok("City removed successfully");
    }

    // Theatre endpoints
    @PostMapping("/{cityId}/theatres")
    public ResponseEntity<String> addTheatreInCity(@PathVariable String cityId, @RequestBody Theatre theatre) {
        theatreService.addTheatreInCity(cityId, theatre);
        return ResponseEntity.status(HttpStatus.CREATED).body("Theatre added successfully");
    }

    @GetMapping("/{cityId}/theatres")
    public ResponseEntity<List<Theatre>> getTheatreInCity(@PathVariable String cityId) {
        List<Theatre> theatres = theatreService.getTheatreInCity(cityId);
        return ResponseEntity.ok(theatres);
    }
    
//    @GetMapping("/{cityId}/theatres")
//    public ResponseEntity<String> getTheatreInCity(@PathVariable String cityId) {
//        City city = cityService.findOne(cityId);
//        if (city != null) {
//            String json = "[{\"cityId\":\"" + city.getCityId() + "\",\"cityName\":\"" + city.getCityName() + "\"}]";
//            return ResponseEntity.ok(json);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    
   // @GetMapping("/{Name}/theater")
//	public List<Theatre> getTheaterInCity(@PathVariable(value = "Name") String cityName){
//		
//		City theCity = cityService.findOne(cityName);
//		
//		return cityService.getTheatreByCity(theCity);
//	}

    @DeleteMapping("/{cityId}/theatres/{theatreId}")
    public ResponseEntity<String> removeTheatreInCity(@PathVariable String cityId, @PathVariable String theatreId) {
        theatreService.removeTheatreInCity(cityId, theatreId);
        return ResponseEntity.ok("Theatre removed successfully");
    }

    // Screen endpoints
    @PostMapping("/{theatreId}/screens")
    public ResponseEntity<String> addScreen(@PathVariable String theatreId, @RequestBody Screen screen) {
        screenService.addScreen(theatreId, screen);
        return ResponseEntity.status(HttpStatus.CREATED).body("Screen added successfully");
    }

    @GetMapping("/{theatreId}/screens")
    public ResponseEntity<List<Screen>> getScreenInTheatre(@PathVariable String theatreId) {
        List<Screen> screens = screenService.getScreenInTheatre(theatreId);
        return ResponseEntity.ok(screens);
    }

    @DeleteMapping("/{theatreId}/screens/{screenId}")
    public ResponseEntity<String> removeScreen(@PathVariable String theatreId, @PathVariable String screenId) {
        screenService.removeScreen(theatreId, screenId);
        return ResponseEntity.ok("Screen removed successfully");
    }

    @GetMapping("/{theatreId}/screens/count")
    public ResponseEntity<Integer> getScreenCountInTheatre(@PathVariable String theatreId) {
        int count = screenService.getScreenCountInTheatre(theatreId);
        return ResponseEntity.ok(count);
    }
}
