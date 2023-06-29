package com.theatreService.services;

import java.util.List;

import com.theatreService.entity.Screen;

public interface ScreenService {
    void addScreen(String theatreId, Screen screen);
    List<Screen> getScreenInTheatre(String theatreId);
    void removeScreen(String theatreId, String screenId);
    int getScreenCountInTheatre(String theatreId);
}

