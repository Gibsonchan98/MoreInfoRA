package com.moreinfo;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOReport {

    private DatabaseReference dbReference;

    public DAOReport(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbReference = db.getReference(Report.class.getSimpleName());
    }

    //return task as a value because pattern business logic and UI
    public Task<Void> add(Report report){
        //push report object
        if(report == null){
            //throw exception
        }
        return dbReference.push().setValue(report);
    }
}
