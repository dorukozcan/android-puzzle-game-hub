package com.example.project3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Game6 extends AppCompatActivity {

    private String hiddenWord;
    private String guessedWord;
    private int numAttempts;
    private TextView hiddenWordTextView;
    private EditText guessEditText;
    private Button guessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game6);

        hiddenWordTextView = findViewById(R.id.hiddenWordTextView);
        guessEditText = findViewById(R.id.guessEditText);
        guessButton = findViewById(R.id.guessButton);

        startNewGame();
    }

    public void makeGuess(View view) {
        String guess = guessEditText.getText().toString().toUpperCase();

        if (guess.isEmpty()) {
            Toast.makeText(this, "Enter a letter", Toast.LENGTH_SHORT).show();
            return;
        }

        if (guess.length() > 1) {
            Toast.makeText(this, "Enter only one letter", Toast.LENGTH_SHORT).show();
            return;
        }

        if (guessedWord.contains(guess)) {
            Toast.makeText(this, "You already guessed that letter", Toast.LENGTH_SHORT).show();
            return;
        }

        if (hiddenWord.contains(guess)) {
            StringBuilder sb = new StringBuilder(guessedWord);
            for (int i = 0; i < hiddenWord.length(); i++) {
                if (hiddenWord.charAt(i) == guess.charAt(0)) {
                    sb.setCharAt(i, guess.charAt(0));
                }
            }
            guessedWord = sb.toString();
            hiddenWordTextView.setText(guessedWord);

            if (!guessedWord.contains("_")) {
                endGame(true);
            }
        } else {
            numAttempts--;
            if (numAttempts <= 0) {
                endGame(false);
            } else {
                Toast.makeText(this, "Wrong guess! Attempts left: " + numAttempts, Toast.LENGTH_SHORT).show();
            }
        }

        guessEditText.getText().clear();
    }

    private String[] words = {
            "HANGMAN",
            "COMPUTER",
            "ANDROID",
            "JAVA",
            // Add more words here
    };


    private void startNewGame() {
        Random random = new Random();
        hiddenWord = words[random.nextInt(words.length)].toUpperCase();
        guessedWord = "";
        numAttempts = 6;

        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == ' ') {
                guessedWord += " ";
            } else {
                guessedWord += "_";
            }
        }

        hiddenWordTextView.setText(guessedWord);
        guessButton.setEnabled(true);
    }

    private void endGame(boolean win) {
        guessButton.setEnabled(false);

        if (win) {
            Toast.makeText(this, "Congratulations! You won!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Game over! You lost!", Toast.LENGTH_SHORT).show();
        }
    }
}
