package com.theatreService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theatreService.entity.Screen;
import com.theatreService.entity.Theatre;
import com.theatreService.repository.ScreenRepository;
import com.theatreService.repository.TheatreRepository;

@Service
public class ScreenServiceImpl implements ScreenService {
    
    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    @Autowired
    public ScreenServiceImpl(ScreenRepository screenRepository, TheatreRepository theatreRepository) {
        this.screenRepository = screenRepository;
        this.theatreRepository = theatreRepository;
    }

//    @Override
//    @Transactional
//    public void addScreen(String theatreId, Screen screen) {
//        Theatre theatre = theatreRepository.findById(theatreId).orElse(null);
//        if (theatre != null) {
//            screen.setTheatre(theatre);
//            theatre.addScreen(screen);
//            screenRepository.save(screen);
//        }
//    }
    
    @Override
    @Transactional
    public void addScreen(String theatreId, Screen screen) {
        Theatre theatre = theatreRepository.findById(theatreId).orElse(null);
        if (theatre != null) {
            Screen existingScreen = screenRepository.findById(screen.getScreenId()).orElse(null);
            if (existingScreen != null) {
                // Update the existing screen with new properties
                existingScreen.setScreenName(screen.getScreenName());
                // Set the theatre association
                existingScreen.setTheatre(theatre);
                // Save the updated screen
                screenRepository.save(existingScreen);
       
            } else {
                // Set the theatre association
                screen.setTheatre(theatre);
                // Save the new screen
                screenRepository.save(screen);
         
            }
        }
    }


    @Override
    @Transactional(readOnly = true)
    public List<Screen> getScreenInTheatre(String theatreId) {
        Theatre theatre = theatreRepository.findById(theatreId).orElse(null);
        if (theatre != null) {
            return theatre.getScreens();
        }
        return new ArrayList<>();
    }

//    @Override
//    @Transactional
//    public void removeScreen(String screenId) {
//        Screen screen = screenRepository.findById(screenId).orElse(null);
//        if (screen != null) {
//            Theatre theatre = screen.getTheatre();
//            if (theatre != null) {
//                theatre.removeScreen(screen);
//            }
//            screenRepository.delete(screen);
//        }
//    }
    @Override
    public void removeScreen(String theatreId, String screenId) {
        // Retrieve the theatre from the database
        Theatre theatre = theatreRepository.findById(theatreId).orElse(null);
        if (theatre == null) {
            throw new IllegalArgumentException("Theatre not found");
        }
        
        // Retrieve the screen from the theatre's list of screens
        Screen screenToRemove = null;
        for (Screen screen : theatre.getScreens()) {
            if (screen.getScreenId().equals(screenId)) {
                screenToRemove = screen;
                break;
            }
        }
        
        // Remove the screen from the theatre's list of screens
        if (screenToRemove != null) {
            theatre.getScreens().remove(screenToRemove);
            screenToRemove.setTheatre(null);
            screenRepository.delete(screenToRemove);
        } else {
            throw new IllegalArgumentException("Screen not found in the theatre");
        }
    }


    @Override
    @Transactional(readOnly = true)
    public int getScreenCountInTheatre(String theatreId) {
        Theatre theatre = theatreRepository.findById(theatreId).orElse(null);
        if (theatre != null) {
            return theatre.getScreens().size();
        }
        return 0;
    }
}

