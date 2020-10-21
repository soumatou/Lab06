package com.congjustin.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button single, multi,toShop, reset, characters, pity;
    TextView cDisplay;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    public static int crystals;
    Summons manager;
    public static String[] characterlist= new String[]{"Amber", "Barbara", "Beidou", "Bennett", "Chongyun", "Diluc", "Fischl","Garbage", "Jean", "Kaeya","Keqing", "Lisa", "Mona", "Ningguang", "Noelle", "Qiqi", "Razor", "Sucrose", "Venti", "Xiangling", "Xingqiu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.sharedPreferences = getSharedPreferences("idk", MODE_PRIVATE);
        MainActivity.editor=sharedPreferences.edit();
        manager = new Summons();
        pity = findViewById(R.id.pity);
        single = findViewById(R.id.singleSummon);
        multi = findViewById(R.id.multiSummon);
        cDisplay=findViewById(R.id.numCrystals);
        toShop = findViewById(R.id.toShop);
        reset = findViewById(R.id.reset);
        characters = findViewById(R.id.characters);
        for(int i = 0; i < characterlist.length; i ++){
            if(MainActivity.sharedPreferences.contains(characterlist[i]))
                MainActivity.crystals = MainActivity.sharedPreferences.getInt(characterlist[i], 0);
            else
                MainActivity.editor.putInt(characterlist[i], 0);
        }
        if(MainActivity.sharedPreferences.contains("numCrystals"))
            MainActivity.crystals = MainActivity.sharedPreferences.getInt("numCrystals", 10);
        else
            MainActivity.editor.putInt("numCrystals", 10);
        MainActivity.editor.apply();
        updateCrystals();
        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.crystals <= 0)
                    Toast.makeText(getApplicationContext(), "Not enough crystals; Please buy more.",Toast.LENGTH_LONG).show();
                else{
                    MainActivity.crystals--;
                    String[] temp = manager.drawSingle();
                    String t = "[";
                    for(int i = 0; i < temp.length; i ++){
                        t += temp[i];
                        MainActivity.editor.putInt(temp[i], MainActivity.sharedPreferences.getInt(temp[i], 0)+1);
                        editor.apply();
                        if(i!=temp.length - 1){
                            t += ", ";
                        }
                    }
                    t += "]";
                    Toast.makeText(getApplicationContext(), t,Toast.LENGTH_LONG).show();
                    updateCrystals();}
                }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.crystals<=9)
                    Toast.makeText(getApplicationContext(), "Not enough crystals; Please buy more.",Toast.LENGTH_LONG).show();
                else{
                    MainActivity.crystals-= 10;
                    String[] temp = manager.drawMulti();
                    String t = "[";
                    for(int i = 0; i < temp.length; i ++){
                        t += temp[i];
                        MainActivity.editor.putInt(temp[i], MainActivity.sharedPreferences.getInt(temp[i], 0) + 1);
                        editor.apply();
                        if(i!=temp.length - 1){
                            t += ", ";
                        }
                    }
                    t += "]";
                    Toast.makeText(getApplicationContext(), t,Toast.LENGTH_LONG).show();
                    updateCrystals();}
                }
        });
        toShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Shop.class);
                startActivity(intent);
            }
        });
        pity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pity_Warning.class);
                startActivity(intent);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.apply();
                Toast.makeText(getApplicationContext(), "Crystals, Characters, and Pity have been reset.",Toast.LENGTH_LONG).show();
                manager.setPityCount4(0);
                manager.setPityCount5(0);
                manager.setPityCountf4(0);
                manager.setPityCountf5(0);
                MainActivity.crystals = 0;
                updateCrystals();
            }
        });
        characters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CharacterScreen.class);
                startActivity(intent);
            }
        });
    }
    private void updateCrystals(){
        MainActivity.editor.putInt("numCrystals", MainActivity.crystals);
        MainActivity.editor.apply();
        cDisplay.setText(""+MainActivity.sharedPreferences.getInt("numCrystals", 0));
    }

}
