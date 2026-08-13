package com.example.project3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Game8 extends AppCompatActivity {

    private TextView problemTextView, resultTextView;
    private EditText answerEditText;
    private Button submitButton;
    private int num1, num2, correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game8);

        problemTextView = findViewById(R.id.problemTextView);
        resultTextView = findViewById(R.id.resultTextView);
        answerEditText = findViewById(R.id.answerEditText);
        submitButton = findViewById(R.id.submitButton);

        generateProblem();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void generateProblem() {
        Random random = new Random();
        num1 = random.nextInt(10) + 1;
        num2 = random.nextInt(10) + 1;
        correctAnswer = num1 + num2;
        problemTextView.setText(num1 + " + " + num2 + " = ?");
        resultTextView.setVisibility(View.INVISIBLE);
    }

    private void checkAnswer() {
        String answerString = answerEditText.getText().toString();
        if (!answerString.isEmpty()) {
            int userAnswer = Integer.parseInt(answerString);
            if (userAnswer == correctAnswer) {
                resultTextView.setText("Correct!");
                resultTextView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                generateProblem();
                answerEditText.setText("");
            } else {
                resultTextView.setText("Incorrect! Try again.");
                resultTextView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                answerEditText.setText("");
            }
            resultTextView.setVisibility(View.VISIBLE);
        }
    }

}
