package com.example.djharten.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Active Player: 0 = yellow, 1 = red
    int activePlayer  = 0;

    // Game State: 0 represents yellow player, 1 represents red player, 2 = empty space.
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    // All possible winning positions on a 3x3 board.
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    boolean gameActive = true;

    // Drops each piece into the game board.
    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        counter.getTag();
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        counter.setTranslationY(-1500);
        takeTurn(counter, tappedCounter);
        counter.animate().translationYBy(1500).rotation(3600).setDuration(500);
        checkForWinner();
    }

    public void takeTurn(ImageView counter, int tappedCounter) {
        if (gameState[tappedCounter] == 2 && gameActive) {
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
        }
    }

    // Checks if the game has been won by a player. If so, displays the winner and ends the game.
    public void checkForWinner(){
        for (int[] winningPos : winningPositions)
            if (gameState[winningPos[0]] == gameState[winningPos[1]] && gameState[winningPos[0]] == gameState[winningPos[2]] && gameState[winningPos[0]] != 2) {
                gameActive = false;
                String winner;
                if (gameState[winningPos[0]] == 0) {
                    winner = "Yellow";
                } else {
                    winner = "Red";
                }
                Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                winnerTextView.setText(winner + " has won!");
                playAgainButton.setVisibility(View.VISIBLE);
                winnerTextView.setVisibility(View.VISIBLE);
            }
    }

    // Resets the board, makes buttons invisible and restarts the game.
    public void playAgain(View view) {
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        android.support.v7.widget.GridLayout gridLayout = (android.support.v7.widget.GridLayout) findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
            gameState[i] = 2;
        }
        activePlayer = 0;
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
