package com.stalbeats.lesson37;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements ITaskAdapterListener {
    Button button;
    MainAdapter adapter;
    Fragment fragment;
    Task task;


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            // Task receivedTask = (Task)bundle.getSerializable( "key");
            String received1 = bundle.getString("key");
            String received2 = bundle.getString("key1");
            String received3 = bundle.getString("key2");
            task = new Task(0, received1, received2, received3);
            adapter.addTask(task);
        }
        button = view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment();
            }
        });
        return view;
    }

    public void addTask(Task task) {
        adapter.addTask(task);
    }

    public void openFragment() {
        MainActivity activity = (MainActivity) getActivity();
        activity.fragmentSecond();
    }

    @Override
    public void openFragmentDetails(Task task) {
        MainActivity activity = (MainActivity) getActivity();
        activity.openFragmentDetails(task);
    }
}
