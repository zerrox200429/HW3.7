package com.stalbeats.lesson37;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentThird extends Fragment {
    TextView name, surname, year;


    public FragmentThird() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_third, container, false);
        name = view.findViewById(R.id.new_name);
        surname = view.findViewById(R.id.new_surname);
        year = view.findViewById(R.id.new_age);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String received1 = bundle.getString("key3");
            String received2 = bundle.getString("key4");
            String received3 = bundle.getString("key5");
            name.setText(received1);
            surname.setText(received2);
            year.setText(received3);
        }
        return view;
    }
}