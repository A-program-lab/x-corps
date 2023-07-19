package com.theatreService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theatreService.entity.City;
import com.theatreService.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, String> {

//	int countByTheatre(String theatreId);
//
//	//void save(Screen screen);
//	Optional<Screen> findByScreenId(String screenId);

    // Custom query methods can be defined here if needed

}
