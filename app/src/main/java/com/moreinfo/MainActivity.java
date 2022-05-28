package com.moreinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    Spinner placeSpinner;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeSpinner = (Spinner) findViewById(R.id.placementSpinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.placement_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeSpinner.setAdapter(adapter);

        DAOReport daoR = new DAOReport();
        //listerner when submit clicked
        //create new report object with values from spinners and translate to string
        //call add from daoR

    }
}