package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClassListAdapter extends RecyclerView.Adapter<ClassListAdapter.ViewHolder> {

    private final List<Class> mClassList;

    public interface MyRecyclerViewClickListener{
        void onItemClicked(int i);
        void onViewDetailButtonClicked(int i);
    }

    private MyRecyclerViewClickListener mListener;
    public void setOnClickListener(MyRecyclerViewClickListener listener){
        mListener = listener;
    }

    public ClassListAdapter(List<Class> classList){
        this.mClassList = classList;
    }

    @NonNull
    @Override
    public ClassListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.class_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassListAdapter.ViewHolder myViewHolder,final int i) {
        myViewHolder.classnameText.setText(mClassList.get(i).getClassname());

        if(mListener != null){
            final int pos = i;
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onViewDetailButtonClicked(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mClassList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView classnameText;
        Button more;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            classnameText = itemView.findViewById(R.id.title_text);
            more = itemView.findViewById(R.id.viewdetail_button);
        }
    }
}
