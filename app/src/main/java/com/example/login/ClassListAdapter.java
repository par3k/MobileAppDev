package com.example.login;

import android.content.Context;
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
                Toast.makeText(mContext,"Test Click"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
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

