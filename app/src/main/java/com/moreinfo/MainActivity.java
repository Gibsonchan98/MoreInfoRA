package com.moreinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    Spinner placeSpinner, conditionSpinner, speciesSpinner;
    ArrayAdapter<CharSequence> adapter;
    AppCompatButton submitBtn, mediaBtn;
    private final int RequestPermissionCode = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize spinners
        placeSpinner = (Spinner) findViewById(R.id.spinner_placement);
        conditionSpinner = (Spinner) findViewById(R.id.spinner_condition);
        speciesSpinner = (Spinner) findViewById(R.id.spinner_species);
        //populate spinner placement

        adapter = ArrayAdapter.createFromResource(this,
                R.array.placement_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeSpinner.setAdapter(adapter);

        //populate spinner condition
        adapter = ArrayAdapter.createFromResource(this,
                R.array.condition_array, android.R.layout.simple_spinner_item);
        conditionSpinner.setAdapter(adapter);
        //populate spinner species
        adapter = ArrayAdapter.createFromResource(this,
                R.array.species_array, android.R.layout.simple_spinner_item);
        speciesSpinner.setAdapter(adapter);

        //initialize buttons
        submitBtn = findViewById(R.id.btn_submit);
        mediaBtn = findViewById(R.id.btn_media);



        DAOReport daoR = new DAOReport();
        //listerner when submit clicked
        //create new report object with values from spinners and translate to string
        //call add from daoR
        submitBtn.setOnClickListener(v->
        {
            String place = placeSpinner.getSelectedItem().toString();
            String cond = conditionSpinner.getSelectedItem().toString();
            String species = speciesSpinner.getSelectedItem().toString();
            Report report = new Report(place,species,cond);
            daoR.add(report).addOnSuccessListener(suc->
            {
                Toast.makeText(this,"Report Submitted",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

        //For hashmap, UID or RID will be used as key to update and manage it

        //event listener for mediabtn
        mediaBtn.setOnClickListener(v->{
            if(hasCameraPermission()){
                openCamera();
            }else {
                requestPermission();
            }
        });

    }


    //returns true if permission is granted
    private boolean hasCameraPermission() {
        return ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {Manifest.permission.CAMERA}, RequestPermissionCode);
    }

    //intent to start CameraActivity fragment
    private void openCamera(){
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }



}