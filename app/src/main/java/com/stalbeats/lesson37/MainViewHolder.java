package com.stalbeats.lesson37;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {
    TextView view;
    Task task;
    ITaskAdapterListener listener;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.text_view);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.openFragmentDetails(task);
            }
        });
    }

    public void onBind(Task task) {
        view.setText(task.name);
        view.setText(task.surname);
        this.task = task;

    }
}
