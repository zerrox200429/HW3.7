package com.stalbeats.lesson37;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    ArrayList<Task> tasks;
    ITaskAdapterListener listener;

    public MainAdapter() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.main_view_holder, parent, false);
        MainViewHolder vh = new MainViewHolder(view);
        vh.listener = listener;
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void find(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (id == tasks.get(i).id) {
                listener.openFragmentDetails(tasks.get(id));
            }
        }
    }

}