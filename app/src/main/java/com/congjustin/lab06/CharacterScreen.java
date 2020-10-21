package com.congjustin.lab06;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CharacterScreen extends AppCompatActivity {
    Button back, toShop;
    TextView c;
    String[] fiveStars = new String[]{"Diluc", "Jean", "Keqing", "Mona", "Qiqi", "Venti"};
    String[] fourStars = new String[]{"Amber", "Barbara", "Beidou", "Bennett", "Chongyun", "Fischl", "Kaeya", "Lisa", "Ningguang", "Noelle", "Razor", "Sucrose", "Xiangling", "Xingqiu"};
    String[] threeStars = new String[]{"Garbage"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characterscreen);
        toShop = findViewById(R.id.toShop);
        c = findViewById(R.id.list);
        back = findViewById(R.id.back);
        String fivet = "Five Stars";
        String fives = "\n";
        for(int i = 0; i < fiveStars.length; i ++){
            if(MainActivity.sharedPreferences.getInt(fiveStars[i], 0) != 0){
                fives += fiveStars[i] + ": " + MainActivity.sharedPreferences.getInt(fiveStars[i],0) + "\n";
            }
        }
        String fourt = "Four Stars";
        String fours = "\n";
        for(int i = 0; i < fourStars.length; i ++){
            if(MainActivity.sharedPreferences.getInt(fourStars[i], 0) != 0){
                fours += fourStars[i] + ": " + MainActivity.sharedPreferences.getInt(fourStars[i],0) + "\n";
            }
        }
        String threet = "Three Stars";
        String threes = "\n";
        for(int i = 0; i < threeStars.length; i ++){
            if(MainActivity.sharedPreferences.getInt(threeStars[i], 0) != 0){
                threes += threeStars[i] + ": " + MainActivity.sharedPreferences.getInt(threeStars[i],0) + "\n";
            }
        }
        SpannableString fiveTitle=  new SpannableString(fivet + fives + fourt + fours + threet + threes);
        fiveTitle.setSpan(new AbsoluteSizeSpan(100), 0,fivet.length(), 0);
        fiveTitle.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.navyBlue)), 0, fivet.length(), 0);
        fiveTitle.setSpan(new AbsoluteSizeSpan(50), fivet.length(),fives.length() + fivet.length(), 0);
        fiveTitle.setSpan(new AbsoluteSizeSpan(100), fives.length() + fivet.length(),fourt.length() + fives.length() + fivet.length(), 0);
        fiveTitle.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.navyBlue)), fives.length() + fivet.length(), fourt.length() + fives.length() + fivet.length(), 0);
        fiveTitle.setSpan(new AbsoluteSizeSpan(50), fourt.length() + fives.length() + fivet.length(),fourt.length() + fives.length() + fivet.length()+fours.length(), 0);
        fiveTitle.setSpan(new AbsoluteSizeSpan(100), fourt.length() + fives.length() + fivet.length()+fours.length(),fourt.length() + fives.length() + fivet.length()+fours.length()+threet.length(), 0);
        fiveTitle.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.navyBlue)), fourt.length() + fives.length() + fivet.length()+fours.length(), fourt.length() + fives.length() + fivet.length()+fours.length()+threet.length(), 0);
        fiveTitle.setSpan(new AbsoluteSizeSpan(50), fourt.length() + fives.length() + fivet.length()+fours.length()+threet.length(),fourt.length() + fives.length() + fivet.length()+fours.length()+threet.length()+threes.length(), 0);
        System.out.print(fivet + fives + fourt + fours + threet + threes);
        c.setText(fiveTitle);

        toShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toShop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(CharacterScreen.this, Shop.class);
                        startActivity(intent);
                    }
                });
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(CharacterScreen.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
