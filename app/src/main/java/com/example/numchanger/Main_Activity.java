package com.example.numchanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main_Activity extends AppCompatActivity {

    String[] NumberSystem = {"Binary", "Decimal", "Octal", "Hexadecimal"};

    AutoCompleteTextView selectPresentNumberSystemAutoCompleteTV;
    AutoCompleteTextView selectAfterChangingNumberSystemAutoCompleteTV;


    ArrayAdapter<String> adapterPresentNumberSystem;
    ArrayAdapter<String> adapterChangingNumberSystem;

    Button start_Button;
    Button restart_Button;

    TextView Project_Link;

    ImageView github_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*<------------Night mode disable--------->*/

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        /* --------------Hooks--------------- */

        selectPresentNumberSystemAutoCompleteTV = findViewById(R.id.select_Present_Number_System_Auto_Complete_TV);
        selectAfterChangingNumberSystemAutoCompleteTV = findViewById(R.id.select_After_Changing_Number_System_Auto_Complete_TV);

        start_Button = findViewById(R.id.start_Button);
        restart_Button = findViewById(R.id.restart_Button);
        github_link = findViewById(R.id.github_link);
        Project_Link = findViewById(R.id.Project_Link);

        /*<------------Handle_Github_link_On_click_Listener--------->*/

        github_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/joymridha2004"));
                startActivity(intent);
            }
        });

        /*<------------Handle_Github_Project_Link_On_click_Listener--------->*/

        Project_Link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/joymridha2004/NumChanger_Java_Application"));
                startActivity(intent);
            }
        });

        /* --------------Present_Number_System--------------- */

        adapterPresentNumberSystem = new ArrayAdapter<String>(this, R.layout.dropdown, NumberSystem);
        selectPresentNumberSystemAutoCompleteTV.setAdapter(adapterPresentNumberSystem);

        /* --------------Changing_Number_System--------------- */

        adapterChangingNumberSystem = new ArrayAdapter<String>(this, R.layout.dropdown, NumberSystem);
        selectAfterChangingNumberSystemAutoCompleteTV.setAdapter(adapterChangingNumberSystem);

    }
}