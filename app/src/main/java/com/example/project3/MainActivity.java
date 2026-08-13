package com.example.project3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    public Button Button1;
    public Button Button2;
    public Button Button3;
    public Button Button4;
    public Button Button5;
    public Button Button6;
    public Button Button7;
    public Button Button8;
    public Button Button9;
    public Button Button10;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button1 = (Button) findViewById(R.id.button1);
        Button1.setOnClickListener(view -> openGame1());

        Button2 = (Button) findViewById(R.id.button2);
        Button2.setOnClickListener(view -> openGame2());

        Button3 = (Button) findViewById(R.id.button3);
        Button3.setOnClickListener(view -> openGame3());

        Button4 = (Button) findViewById(R.id.button4);
        Button4.setOnClickListener(view -> openGame4());

        Button5 = (Button) findViewById(R.id.button5);
        Button5.setOnClickListener(view -> openGame5());

        Button6 = (Button) findViewById(R.id.button6);
        Button6.setOnClickListener(view -> openGame6());

        Button7 = (Button) findViewById(R.id.button7);
        Button7.setOnClickListener(view -> openGame7());

        Button8 = (Button) findViewById(R.id.button8);
        Button8.setOnClickListener(view -> openGame8());

        Button9 = (Button) findViewById(R.id.button9);
        Button9.setOnClickListener(view -> openGame9());

        Button10 = (Button) findViewById(R.id.button10);
        Button10.setOnClickListener(view -> openGame10());
       // Button1.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
       //         openGame1();
      //      }
      //  });
    }

    public void openGame1() {
        Intent intent_game1 = new Intent(MainActivity.this, Game1.class);
        startActivity(intent_game1);
    }
    public void openGame2() {
        Intent intent_game2 = new Intent(MainActivity.this, Game2.class);
        startActivity(intent_game2);
    }
    public void openGame3() {
        Intent intent_game3 = new Intent(MainActivity.this, Game3.class);
        startActivity(intent_game3);
    }
    public void openGame4() {
        Intent intent_game4 = new Intent(MainActivity.this, Game4.class);
        startActivity(intent_game4);
    }
    public void openGame5() {
        Intent intent_game5 = new Intent(MainActivity.this, Game5.class);
        startActivity(intent_game5);
    }

    public void openGame6() {
        Intent intent_game6 = new Intent(MainActivity.this, Game6.class);
        startActivity(intent_game6);
    }

    public void openGame7() {
        Intent intent_game7 = new Intent(MainActivity.this, Game7.class);
        startActivity(intent_game7);
    }

    public void openGame8() {
        Intent intent_game8 = new Intent(MainActivity.this, Game8.class);
        startActivity(intent_game8);
    }

    public void openGame9() {
        Intent intent_game9 = new Intent(MainActivity.this, Game9.class);
        startActivity(intent_game9);
    }

    public void openGame10() {
        Intent intent_game10 = new Intent(MainActivity.this, Game10.class);
        startActivity(intent_game10);
    }
}