package com.example.djharten.learningsection4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //boolean displayedBart = true;

    public void fade(View view){
        Log.i("Info", "ImageView tapped");

        // Fades out bart and fades in homer of vice versa.
        /*
        ImageView bart_imageView = (ImageView) findViewById(R.id.bart_imageView3);
        ImageView homer_imageView = (ImageView) findViewById(R.id.homer_imageView3);
        if(displayedBart) {
            bart_imageView.animate().alpha(0).setDuration(3000);
            homer_imageView.animate().alpha(1).setDuration(3000);
            displayedBart = false;
        } else {
            homer_imageView.animate().alpha(0).setDuration(3000);
            bart_imageView.animate().alpha(1).setDuration(3000);
            displayedBart = true;
        }
        */

        // Moves the image along the Y-Axis by N DPI for a set duration. Can do X-Axis as well.
        /*
        ImageView bart_imageView = (ImageView) findViewById(R.id.bart_imageView3);
        bart_imageView.animate().translationYBy(1000).setDuration(3000);
        */

        // Rotates image N degrees for a set duration.
        /*
        ImageView bart_imageView = (ImageView) findViewById(R.id.bart_imageView3);
        bart_imageView.animate().rotation(180).setDuration(3000);
        */

        // Changes the size of the image via scaling for a set duration. scale looks for a float
        // and a standard decimal value(e.g. 0.5) is a double, must implicitly change to float with
        // f at end.
        ImageView bart_imageView = (ImageView) findViewById(R.id.bart_imageView3);
        bart_imageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
