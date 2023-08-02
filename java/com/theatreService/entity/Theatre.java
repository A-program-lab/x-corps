package com.theatreService.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.*;



@Entity
@Table(name = "Theatre")
public class Theatre {
    
    @Id
    @Column(name = "theatre_id")
    private String theatreId;

    @Column(name = "theatre_name")
    private String theatreName;

    @Column(name = "address")
    private String address;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
 
    private City city;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screen> screens;

    public Theatre() {
        this.screens = new ArrayList<>();
    }

    public Theatre(String theatreId, String theatreName, String address) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.address = address;
        this.screens = new ArrayList<>();
    }
            

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
        screen.setTheatre(this);
    }

    public void removeScreen(Screen screen) {
        screens.remove(screen);
        screen.setTheatre(null);
    }
}
