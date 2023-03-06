package com.example.numchanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class Main_Activity extends AppCompatActivity {

    String[] NumberSystem = {"Binary", "Decimal", "Octal", "Hexadecimal"};

    AutoCompleteTextView selectPresentNumberSystemAutoCompleteTV;
    AutoCompleteTextView selectAfterChangingNumberSystemAutoCompleteTV;

    TextInputEditText enter_Present_Number_System_Text_Input_EditT;


    ArrayAdapter<String> adapterPresentNumberSystem;
    ArrayAdapter<String> adapterChangingNumberSystem;

    Button convert_Button;
    Button restart_Button;

    TextView Project_Link, Result_TV;

    ImageView github_link;

    static String PresentNumberSystemAutoCompleteTV;
    static String AfterChangingNumberSystemAutoCompleteTV;
    static String Present_Number_System_Text_Input_EditT;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*<------------Night mode disable--------->*/

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        /* --------------Hooks--------------- */

        selectPresentNumberSystemAutoCompleteTV = findViewById(R.id.select_Present_Number_System_Auto_Complete_TV);
        selectAfterChangingNumberSystemAutoCompleteTV = findViewById(R.id.select_After_Changing_Number_System_Auto_Complete_TV);

        convert_Button = findViewById(R.id.convert_Button);
        restart_Button = findViewById(R.id.restart_Button);
        github_link = findViewById(R.id.github_link);
        Project_Link = findViewById(R.id.Project_Link);

        enter_Present_Number_System_Text_Input_EditT = findViewById(R.id.enter_Present_Number_System_Text_Input_EditT);

        Result_TV = findViewById(R.id.Result_TV);

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

        /* --------------Get_Number_System--------------- */

        convert_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PresentNumberSystemAutoCompleteTV = selectPresentNumberSystemAutoCompleteTV.getText().toString();
                AfterChangingNumberSystemAutoCompleteTV = selectAfterChangingNumberSystemAutoCompleteTV.getText().toString();
                Present_Number_System_Text_Input_EditT = enter_Present_Number_System_Text_Input_EditT.getText().toString();

                if (!Present_Number_System_Text_Input_EditT.isEmpty()) {
                    switch (PresentNumberSystemAutoCompleteTV) {
                        case "Binary": {
                            switch (AfterChangingNumberSystemAutoCompleteTV) {
                                case "Binary": {

                                    if(Bi_Format(Present_Number_System_Text_Input_EditT)) {
                                        Toast.makeText(getApplicationContext(), "Same Data type!!!", Toast.LENGTH_SHORT).show();
                                        Result_TV.setText(Present_Number_System_Text_Input_EditT);
                                    }else{
                                        Result_TV.setText(null);
                                    }
                                    break;
                                }
                                case "Decimal": {
                                    Result_TV.setText(Bi_to_de(Present_Number_System_Text_Input_EditT));
                                    break;
                                }
                                case "Octal": {
                                    Toast.makeText(getApplicationContext(), "Binary to Octal", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Hexadecimal": {
                                    Toast.makeText(getApplicationContext(), "Binary to Hexadecimal", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "": {
                                    Toast.makeText(getApplicationContext(), "Select After Data Type", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                            break;
                        }
                        case "Decimal": {
                            switch (AfterChangingNumberSystemAutoCompleteTV) {
                                case "Binary": {
                                    Toast.makeText(getApplicationContext(), "Decimal to Binary", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Decimal": {
                                    Toast.makeText(getApplicationContext(), "Same Data type!!!", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Octal": {
                                    Toast.makeText(getApplicationContext(), "Decimal to Octal", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Hexadecimal": {
                                    Toast.makeText(getApplicationContext(), "Decimal to Hexadecimal", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "": {
                                    Toast.makeText(getApplicationContext(), "Select After Data Type", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                            break;
                        }
                        case "Octal": {
                            switch (AfterChangingNumberSystemAutoCompleteTV) {
                                case "Binary": {
                                    Toast.makeText(getApplicationContext(), "Octal to Binary", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Decimal": {
                                    Toast.makeText(getApplicationContext(), "Octal to Decimal", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Octal": {
                                    Toast.makeText(getApplicationContext(), "Same Data type!!!", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Hexadecimal": {
                                    Toast.makeText(getApplicationContext(), "Octal to Hexadecimal", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "": {
                                    Toast.makeText(getApplicationContext(), "Select After Data Type", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                            break;
                        }
                        case "Hexadecimal": {
                            switch (AfterChangingNumberSystemAutoCompleteTV) {
                                case "Binary": {
                                    Toast.makeText(getApplicationContext(), "Hexadecimal to Binary", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Decimal": {
                                    Toast.makeText(getApplicationContext(), "Hexadecimal to Decimal", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Octal": {
                                    Toast.makeText(getApplicationContext(), "Hexadecimal to Octal", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "Hexadecimal": {
                                    Toast.makeText(getApplicationContext(), "Same Data type!!!", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                                case "": {
                                    Toast.makeText(getApplicationContext(), "Select After Data Type", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                            break;
                        }
                        case "": {
                            if (!AfterChangingNumberSystemAutoCompleteTV.isEmpty()) {
                                Toast.makeText(getApplicationContext(), "Select Present Data Type", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Select Both Data Type", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Enter Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        restart_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPresentNumberSystemAutoCompleteTV.setText(null);
                selectAfterChangingNumberSystemAutoCompleteTV.setText(null);
                enter_Present_Number_System_Text_Input_EditT.setText(null);
                Result_TV.setText(null);
                selectPresentNumberSystemAutoCompleteTV.requestFocus();
            }
        });
    }

    public String Bi_to_de(String num) {
        if (Bi_Format(num)) {
            int result = Integer.parseInt(num, 2);
            return ("" + result);
        }
        return null;
    }

    private boolean Bi_Format(String num) {
        String result = num.replace("1", "");
        result = result.replace("0", "");
        if (result.isEmpty()) {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Fill Binary Number", Toast.LENGTH_SHORT).show();
        return false;
    }

}