package com.congjustin.lab06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Shop extends AppCompatActivity {
    Button toSummon, b1, b2, b3, b4, b5, b6;
    TextView cDisplay;
    int money = 0;
    final int CRYSTAL_LIMIT = 9999;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        cDisplay = findViewById(R.id.numCrystals);
        toSummon = findViewById(R.id.toSummon);
        b1 = findViewById(R.id.shop1);
        b2 = findViewById(R.id.shop2);
        b3 = findViewById(R.id.shop3);
        b4 = findViewById(R.id.shop4);
        b5 = findViewById(R.id.shop5);
        b6 = findViewById(R.id.shop6);
        money = MainActivity.sharedPreferences.getInt("moneySpent", 0);
        updateCrystals();
        toSummon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shop.this, MainActivity.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.crystals + 1 > CRYSTAL_LIMIT)
                    Toast.makeText(getApplicationContext(), "You have hit the crystal limit. Please spend more crystals before you buy more.",Toast.LENGTH_LONG).show();
                else{
                    MainActivity.crystals += 1;
                    updateCrystals();
                    displaySpent(3);}
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.crystals + 3 > CRYSTAL_LIMIT)
                    Toast.makeText(getApplicationContext(), "You have hit the crystal limit. Please spend more crystals before you buy more.",Toast.LENGTH_LONG).show();
                else{
                    MainActivity.crystals += 3;
                    updateCrystals();
                    displaySpent(10);}
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.crystals + 7 > CRYSTAL_LIMIT)
                    Toast.makeText(getApplicationContext(), "You have hit the crystal limit. Please spend more crystals before you buy more.",Toast.LENGTH_LONG).show();
                else{
                    MainActivity.crystals += 7;
                    updateCrystals();
                    displaySpent(20);}
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.crystals + 15 > CRYSTAL_LIMIT)
                    Toast.makeText(getApplicationContext(), "You have hit the crystal limit. Please spend more crystals before you buy more.",Toast.LENGTH_LONG).show();
                else{
                    MainActivity.crystals += 15;
                    updateCrystals();
                    displaySpent(45);}
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.crystals + 25 > CRYSTAL_LIMIT)
                    Toast.makeText(getApplicationContext(), "You have hit the crystal limit. Please spend more crystals before you buy more.",Toast.LENGTH_LONG).show();
                else{
                    MainActivity.crystals += 25;
                    updateCrystals();
                    displaySpent(70);}
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.crystals + 40 > CRYSTAL_LIMIT)
                    Toast.makeText(getApplicationContext(), "You have hit the crystal limit. Please spend more crystals before you buy more.",Toast.LENGTH_LONG).show();
                else{
                    MainActivity.crystals += 40;
                    updateCrystals();
                    displaySpent(100);}
            }
        });
    }
    private void updateCrystals(){
        MainActivity.editor.putInt("numCrystals", MainActivity.crystals);
        MainActivity.editor.apply();
        cDisplay.setText(""+MainActivity.sharedPreferences.getInt("numCrystals", 0));
    }
    private void displaySpent(int purchase){
        money += purchase;
        MainActivity.editor.putInt("moneySpent", money);
        MainActivity.editor.apply();
        Toast.makeText(getApplicationContext(), "$"+purchase+" Purchase Confirmed. \n You have spent $" + money + " in total.",Toast.LENGTH_LONG).show();
    }
}
