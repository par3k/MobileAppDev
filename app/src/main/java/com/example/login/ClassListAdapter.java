package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClassListAdapter extends RecyclerView.Adapter<ClassListAdapter.MyViewHolder> {

    private List<Class> classList;

    public ClassListAdapter(List<Class> classList){
        this.classList = classList;
    }

    @NonNull
    @Override
    public ClassListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.class_list, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassListAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.classnameText.setText(classList.get(i).getClassname());
        myViewHolder.teacherText.setText(String.valueOf(classList.get(i).getTeacher()));

    }

    @Override
    public int getItemCount() {
        return classList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{


        public final TextView classnameText, teacherText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            classnameText = itemView.findViewById(R.id.text_cname);
            teacherText = itemView.findViewById(R.id.text_teacher);

        }
    }
}
