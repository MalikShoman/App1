package com.cs.assignment1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    private Button btn;
    private EditText fname;
    private EditText lname;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF018786"));
        actionBar.setBackgroundDrawable(colorDrawable);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.Email);
        spinner = findViewById(R.id.spnGender);
        btn=findViewById(R.id.button);
        populateSpinner();
    }

    public void chk_onClick(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            btn.setEnabled(true);
        }
        else
            btn.setEnabled(false);

    }

    private void populateSpinner() {
        ArrayList<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("female");

        ArrayAdapter<String> adpt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, gender);
        spinner.setAdapter(adpt);
    }

    public void btn_save(View view) {
        Spinner spnGender = findViewById((R.id.spnGender));
        String str = spnGender.getSelectedItem().toString();
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);

        Intent intent = new Intent(this, MainActivity2.class);
        String data = "" + (fname.getText().toString()) + "\n" + (lname.getText().toString()) + "\n" + (email.getText().toString()) + "\n" + str;
        intent.putExtra("DATA", data);
        startActivity(intent);
    }


}