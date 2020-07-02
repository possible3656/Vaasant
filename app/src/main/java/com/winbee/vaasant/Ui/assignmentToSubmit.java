package com.winbee.vaasant.Ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.winbee.vaasant.R;
import com.winbee.vaasant.Utils.AssignmentData;


public class assignmentToSubmit extends Fragment {

    private WebView webView;
    Button btm_asked_question;


    public assignmentToSubmit() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_assignment_to_submit, container, false);
        webView=view.findViewById(R.id.myWebView);
        btm_asked_question=view.findViewById(R.id.submitAssignmentButton);


        btm_asked_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return  view;
    }
}