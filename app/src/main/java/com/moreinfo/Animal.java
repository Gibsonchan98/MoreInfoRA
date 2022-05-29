package com.moreinfo;

import java.util.UUID;

/*Class represent animal that is included in report*/
public class Animal {
    private String placement, condition, species, age;
    private boolean safe;
    private char sex;
    private String animalID;

    public Animal(){
        generateID();
    }

    public Animal(String species,Boolean safe){
        generateID();
        setSpecies(species);
        this.safe = safe;
    }

    public Animal(String species,String placement, String condition){
        generateID();
        setSpecies(species);
        setCondition(condition);
        setPlacement(placement);
    }

    public String getSpecies(){
        return this.species;
    }

    public String getPlacement(){
        return placement;
    }

    public String getCondition(){
        return condition;
    }

    private void setPlacement(String placement){
        this.placement = placement;
    }

    private void setCondition(String condition){
        this.condition = condition;
    }

    private void setSpecies(String species){
        this.species = species;
    }

    //generate unique ID for animal
    private void generateID(){
        this.animalID = "A" + UUID.randomUUID().toString();
    }

    public String getAnimalID(){
        return this.animalID;
    }

}
