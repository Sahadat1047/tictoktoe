package com.example.tictoktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    int []gameState={2,2,2,2,2,2,2,2,2};
    boolean gamerunning =true;

    public void dropIn(View view){

        ImageView counter=(ImageView) view;

        int TappedTracker= Integer.parseInt(counter.getTag().toString());
        Log.i("tag",counter.getTag().toString());


        if (gameState[TappedTracker]==2 && gamerunning) {
            counter.setTranslationX(-1500);
            gameState[TappedTracker]=activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationXBy(1500).setDuration(100);

            if ((((gameState[0] == gameState[1]) && (gameState[0] == gameState[2]))&&((gameState[0]!=2)&&(gameState[1]!=2)&&(gameState[2]!=2))) ||
                    ((gameState[0] == gameState[3]) && ((gameState[0] == gameState[6]))&&((gameState[0]!=2)&&(gameState[6]!=2)&&(gameState[6]!=2))) ||
                    (((gameState[0] == gameState[4]) && (gameState[0] == gameState[8]))&&((gameState[0]!=2)&&(gameState[4]!=2)&&(gameState[8]!=2))) ||
                    (((gameState[2] == gameState[4]) && (gameState[0] == gameState[6]))&&((gameState[2]!=2)&&(gameState[4]!=2)&&(gameState[6]!=2))) ||
                    (((gameState[3] == gameState[4]) && (gameState[4] == gameState[5]))&&((gameState[3]!=2)&&(gameState[4]!=2)&&(gameState[5]!=2)))||
                    (((gameState[6] == gameState[7]) && (gameState[7] == gameState[8]))&&((gameState[6]!=2)&&(gameState[7]!=2)&&(gameState[8]!=2))) ||
                    (((gameState[1] == gameState[4]) && (gameState[4] == gameState[7]))&&((gameState[1]!=2)&&(gameState[4]!=2)&&(gameState[7]!=2)))||
                    (((gameState[2] == gameState[5]) && (gameState[5] == gameState[8]))&&((gameState[2]!=2)&&(gameState[5]!=2)&&(gameState[8]!=2)))) {
                gamerunning=false;

                String winner ="";

                if (activePlayer == 1) {

                    winner= "Yellow Has Won";
                }
                if (activePlayer == 0) {

                    winner= "Red Has Won";
                }
                TextView messageView= (TextView)findViewById(R.id.messageView);
                Button buttonMessage=(Button)findViewById(R.id.buttonMessage);
                messageView.setText(winner);
                messageView.setVisibility(View.VISIBLE);
                buttonMessage.setVisibility(View.VISIBLE);

            }


        }

    }

    public void playAgain(View view){
        TextView messageView= (TextView)findViewById(R.id.messageView);
        Button buttonMessage=(Button)findViewById(R.id.buttonMessage);
        messageView.setVisibility(View.INVISIBLE);
        buttonMessage.setVisibility(View.INVISIBLE);
        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);


        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counters = (ImageView) gridLayout.getChildAt(i);
            counters.setImageDrawable(null);

        }

        activePlayer=0;
        Arrays.fill(gameState,2);
        gamerunning =true;
        Log.i("tag","working");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
