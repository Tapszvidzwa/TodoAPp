package com.example.tapiwa.todoapp.personalProjects.personalProject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tapiwa.todoapp.R;

import java.util.ArrayList;


public class PersonalProjectAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<PersonalProjectTask> taskList;


    public PersonalProjectAdapter(Context context, int layout, ArrayList<PersonalProjectTask> taskList) {
        this.context = context;
        this.layout = layout;
        this.taskList = taskList;
    }

    @Override
    public int getCount() {
        if (taskList != null) {
            return taskList.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView task;
        ImageView completion_status;
    }

    @Override
    public View getView(int position, final View view, ViewGroup viewGroup) {

        final PersonalProjectTask task = taskList.get(position);

        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.task = row.findViewById(R.id.task_title_txtV);
            holder.completion_status = row.findViewById(R.id.completion_status);

            row.setTag(holder);

        } else {
            holder = (ViewHolder) row.getTag();
        }

        holder.task.setText(task.getTask());

        switch (task.getCompletionStatus()) {
            case "completed":
                holder.completion_status.setImageResource(R.drawable.ic_chck);
                break;
            case "uncompleted":
                holder.completion_status.setImageResource(R.drawable.ic_red_boxx);
                break;
            default:
                holder.completion_status.setImageResource(R.drawable.ic_red_boxx);
        }

        return row;
    }
}