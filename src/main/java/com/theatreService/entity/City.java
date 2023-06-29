package com.theatreService.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "City")
public class City {
    
   @Id
//    @Column(name = "city_id")
    private String cityId;
    
 //   @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
   // @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Theatre> theatres;

    public City() {
        this.theatres = new ArrayList<>();
    }

    public City(String cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.theatres = new ArrayList<>();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    //    theatre.setCity(this);
    }

    public void removeTheatre(Theatre theatre) {
        theatres.remove(theatre);
    //    theatre.setCity(null);
    }
}
