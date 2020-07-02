package com.winbee.vaasant.Ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winbee.vaasant.Adapter.HomeworkAdapter;
import com.winbee.vaasant.Models.AssignmentDatum;
import com.winbee.vaasant.R;

import java.util.ArrayList;


public class SubmitedAssignment extends Fragment {


    RecyclerView recyclerView;
    Button assignmentButton;

    private HomeworkAdapter homeworkAdapter;
    private ArrayList<AssignmentDatum> list;


    public SubmitedAssignment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_submited_assignment, container, false);

        recyclerView = view.findViewById(R.id.review);
        assignmentButton = view.findViewById(R.id.AssignmentButton);


        return view;
    }
}