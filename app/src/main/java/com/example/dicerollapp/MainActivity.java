package com.example.dicerollapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView diceOne;
    private ImageView diceTwo;
    private Random random = new Random();
    int diceOneNum;
    int diceTwoNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diceOne = findViewById(R.id.dice1);
        diceTwo = findViewById(R.id.dice2);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceOneNum = random.nextInt(6) + 1;
                diceTwoNum = random.nextInt(6) + 1;
                rollDice(diceOne, diceOneNum);
                rollDice(diceTwo, diceTwoNum);
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("DiceOneValue", diceOneNum);
        Log.v("1", diceOneNum +"");
        Log.v("2", diceTwoNum +"");
        outState.putInt("DiceTwoValue", diceTwoNum);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        rollDice(diceOne, savedInstanceState.getInt("DiceOneValue"));
        rollDice(diceTwo, savedInstanceState.getInt("DiceTwoValue"));
    }

    private void rollDice(ImageView dice, int number){
        switch (number) {
            case 1:
                dice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                dice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                dice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dice.setImageResource(R.drawable.dice6);
                break;
        }
    }
}