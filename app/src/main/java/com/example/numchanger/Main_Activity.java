package com.example.numchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class Main_Activity extends AppCompatActivity {

    String[] NumberSystem = {"Binary", "Decimal", "Octal", "Hexadecimal"};

    AutoCompleteTextView selectPresentNumberSystemAutoCompleteTV;
    AutoCompleteTextView selectAfterChangingNumberSystemAutoCompleteTV;


    ArrayAdapter<String> adapterPresentNumberSystem;
    ArrayAdapter<String> adapterChangingNumberSystem;

    Button start_Button;
    Button restart_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* --------------Hooks--------------- */

        selectPresentNumberSystemAutoCompleteTV = findViewById(R.id.select_Present_Number_System_Auto_Complete_TV);
        selectAfterChangingNumberSystemAutoCompleteTV = findViewById(R.id.select_After_Changing_Number_System_Auto_Complete_TV);

        /* --------------Present_Number_System--------------- */

        adapterPresentNumberSystem = new ArrayAdapter<String>(this, R.layout.dropdown, NumberSystem);
        selectPresentNumberSystemAutoCompleteTV.setAdapter(adapterPresentNumberSystem);

        /* --------------Changing_Number_System--------------- */

        adapterChangingNumberSystem = new ArrayAdapter<String>(this, R.layout.dropdown, NumberSystem);
        selectAfterChangingNumberSystemAutoCompleteTV.setAdapter(adapterChangingNumberSystem);
    }
}