package com.example.juanluis.puzzlegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnHelloWorld(View view){
        TextView editText = findViewById(R.id.textView);
        editText.append("Lo he modificado perra");


        Intent intent = new Intent(this, GamePanel.class);
        startActivity(intent);
    }

    public void btnGeneratedGamePanel(View view){
        Intent intent = new Intent(this, GeneratedGamePanel.class);
        startActivity(intent);
    }
}
