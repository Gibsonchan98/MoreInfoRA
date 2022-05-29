package com.moreinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    Spinner placeSpinner;
    ArrayAdapter<CharSequence> adapter;
    AppCompatButton submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeSpinner = (Spinner) findViewById(R.id.spinner_placement);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.placement_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeSpinner.setAdapter(adapter);

        submitBtn = findViewById(R.id.btn_submit);


        DAOReport daoR = new DAOReport();
        //listerner when submit clicked
        //create new report object with values from spinners and translate to string
        //call add from daoR
        submitBtn.setOnClickListener(v->
        {
            Report report = new Report(placeSpinner.getSelectedItem().toString());
            //Log.i("This is value"+ report.getPlacement());
            daoR.add(report).addOnSuccessListener(suc->
            {
                Toast.makeText(this,"Report is saved",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

        //For hashmap, UID or RID will be used as key to update and manage it

    }
}