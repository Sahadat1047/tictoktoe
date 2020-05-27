package com.example.tictoktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    public void dropIn(View view){

        ImageView counter=(ImageView) view;
        counter.setTranslationX(-1500);

        if(activePlayer==0) {
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;
        }
        else {
            counter.setImageResource(R.drawable.red);
            activePlayer=0;
        }
        counter.animate().translationXBy(1500).setDuration(100);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
