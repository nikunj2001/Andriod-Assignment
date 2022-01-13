package com.example.morrassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputLayout cardNumber, expDate, CVV, firstName, lastName;
    View submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardNumber = findViewById(R.id.cardNumber);
        expDate = findViewById(R.id.expDate);
        CVV = findViewById(R.id.CVV);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        submitButton = findViewById(R.id.submit_payment);
    }

    public void submit(View view) {
        if (!validateCard() | !validateExpDate() | !validateCVV() | !validateFirstName() | !validateLastName()){
            return;
        }
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Payment Successful")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).show();
    }
