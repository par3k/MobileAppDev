package com.example.login;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


public class ClassFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerView;
    private List<Class> classList;
    private RecyclerView.Adapter adapter;

    public ClassFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_class, container, false);
        myrecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        myrecyclerView.setHasFixedSize(true);
        adapter = new ClassListAdapter(getContext(),classList);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(adapter);
        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        classList = new ArrayList<>();
        classList.add(new Class("JAVA", R.drawable.avatar_cho));
        classList.add(new Class("C", R.drawable.avatar_seo));
        classList.add(new Class("Discrete Math", R.drawable.avatar_kim));
        classList.add(new Class("Data Base", R.drawable.avatar_kim3));
        classList.add(new Class("OS", R.drawable.avatar_shin));
        classList.add(new Class("Android", R.drawable.avatar_song));
        classList.add(new Class("NoSQL", R.drawable.avatar_kang));
        classList.add(new Class("UI", R.drawable.avatar_choi));
        classList.add(new Class("C++", R.drawable.avatar_kim2));
        classList.add(new Class("A.I", R.drawable.avatar_yu));
        classList.add(new Class("Algorithm", R.drawable.avatar_park));
        classList.add(new Class("Data Structure", R.drawable.avatar_jeong));

    }
}

