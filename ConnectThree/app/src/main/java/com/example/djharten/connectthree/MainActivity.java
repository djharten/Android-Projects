package com.example.djharten.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean redPlayerTurn = false;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2,};

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        counter.getTag();
        counter.setTranslationY(-1500);

        if(redPlayerTurn){
            counter.setImageResource(R.drawable.red);
            redPlayerTurn = false;
        } else {
            counter.setImageResource(R.drawable.yellow);
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(500);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
