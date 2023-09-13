package com.example.universeplanetsapp;
//This class is acting as a model class for our ListView.
public class Planet {
    //Step one Attributes
    private String planetName;
    private String moonCount;
    private int planetImage;

    //Step Two Constructor
    public Planet(String planetName, String moonCount, int planetImage) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;}

    //Step three getter and setter create to access data outside the class so we use this.
    public String getPlanetName() {
        return planetName;
    }
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
    public String getMoonCount() {
        return moonCount;}
    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }
    public int getPlanetImage() {
        return planetImage;
    }
    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }
}
