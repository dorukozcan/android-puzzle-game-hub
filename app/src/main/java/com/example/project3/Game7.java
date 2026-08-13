package com.example.project3;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Game7 extends AppCompatActivity {

    private TextView resultTextView;
    private Button rollButton;

    private int point = 0;
    private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game7);

        resultTextView = findViewById(R.id.resultTextView);
        rollButton = findViewById(R.id.rollButton);
    }

    public void rollDice(View view) {
        if (gameOver) {
            resetGame();
        } else {
            rollButton.setEnabled(false);

            Random rand = new Random();
            int dice1 = rand.nextInt(6) + 1;
            int dice2 = rand.nextInt(6) + 1;
            int sum = dice1 + dice2;

            String resultText = "Dice 1: " + dice1 + "\nDice 2: " + dice2 + "\nSum: " + sum;

            if (point == 0) {
                if (sum == 7 || sum == 11) {
                    resultText += "\n\nYou win!";
                    gameOver = true;
                } else if (sum == 2 || sum == 3 || sum == 12) {
                    resultText += "\n\nYou lose!";
                    gameOver = true;
                } else {
                    resultText += "\n\nPoint: " + sum;
                    point = sum;
                }
            } else {
                if (sum == point) {
                    resultText += "\n\nYou win!";
                    gameOver = true;
                } else if (sum == 7) {
                    resultText += "\n\nYou lose!";
                    gameOver = true;
                } else {
                    resultText += "\n\nPoint: " + point;
                }
            }

            resultTextView.setText(resultText);
            rollButton.setText("Roll Again");

            if (!gameOver) {
                rollButton.setEnabled(true);
            }
        }
    }

    private void resetGame() {
        point = 0;
        gameOver = false;
        resultTextView.setText("");
        rollButton.setText("Roll");
        rollButton.setEnabled(true);
    }
}
