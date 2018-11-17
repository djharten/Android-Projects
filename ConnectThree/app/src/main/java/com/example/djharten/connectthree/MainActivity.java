package com.example.djharten.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean redPlayerTurn = false;

    // Game State: 0 represents yellow player, 1 represents red player, 2 = empty space.
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    // All possible winning positions on a 3x3 board.
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        counter.getTag();
        counter.setTranslationY(-1500);

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(redPlayerTurn){
            counter.setImageResource(R.drawable.red);
            gameState[tappedCounter] = 1;
            redPlayerTurn = false;
        } else {
            counter.setImageResource(R.drawable.yellow);
            gameState[tappedCounter] = 0;
            redPlayerTurn = true;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(500);

        for(int[] winningPos : winningPositions){
            if(gameState[winningPos[0]] == gameState[winningPos[1]] && gameState[winningPos[0]] ==  gameState[winningPos[2]]){
                if(gameState[winningPos[0]] == 0){
                    Toast.makeText(this, "Yellow has won!", Toast.LENGTH_LONG).show();
                } else if(gameState[winningPos[0]] == 1){
                    Toast.makeText(this, "Red has won!", Toast.LENGTH_LONG).show();
                } else {
                    continue;
                }
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
