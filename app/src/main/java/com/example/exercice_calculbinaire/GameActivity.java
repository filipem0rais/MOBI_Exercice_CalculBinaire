package com.example.exercice_calculbinaire;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    String mode;
    Random random = new Random();
    int number;
    String numberInBinary;
    String regex;


    EditText editDonnee;
    EditText editReponse;
    Button btnTest;
    Button btnSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");
        Toast.makeText(this, mode, Toast.LENGTH_SHORT).show();

        editDonnee = (EditText) findViewById(R.id.editDonnee);
        editReponse = (EditText) findViewById(R.id.editReponse);
        btnTest = (Button) findViewById(R.id.btnTest);
        btnSuivant = (Button) findViewById(R.id.btnSuivant);

        btnTest.setOnClickListener(this::test);
        btnSuivant.setOnClickListener(this::suivant);

        generateQuestion();
    }

    private void suivant(View view) {
        generateQuestion();
        editReponse.setText("");
        editReponse.setBackgroundColor(Color.WHITE);
    }

    public void generateQuestion() {
        number = random.nextInt(255);
        numberInBinary = Integer.toBinaryString(number);
        while (numberInBinary.length() < 8) {
            numberInBinary = "0" + numberInBinary;
        }

        if (mode.equals("Binaire -> Décimal")) {
            editDonnee.setText(numberInBinary);
            regex = "[0-9]+";

        } else {
            editDonnee.setText(String.valueOf(number));
            regex = "[0-1]+";
        }
    }

    private void test(android.view.View view) {
        String reponse = editReponse.getText().toString();

        if (mode.equals("Binaire -> Décimal")) {
            if (reponse.matches(regex)) {
                if (reponse.equals(String.valueOf(number))) {
                    editReponse.setBackgroundColor(Color.parseColor("#00FF00"));
                } else {
                    editReponse.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            } else {
                Toast.makeText(getApplicationContext(), "Erreur dans l'entrée", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (reponse.matches(regex)) {
                if (reponse.equals(numberInBinary)) {
                    editReponse.setBackgroundColor(Color.parseColor("#00FF00"));
                } else {
                    editReponse.setBackgroundColor(Color.parseColor("#FF0000"));
                }
            } else {
                Toast.makeText(getApplicationContext(), "Erreur dans l'entrée", Toast.LENGTH_SHORT).show();
            }
        }
    }

}

