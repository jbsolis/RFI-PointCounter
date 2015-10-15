package com.solistenapps.rfipointcounter;

import android.support.v4.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class LogoFragment extends Fragment {

    private TextView firstTo, forty, wins;
    private Button reset;
    private ImageView logo;

    ResetButtonListener activityCommander;

    public interface ResetButtonListener{

        public void resetCounters(int zero);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            activityCommander = (ResetButtonListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.logo_area, container, false);

        firstTo = (TextView) view.findViewById(R.id.firsttoTV);
        forty = (TextView) view.findViewById(R.id.fortyTV);
        wins = (TextView) view.findViewById(R.id.winsTV);

        Typeface font = Typeface.createFromAsset(firstTo.getContext().getAssets(), "BOOKOS.TTF");

        firstTo.setTypeface(font);
        forty.setTypeface(font);
        wins.setTypeface(font);

        reset = (Button) view.findViewById(R.id.resetBtn);

        reset.setOnClickListener(resetClicked);

        return view;

    }

    private View.OnClickListener resetClicked = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            activityCommander.resetCounters(0);
        }
    };

}
