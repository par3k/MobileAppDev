package com.example.login;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class StatisticsCourseListAdapter extends BaseAdapter {

    private Context context;
    private List<Course> courseList;
    private Fragment parent;
    private String userID = MainActivity.userID;

    public StatisticsCourseListAdapter(Context context, List<Course> courseList, Fragment parent) {
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
        View v = View.inflate(context, R.layout.statistics, null);
        TextView courseTitle = (TextView) v.findViewById(R.id.courseTitle);
        TextView courseCredit = (TextView) v.findViewById(R.id.courseCredit);
        TextView coursePersonnel = (TextView) v.findViewById(R.id.coursePersonnel);
        TextView courseRate = (TextView) v.findViewById(R.id.courseRate);

        courseTitle.setText(courseList.get(i).getCourseTitle());
        courseCredit.setText("<"+courseList.get(i).getCourseCredit()+" credits>");
        if(courseList.get(i).getCoursePersonnel()==0){
            coursePersonnel.setText("Unlimited");
            courseRate.setText("");
        } else {
            coursePersonnel.setText("Available : " + courseList.get(i).getCourseRival() + " / " + courseList.get(i).getCoursePersonnel());
            int rate = ((int) (((double) courseList.get(i).getCourseRival() * 100 / courseList.get(i).getCoursePersonnel()) + 0.5));
            courseRate.setText("Competition Rate : " + rate + "%");
            if (rate < 20) {
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorSafe));
            } else if (rate <= 50) {
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorPrimary));
            } else if (rate <= 100) {
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorDanger));
            } else if (rate <= 150) {
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorWarning2));
            } else {
                courseRate.setTextColor(parent.getResources().getColor(R.color.colorRed));
            }
        }
        v.setTag(courseList.get(i).getCourseID());
        return v;
    }
}
