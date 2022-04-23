package com.kecewka.mid_todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TaskModel> tasksArrayList;


    public TaskAdapter(Context context, ArrayList<TaskModel> tasksArrayList) {
        this.context = context;
        this.tasksArrayList = tasksArrayList;
    }


    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        TaskModel model = tasksArrayList.get(position);
        holder.task.setText(model.getTask_name());
    }

    @Override
    public int getItemCount() {
        return tasksArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView task;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            task = itemView.findViewById(R.id.task);
            ImageView dlt = itemView.findViewById(R.id.delete_btn);
            dlt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    tasksArrayList.remove(pos);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
