package com.stalbeats.lesson37;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSecond extends Fragment {
    EditText name, surname, year;
    Button save;
    Task task;
    String name1, surname1, year1;

    public FragmentSecond() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_second, container, false);
        name = view.findViewById(R.id.name);
        surname = view.findViewById(R.id.surname);
        year = view.findViewById(R.id.age);
        save = view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                name1 = name.getText().toString();
                surname1 = surname.getText().toString();
                year1 = year.getText().toString();
                bundle.putString("key", name1);
                bundle.putString("key1", surname1);
                bundle.putString("key2", year1);
                FirstFragment fragment1 = new FirstFragment();
                fragment1.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment1).commit();
                Bundle bundle1 = new Bundle();
                bundle.putString("key3", name1);
                bundle.putString("key4", surname1);
                bundle.putString("key5", year1);
                FragmentThird fragment3 = new FragmentThird();
                fragment3.setArguments(bundle1);
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(R.id.container, fragment3).commit();

            }
        });
        return view;
    }

    public void save() {
        name.setText(task.name);
        surname.setText(task.surname);
        year.setText(task.year);

    }

}
