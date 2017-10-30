package com.example.juanluis.puzzlegame;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class GeneratedGamePanel extends AppCompatActivity {
    private final int  rows = 3;
    private final int columns = 3;
    private final int xMultiplier = 100;
    private final int numbers = 1;
    private Button[][] buttons = new Button[columns][rows];
    private int[] colors= new int[]{Color.GREEN,Color.RED,Color.BLUE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated_game_panel);
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer buttonId = view.getId();
                Toast.makeText(getApplicationContext(), buttonId.toString(),Toast.LENGTH_LONG).show();
                int[] xy;
                xy = getXY(buttonId);
                resolveTurn(xy);
                boolean hasWin;
                hasWin = checkWinCondition();

            }
        };

        for(int i = 0; i < rows; i++){
            TableRow rowLayout = new TableRow(this);
            TableLayout.LayoutParams rowParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, 0,1);
            rowLayout.setId(i*10);
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);
            for(int j = 0; j < columns ; j++){
                int currentNumber = ((Double)(Math.random()*numbers)).intValue();
                TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT,1);

                Button button  = new Button(this);
                button.setBackgroundColor(colors[currentNumber]);

                button.setText(String.valueOf(currentNumber));
                button.setId(i*xMultiplier+j);
                button.setOnClickListener(listener);
                buttons[i][j] = button;
                rowLayout.addView(button,params);
            }
            tableLayout.addView(rowLayout,rowParams);
        }
    }

    private void resolveTurn(int[] xy){
        List<int[]> updatableCoords;
        int x,y;
        x=xy[0];
        y=xy[1];
        updatableCoords = new ArrayList<>();
        updatableCoords.add(xy);
        if(x != 0){
            updatableCoords.add(new int[]{x-1,y});
        }
        if(x != columns-1){
            updatableCoords.add(new int[]{x+1,y});
        }
        if(y != 0){
            updatableCoords.add(new int[]{x,y-1});
        }
        if(y != rows-1){
            updatableCoords.add(new int[]{x,y+1});
        }

        if(x == 0 && y ==0){
            updatableCoords.add(new int[]{x+1,y+1});
        }
        if(x == 0 && y == rows-1){
            updatableCoords.add(new int[]{x+1,y-1});
        }
        if(x == columns-1 && y == 0){
            updatableCoords.add(new int[]{x-1,y+1});
        }
        if(x == columns-1 && y == columns-1){
            updatableCoords.add(new int[]{x-1,y-1});
        }
        for(int[] coords: updatableCoords){
            int coordX,coordY;
            coordX = coords[0];
            coordY = coords[1];
            int number = Integer.parseInt(buttons[coordX][coordY].getText().toString());
            if(number++>= numbers){
                number=0;
            }
            buttons[coordX][coordY].setText(String.valueOf(number));
            buttons[coordX][coordY].setBackgroundColor(colors[number]);
        }
    }

    private boolean checkWinCondition(){
        int number = Integer.parseInt(buttons[0][0].getText().toString());
        for(int i = 0; i < columns; i++){
            for(int j = 0; j < rows; j++){
                int nextNumber =  Integer.parseInt(buttons[i][j].getText().toString());
                if(number != nextNumber){
                    return false;
                }
            }
        }
        return true;
    }
    private int[] getXY(Integer xy){
        int x;
        int y;
        x = xy / xMultiplier;
        y = xy % xMultiplier;
        return new int[]{x,y};
    }
}
