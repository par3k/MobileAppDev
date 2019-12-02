package com.example.login;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

public class RankListAdapter extends BaseAdapter {

    private Context context;
    private List<Course> courseList;
    private Fragment parent;

    public RankListAdapter(Context context, List<Course> courseList, Fragment parent) {
        this.context = context;
        this.courseList = courseList;
        this.parent = parent;
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int i) {
        return courseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.rank, null);
        TextView rankTextView = (TextView) v.findViewById(R.id.rankTextView);
        LinearLayout rankLinearLayout = (LinearLayout) v.findViewById(R.id.rankLinearLayout);
        TextView courseTitle = (TextView) v.findViewById(R.id.courseTitle);
        TextView courseCredit = (TextView) v.findViewById(R.id.courseCredit);
        TextView coursePersonnel = (TextView) v.findViewById(R.id.coursePersonnel);
        TextView courseProfessor = (TextView) v.findViewById(R.id.courseProfessor);
        TextView courseTime = (TextView) v.findViewById(R.id.courseTime);

        rankTextView.setText(" "+(i+1)+" ");
        if(i != 0){
            rankTextView.setBackgroundColor(parent.getResources().getColor(R.color.colorPrimary));
            rankLinearLayout.setBackgroundColor(parent.getResources().getColor(R.color.colorPrimary));
        }

        courseTitle.setText(courseList.get(i).getCourseTitle());
        courseCredit.setText("<"+courseList.get(i).getCourseCredit()+" credits>");
        if(courseList.get(i).getCoursePersonnel()==0){
            coursePersonnel.setText("Unlimited");
        } else {
            coursePersonnel.setText("Capacity : " + courseList.get(i).getCoursePersonnel());
        }
        courseProfessor.setText("Dr. "+courseList.get(i).getCourseProfessor());
        courseTime.setText(courseList.get(i).getCourseTime()+"");
        v.setTag(courseList.get(i).getCourseID());
        return v;
    }
}
