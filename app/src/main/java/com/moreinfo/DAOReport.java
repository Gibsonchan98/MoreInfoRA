package com.moreinfo;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAOReport {

    private DatabaseReference dbReference;


    public DAOReport(){
        FirebaseDatabase dbRootNode = FirebaseDatabase.getInstance();
        //Reference is making "Report" node as root
        dbReference = dbRootNode.getReference("Report");

    }

    //return task as a value because pattern business logic and UI
    public Task<Void> add(Report report){
        //push report object
        if(report == null){
            //throw exception
        }
        return dbReference.setValue(report);
    }

    public Task<Void> update(String key, HashMap<String,Object> hashMap){
       return dbReference.child(key).updateChildren(hashMap);
    }


}
