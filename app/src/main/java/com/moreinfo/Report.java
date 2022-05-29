package com.moreinfo;

import java.util.List;

public class Report {

    private String status;
    private int reportID, longitute, lattitude, animalQuantity;
    private List<Animal> animalList;
    Boolean safe;

    public Report(){
    }

    //testing constructor
    public Report(String placement, String condition, String species){
        //create animal object
        animalList.add(new Animal(species,placement,condition));
    }
    //Information needed for simple report
    public Report(String species,String location,Boolean safe){
        Animal animal = new Animal(species,safe);
    }

    //More info report
    public Report(String species,String location,Boolean safe,String condition, String placement){}

    public Boolean getSafe() {
        return safe;
    }

    public void setSafe(Boolean safe) {
        this.safe = safe;
    }
}
