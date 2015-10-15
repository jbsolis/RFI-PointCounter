package com.solistenapps.rfipointcounter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CounterFragment extends Fragment{

    int playerScore = 0;

    private TextView playerPoints;

    private Button neg2;
    private Button neg5;
    private Button neg10;
    private Button neg15;

    private Button pos2;
    private Button pos5;
    private Button pos10;
    private Button pos15;

    private RelativeLayout counterLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.counter_layout, container, false);

        playerPoints = (TextView) view.findViewById(R.id.playerpointsTV);

        neg2 = (Button) view.findViewById(R.id.btmneg2Btn);
        neg5 = (Button) view.findViewById(R.id.btmneg5Btn);
        neg10 = (Button) view.findViewById(R.id.btmneg10Btn);
        neg15 = (Button) view.findViewById(R.id.btmneg15Btn);

        pos2 = (Button) view.findViewById(R.id.btmpos2Btn);
        pos5 = (Button) view.findViewById(R.id.btmpos5Btn);
        pos10 = (Button) view.findViewById(R.id.btmpos10Btn);
        pos15 = (Button) view.findViewById(R.id.btmpos15Btn);

        counterLayout = (RelativeLayout) view.findViewById(R.id.counterRL);

        Typeface font = Typeface.createFromAsset(neg2.getContext().getAssets(), "BOOKOS.TTF");

        neg2.setTypeface(font);
        neg5.setTypeface(font);
        neg10.setTypeface(font);
        neg15.setTypeface(font);

        pos2.setTypeface(font);
        pos5.setTypeface(font);
        pos10.setTypeface(font);
        pos15.setTypeface(font);
        playerPoints.setTypeface(font);

        neg2.setOnClickListener(adjustScore);
        neg5.setOnClickListener(adjustScore);
        neg10.setOnClickListener(adjustScore);
        neg15.setOnClickListener(adjustScore);

        pos2.setOnClickListener(adjustScore);
        pos5.setOnClickListener(adjustScore);
        pos10.setOnClickListener(adjustScore);
        pos15.setOnClickListener(adjustScore);

        return view;

    }

    private View.OnClickListener adjustScore = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btmneg2Btn:
                    playerScore = playerScore - 2;
                    break;
                case R.id.btmneg5Btn:
                    playerScore = playerScore - 5;
                    break;
                case R.id.btmneg10Btn:
                    playerScore = playerScore - 10;
                    break;
                case R.id.btmneg15Btn:
                    playerScore = playerScore - 15;
                    break;
                case R.id.btmpos2Btn:
                    playerScore = playerScore + 2;
                    break;
                case R.id.btmpos5Btn:
                    playerScore = playerScore + 5;
                    break;
                case R.id.btmpos10Btn:
                    playerScore = playerScore + 10;
                    break;
                case R.id.btmpos15Btn:
                    playerScore = playerScore + 15;
                    break;
            }
            playerPoints.setText(String.format("%02d", playerScore));

            if(playerScore >= 40){
                playerPoints.setText("Winner!");

            }

        }
    };

    // Called on MainActivity to set different colors on each fragment
    public void setPlayerColor(String color){
        counterLayout.setBackgroundColor(Color.parseColor(color));

    }

    public void resetPlayerCounter(int number){
        playerScore = number;
        playerPoints.setText(String.format("%02d", playerScore));
    }


}
