package com.example.project3;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Game5 extends AppCompatActivity {

    private ImageView moleImageView;
    private Handler handler;
    private Runnable moleRunnable;
    private Random random;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5);

        moleImageView = findViewById(R.id.moleImageView);
        handler = new Handler();
        random = new Random();
        score = 0;
    }

    public void startGame(View view) {
        view.setEnabled(false);  // Disable the start button during the game
        moleRunnable = new Runnable() {
            @Override
            public void run() {
                int maxX = getWindow().getDecorView().getWidth() - moleImageView.getWidth();
                int maxY = getWindow().getDecorView().getHeight() - moleImageView.getHeight();
                int randomX = random.nextInt(maxX);
                int randomY = random.nextInt(maxY);

                moleImageView.setX(randomX);
                moleImageView.setY(randomY);
                moleImageView.setVisibility(View.VISIBLE);  // Make the mole visible

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        moleImageView.setVisibility(View.INVISIBLE);  // Hide the mole
                        if (score < 10) {
                            handler.postDelayed(moleRunnable, getRandomDelay());
                        } else {
                            endGame();
                        }
                    }
                }, 1000);  // Mole visibility duration
            }
        };
        handler.post(moleRunnable);
    }

    public void whackMole(View view) {
        if (moleImageView.getVisibility() == View.VISIBLE) {
            score++;
            Toast.makeText(this, "Whacked! Score: " + score, Toast.LENGTH_SHORT).show();
        }
    }

    private int getRandomDelay() {
        return random.nextInt(2000) + 1000;  // Random delay between 1-3 seconds
    }

    private void endGame() {
        Toast.makeText(this, "Game Over! Final Score: " + score, Toast.LENGTH_LONG).show();
        moleImageView.setVisibility(View.INVISIBLE);
        handler.removeCallbacks(moleRunnable);
    }
}
