package com.example.login;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ClassFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Class> classList = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ClassFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_class, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new ClassListAdapter(classList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        prepareDate();
    }

    private void prepareDate(){
        classList.add(new Class("JAVA"));
        classList.add(new Class("C"));
        classList.add(new Class("Discrete Math"));
        classList.add(new Class("OS"));
        classList.add(new Class("Android"));
        classList.add(new Class("NoSQL"));
        classList.add(new Class("UI"));
        classList.add(new Class("C++"));
        classList.add(new Class("A.I"));
        classList.add(new Class("Algorithm"));
        classList.add(new Class("Data Structure"));
    }



}
