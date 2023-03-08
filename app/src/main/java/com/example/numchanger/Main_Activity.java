package com.example.numchanger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.Contract;


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

    ImageView github_link, update_IV;

    static String PresentNumberSystemAutoCompleteTV;
    static String AfterChangingNumberSystemAutoCompleteTV;
    static String Present_Number_System_Text_Input_EditT;

    /* --------------Quit_DialogBox--------------- */

    Button BackButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*<------------Night mode disable--------->*/

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        /* --------------DialogBox Creation--------------- */

        Dialog UpdateDialog = new Dialog(this);
        UpdateDialog.setContentView(R.layout.update_dialog_box);

        /*---------------Hooks Quit DialogBox--------------->*/

        BackButton = UpdateDialog.findViewById(R.id.Back_Button);

        /* --------------Hooks--------------- */

        selectPresentNumberSystemAutoCompleteTV = findViewById(R.id.select_Present_Number_System_Auto_Complete_TV);
        selectAfterChangingNumberSystemAutoCompleteTV = findViewById(R.id.select_After_Changing_Number_System_Auto_Complete_TV);

        convert_Button = findViewById(R.id.convert_Button);
        restart_Button = findViewById(R.id.restart_Button);
        github_link = findViewById(R.id.github_link);
        Project_Link = findViewById(R.id.Project_Link);

        enter_Present_Number_System_Text_Input_EditT = findViewById(R.id.enter_Present_Number_System_Text_Input_EditT);

        Result_TV = findViewById(R.id.Result_TV);
        update_IV = findViewById(R.id.update_IV);

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

        /*<------------Handle_back_Button_On_click_Listener--------->*/

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialog.dismiss();
            }
        });

        /*<------------Handle_Update_Button_On_click_Listener--------->*/

        update_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialog.show();
            }
        });

        /* --------------Present_Number_System--------------- */

        adapterPresentNumberSystem = new ArrayAdapter<String>(this, R.layout.dropdown, NumberSystem);
        selectPresentNumberSystemAutoCompleteTV.setAdapter(adapterPresentNumberSystem);

        /* --------------Changing_Number_System--------------- */

        adapterChangingNumberSystem = new ArrayAdapter<String>(this, R.layout.dropdown, NumberSystem);
        selectAfterChangingNumberSystemAutoCompleteTV.setAdapter(adapterChangingNumberSystem);

        /* --------------Get_and_Set_Number_System--------------- */

        convert_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PresentNumberSystemAutoCompleteTV = selectPresentNumberSystemAutoCompleteTV.getText().toString();
                AfterChangingNumberSystemAutoCompleteTV = selectAfterChangingNumberSystemAutoCompleteTV.getText().toString();
                Present_Number_System_Text_Input_EditT = enter_Present_Number_System_Text_Input_EditT.getText().toString();

                if (!Present_Number_System_Text_Input_EditT.isEmpty() && Present_Number_System_Text_Input_EditT.length() <= 25) {
                    switch (PresentNumberSystemAutoCompleteTV) {
                        case "Binary": {
                            switch (AfterChangingNumberSystemAutoCompleteTV) {
                                case "Binary": {

                                    if (Bi_Format(Present_Number_System_Text_Input_EditT)) {
                                        try {
                                            Toast.makeText(getApplicationContext(), "Same Data type!!!", Toast.LENGTH_SHORT).show();
                                            Result_TV.setText(Present_Number_System_Text_Input_EditT);
                                        } catch (Exception e) {
                                            Toast.makeText(getApplicationContext(), "it's very big number!", Toast.LENGTH_SHORT).show();
                                        }

                                    } else {
                                        Result_TV.setText(null);
                                    }
                                    break;
                                }
                                case "Decimal": {
                                    try {
                                        Result_TV.setText(Bi_to_de(Present_Number_System_Text_Input_EditT));
                                        break;
                                    } catch (Exception e) {
                                        Toast.makeText(getApplicationContext(), "it's very big number!", Toast.LENGTH_SHORT).show();
                                        Result_TV.setText(null);
                                    }
                                    break;
                                }
                                case "Octal": {
                                    try {
                                        Result_TV.setText(Bi_to_Oc(Present_Number_System_Text_Input_EditT));
                                    } catch (Exception e) {
                                        Toast.makeText(getApplicationContext(), "it's very big number!", Toast.LENGTH_SHORT).show();
                                        Result_TV.setText(null);
                                    }
                                    break;
                                }
                                case "Hexadecimal": {
                                    try {
                                        Result_TV.setText(Bi_to_HeDe(Present_Number_System_Text_Input_EditT));

                                    } catch (Exception e) {
                                        Toast.makeText(getApplicationContext(), "it's very big number!", Toast.LENGTH_SHORT).show();
                                        Result_TV.setText(null);
                                    }
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
                                    try {
                                        Result_TV.setText(De_to_Bi(Present_Number_System_Text_Input_EditT));

                                    } catch (Exception e) {
                                        Toast.makeText(getApplicationContext(), "it's very big number!", Toast.LENGTH_SHORT).show();
                                        Result_TV.setText(null);
                                    }
                                    break;
                                }
                                case "Decimal": {
                                    if (De_Format(Present_Number_System_Text_Input_EditT)) {
                                        try {
                                            Toast.makeText(getApplicationContext(), "Same Data type!!!", Toast.LENGTH_SHORT).show();
                                            Result_TV.setText(Present_Number_System_Text_Input_EditT);
                                        } catch (Exception e) {
                                            Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT).show();
                                        }

                                    } else {
                                        Result_TV.setText(null);
                                    }
                                    break;
                                }
                                case "Octal": {
                                    try {
                                        Result_TV.setText(De_to_Oc(Present_Number_System_Text_Input_EditT));

                                    } catch (Exception e) {
                                        Toast.makeText(getApplicationContext(), "it's very big number!", Toast.LENGTH_SHORT).show();
                                        Result_TV.setText(null);
                                    }
                                    break;
                                }
                                case "Hexadecimal": {
                                    try {
                                        Result_TV.setText(De_to_HeDe(Present_Number_System_Text_Input_EditT));

                                    } catch (Exception e) {
                                        Toast.makeText(getApplicationContext(), "it's very big number!", Toast.LENGTH_SHORT).show();
                                        Result_TV.setText(null);
                                    }
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
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        restart_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPresentNumberSystemAutoCompleteTV.getText();
                selectPresentNumberSystemAutoCompleteTV.setText(null);
                selectAfterChangingNumberSystemAutoCompleteTV.setText(null);
                enter_Present_Number_System_Text_Input_EditT.setText(null);
                Result_TV.setText(null);
                selectPresentNumberSystemAutoCompleteTV.requestFocus();
            }
        });
    }

    @Nullable
    private String De_to_HeDe(String num) {
        if (De_Format(num)) {
            String HexaDec = dec_to_HexaDec(Integer.parseInt(num));
            return HexaDec;
        }
        return null;
    }

    @Nullable
    private String De_to_Oc(String num) {
        if (De_Format(num)) {
            String octal = String.valueOf(dec_to_octal(Integer.parseInt(num)));
            return octal;
        }
        return null;
    }

    @Nullable
    private String De_to_Bi(String num) {
        if (De_Format(num)) {
            String Binary;
            return Binary = "" + dec_to_Bi(Integer.parseInt(num));
        }
        return null;
    }

    @NonNull
    private static String dec_to_Bi(int Dec) {
        String Binary = "";
        while (Dec != 0) {
            Binary = Binary + Dec % 2;
            Dec /= 2;
        }
        Binary = String.valueOf(Reverse_String(Binary));
        return Binary;
    }

    @Nullable
    private String Bi_to_HeDe(String num) {
        if (Bi_Format(num)) {
            int Dec = Integer.parseInt(num, 2);
            String HexaDec = dec_to_HexaDec(Dec);
            return HexaDec;
        }
        return null;
    }

    @NonNull
    private static String dec_to_HexaDec(int dec) {
        String HexaDec = "";
        while (dec != 0) {
            HexaDec = HexaDec + Remainder(dec % 16);
            dec /= 16;
        }
        HexaDec = String.valueOf(Reverse_String(HexaDec));
        return HexaDec;
    }

    private static String Reverse_String(@NonNull String string) {
        String nstr = "";
        char ch;
        for (int i = 0; i < string.length(); i++) {
            ch = string.charAt(i); //extracts each character
            nstr = ch + nstr; //adds each character in front of the existing string
        }
        return nstr;
    }

    @Nullable
    @Contract(pure = true)
    private static String Remainder(int i) {
        switch (i) {
            case 1: {
                return "1";
            }
            case 2: {
                return "2";
            }
            case 3: {
                return "3";
            }
            case 4: {
                return "4";
            }
            case 5: {
                return "5";
            }
            case 6: {
                return "6";
            }
            case 7: {
                return "7";
            }
            case 8: {
                return "8";
            }
            case 9: {
                return "9";
            }
            case 10: {
                return "A";
            }
            case 11: {
                return "B";
            }
            case 12: {
                return "C";
            }
            case 13: {
                return "D";
            }
            case 14: {
                return "E";
            }
            case 15: {
                return "F";
            }
        }
        return "";
    }

    @Nullable
    private String Bi_to_Oc(String num) {
        if (Bi_Format(num)) {
            int Dec = Integer.parseInt(num, 2);
            return ("" + dec_to_octal(Dec));
        }
        return null;
    }

    private static String dec_to_octal(int Dec) {
        String Octal = "";
        while (Dec != 0) {
            Octal = Octal + Dec % 8;
            Dec /= 8;
        }
        Octal = String.valueOf(Reverse_String(Octal));
        return Octal;
    }

    public String Bi_to_de(String num) {
        if (Bi_Format(num)) {
            int result = Integer.parseInt(num, 2);
            return ("" + result);
        }
        return null;
    }

    private boolean Bi_Format(@NonNull String num) {
        String result = num.replace("1", "");
        result = result.replace("0", "");
        if (result.isEmpty()) {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Fill Binary Number", Toast.LENGTH_SHORT).show();
        return false;
    }

    private boolean De_Format(@NonNull String num) {
        String result;

        result = num.replace("0", "");
        result = result.replace("1", "");
        result = result.replace("2", "");
        result = result.replace("3", "");
        result = result.replace("4", "");
        result = result.replace("5", "");
        result = result.replace("6", "");
        result = result.replace("7", "");
        result = result.replace("8", "");
        result = result.replace("9", "");
        if (result.isEmpty()) {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Fill Decimal Number", Toast.LENGTH_SHORT).show();
        return false;
    }

}