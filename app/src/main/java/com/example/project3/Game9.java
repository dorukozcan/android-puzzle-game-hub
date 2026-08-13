package com.example.project3;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game9 extends AppCompatActivity {

    private List<Integer> numbers;
    private Button firstButton;
    private Button secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game9);

        numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
            numbers.add(i); // Duplicate each number to create pairs
        }
        Collections.shuffle(numbers); // Randomize the order

        firstButton = null;
        secondButton = null;

        Button[] buttons = new Button[12];
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);
        buttons[9] = findViewById(R.id.button10);
        buttons[10] = findViewById(R.id.button11);
        buttons[11] = findViewById(R.id.button12);

        for (int i = 0; i < buttons.length; i++) {
            final int index = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                // Inside the OnClickListener for the buttons
                @Override
                public void onClick(View view) {
                    if (firstButton == null) {
                        firstButton = (Button) view;
                        firstButton.setText(numbers.get(index).toString());
                        firstButton.setEnabled(false);
                    } else if (secondButton == null) {
                        secondButton = (Button) view;
                        secondButton.setText(numbers.get(index).toString());
                        secondButton.setEnabled(false);
                        if (firstButton.getText().toString().equals(secondButton.getText().toString())) {
                            // Match found
                            Toast.makeText(Game9.this, "Matched!", Toast.LENGTH_SHORT).show();
                            firstButton = null;
                            secondButton = null;
                        } else {
                            // No match, delay and reset the buttons
                            Toast.makeText(Game9.this, "Not matched!", Toast.LENGTH_SHORT).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    resetButtons();
                                }
                            }, 1000); // Delay of 2 seconds (2000 milliseconds)
                        }
                    }
                }

            });
        }
    }

    private void resetButtons() {
        firstButton.setEnabled(true);
        secondButton.setEnabled(true);
        firstButton.setText("");
        secondButton.setText("");
        firstButton = null;
        secondButton = null;
    }

}
