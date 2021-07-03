package com.example.fragmentcolorchange;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class ChooseWeeks extends Fragment {

    Spinner show_weeks;
    LinearLayout weekFragmentLayout;

    String[] weekDays = {"", "SunDay", "MonDay", "TuesDay", "WednesDay", "ThursDay", "FriDay", "SaturDay"};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        show_weeks = getActivity().findViewById(R.id.show_weeks);
        show_weeks.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, weekDays));

        show_weeks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                weekFragmentLayout = getActivity().findViewById(R.id.weekFragmentLayout);
                // System.out.println(selectWeek.getClass().getName());
                if(weekDays[position].toLowerCase().equals("sunday") || weekDays[position].toLowerCase().equals("saturday")){
                    weekFragmentLayout.setBackgroundColor(Color.RED);
                    Toast.makeText(getActivity(), "Today is holiday", Toast.LENGTH_LONG).show();
                }
                else if(weekDays[position].toLowerCase().equals("")){
                    weekFragmentLayout.setBackgroundColor(Color.TRANSPARENT);
                }
                else{
                    weekFragmentLayout.setBackgroundColor(Color.GREEN);
                    Toast.makeText(getActivity(), "Working Day!!!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_weeks, container, false);
    }
}