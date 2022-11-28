package com.example.exercice_calculbinaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button btnStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnPlay);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnStart.setOnClickListener(this::startGame);
    }


    // Listener for the button
    public void startGame(android.view.View view) {
        Intent intent = new Intent(this, GameActivity.class);

        // Get the selected radio button

        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
        String selectedRadioButtonText = selectedRadioButton.getText().toString();
        intent.putExtra("mode", selectedRadioButtonText);

        startActivity(intent);
    }

}