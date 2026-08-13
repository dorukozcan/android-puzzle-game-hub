package com.example.project3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Game2 extends AppCompatActivity {

    public enum Selection {
        ROCK, PAPER, SCISSOR
    }
    //default value assigned to all constant
    private static Selection user_selection = Selection.SCISSOR;
    private static Selection cpu_selection = Selection.ROCK;

    private static boolean user_winner = true;
    private static boolean match_draw = false;

    public Button button_rock;
    public Button button_paper;
    public Button button_scissor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        button_rock = findViewById(R.id.button_rock);
        button_paper = findViewById(R.id.button_paper);
        button_scissor = findViewById(R.id.button_scissor);

        button_rock.setOnClickListener(this::onClick);
        button_paper.setOnClickListener(this::onClick);
        button_scissor.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        switch (view.getId()){

            case R.id.button_rock:
                user_selection = Selection.ROCK;
                break;

            case R.id.button_paper:
                user_selection = Selection.PAPER;
                break;

            case R.id.button_scissor:
                user_selection = Selection.SCISSOR;
                break;
        }

        proceed();
    }

    private void proceed() {
        //get random cpu selection
        cpu_selection = getRandomCPUSelection();
        //get winner based on cpu_selection and user_selection
        checkWinner();
        //print result based on result
        showWinner();
    }
    //function return random value
    private Selection getRandomCPUSelection() {
        int random = new Random().nextInt(3);

        switch (random){
            case 0: return Selection.ROCK;
            case 1: return Selection.PAPER;
            case 2: return Selection.SCISSOR;
        }
        return Selection.ROCK;
    }

    private void checkWinner() {

        if(user_selection == cpu_selection){
            match_draw = true;
            return;
        }

        //rock wins from scissor, loose from paper
        if(user_selection == Selection.ROCK){
            if(cpu_selection == Selection.PAPER){
                user_winner = false;
                return;
            }
            else if(cpu_selection == Selection.SCISSOR){
                user_winner = true;
                return;
            }
        }

        //paper wins from rock, loose from scissor
        if(user_selection == Selection.PAPER){
            if(cpu_selection == Selection.SCISSOR){
                user_winner = false;
                return;
            }
            else if(cpu_selection == Selection.ROCK){
                user_winner = true;
                return;
            }
        }

        //scissor wins from paper, loose from rock
        if(user_selection == Selection.SCISSOR){
            if(cpu_selection == Selection.ROCK){
                user_winner = false;
                return;
            }
            else if(cpu_selection == Selection.PAPER){
                user_winner = true;
                return;
            }
        }

        Log.e("cpu selected",cpu_selection.toString());
        Log.e("user selected",user_selection.toString());
    }

    //show dialog to show result
    private void showWinner() {

        String line1 = "USER selection : "+user_selection;
        String line2 = "CPU selection : "+cpu_selection;
        String result = getResultString();

        String message = line1 + "\n" + line2 + "\nResult: " + result;

        new AlertDialog.Builder(Game2.this)
                .setTitle("Result")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // close dialog
                        dialog.dismiss();
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        //reset values when dialog is dismissed
                        resetValues();
                    }
                })
                .show();
    }
    //return result string
    private String getResultString() {

        String result;
        if(match_draw == true){
            result = "Match draw! Let's go again";
        }
        else{
            if(user_winner)
                result = "You win!";
            else
                result = "You loose!!!";
        }

        return result;
    }
    //reset values after the result is displayed to user
    private void resetValues() {
        user_selection = Selection.SCISSOR;
        cpu_selection = Selection.ROCK;

        user_winner = true;
        match_draw = false;
        Log.e(MainActivity.class.getName(), "values reset successful");
    }
}

