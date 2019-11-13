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
