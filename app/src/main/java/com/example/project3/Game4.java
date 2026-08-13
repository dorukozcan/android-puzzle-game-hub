package com.example.project3;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game4 extends AppCompatActivity {

    private List<String> words;
    private String currentWord;
    private TextView questionTextView;
    private EditText answerEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);

        words = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "ORANGE", "MANGO", "GRAPE"));
        questionTextView = findViewById(R.id.question_textview);
        answerEditText = findViewById(R.id.answer_edittext);
        resultTextView = findViewById(R.id.result_textview);

        generateNewQuestion();
    }

    private void generateNewQuestion() {
        Random random = new Random();
        int index = random.nextInt(words.size());
        currentWord = words.get(index);

        String scrambledWord = scrambleWord(currentWord);
        questionTextView.setText(scrambledWord);
        answerEditText.setText("");
        resultTextView.setText("");
    }

    private String scrambleWord(String word) {
        char[] letters = word.toCharArray();
        Random random = new Random();

        for (int i = 0; i < letters.length; i++) {
            int j = random.nextInt(letters.length);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }

        return new String(letters);
    }

    public void submitAnswer(View view) {
        String answer = answerEditText.getText().toString().toUpperCase();

        if (TextUtils.isEmpty(answer)) {
            resultTextView.setText("Please enter an answer.");
        } else if (answer.equals(currentWord)) {
            resultTextView.setText("Congratulations! You guessed the word correctly.");
            generateNewQuestion();
        } else {
            resultTextView.setText("Wrong answer. Try again.");
        }
    }
}
