package com.shady.gplanettask;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    ArrayList<String> items;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment getInstance(int n) {
        MainFragment mainFragment = new MainFragment();

        mainFragment.items = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            mainFragment.items.add("Item " + i);
        }

        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.content_main, container, false);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(items);
        recyclerView.setAdapter(recyclerAdapter);
    }

}
