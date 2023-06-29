package com.theatreService.services;

import java.util.List;

import com.theatreService.entity.Theatre;

public interface TheatreService {
    void addTheatreInCity(String cityId, Theatre theatre);
    List<Theatre> getTheatreInCity(String cityName);
    void removeTheatreInCity(String cityId, String theatreId);
}

