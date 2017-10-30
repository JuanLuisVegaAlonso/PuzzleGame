package com.example.juanluis.puzzlegame;

import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.*;

public class GamePanel extends AppCompatActivity {
    List<Integer> availableColors;
    Integer currentColor;
    Integer maxColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_panel);
        this.availableColors = new ArrayList<>();
        this.availableColors.add(Color.BLACK);
        this.availableColors.add(Color.BLUE);
        this.availableColors.add(Color.DKGRAY);
        this.currentColor = 0;
        this.maxColor = this.availableColors.size();
    }

}
