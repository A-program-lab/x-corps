package com.theatreService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Screen")
public class Screen {
    
    @Id
    @Column(name = "screen_id")
    private String screenId;

    @Column(name = "screen_name")
    private String screenName;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    public Screen() {
    }

    public Screen(String screenId, String screenName) {
        this.screenId = screenId;
        this.screenName = screenName;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
