package com.moreinfo;

public class Report {

    private String placement, condition;

    public Report(){

    }
    //Information needed for simple report
    public Report(String species,String location,Boolean safe){
    }

    //More info report
    public Report(String species,String location,Boolean safe,String condition, String placement){

    }

    public String getPlacement(){
        return placement;
    }

    public String getCondition(){
        return condition;
    }

    public void setPlacement(String placement){
        this.placement = placement;
    }

    public void setCondition(String condition){
        this.condition = condition;
    }
}
