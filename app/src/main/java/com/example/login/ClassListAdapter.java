package com.example.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClassListAdapter extends RecyclerView.Adapter<ClassListAdapter.ViewHolder> {
    Context mContext;
    List<Class> mClassList;

    public ClassListAdapter(Context mContext,List<Class> classList){
        this.mContext = mContext;
        this.mClassList = classList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(mContext)
                .inflate(R.layout.class_list, viewGroup, false);
        final ViewHolder vHolder = new ViewHolder(view);

        vHolder.detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(String.valueOf(vHolder.getAdapterPosition())!=null) {
                    if(vHolder.getAdapterPosition()==0) {
                        Intent intent2 = new Intent(view.getContext(), Pop_java.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==1){
                        Intent intent2 = new Intent(view.getContext(), Pop_c.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==2){
                        Intent intent2 = new Intent(view.getContext(), Pop_discrete_mathmatics.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==3){
                        Intent intent2 = new Intent(view.getContext(), Pop_db.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==4){
                        Intent intent2 = new Intent(view.getContext(), Pop_os.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==5){
                        Intent intent2 = new Intent(view.getContext(), Pop_android.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==6){
                        Intent intent2 = new Intent(view.getContext(), Pop_nosql.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==7){
                        Intent intent2 = new Intent(view.getContext(), Pop_ui.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==8){
                        Intent intent2 = new Intent(view.getContext(), Pop_cpp.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==9){
                        Intent intent2 = new Intent(view.getContext(), Pop_ai.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else if(vHolder.getAdapterPosition()==10){
                        Intent intent2 = new Intent(view.getContext(), Pop_algo.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    } else {
                        Intent intent2 = new Intent(view.getContext(), Pop_ds.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }
                }
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassListAdapter.ViewHolder myViewHolder,final int i) {
        myViewHolder.classnameText.setText(mClassList.get(i).getClassname());
        myViewHolder.img.setImageResource(mClassList.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mClassList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView classnameText;
        Button detailButton;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            classnameText = (TextView) itemView.findViewById(R.id.title_text);
            detailButton = (Button) itemView.findViewById(R.id.detailButton);
            img = (ImageView) itemView.findViewById(R.id.class_img);
        }
    }
}

