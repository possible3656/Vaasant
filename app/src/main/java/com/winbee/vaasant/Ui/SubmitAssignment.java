package com.winbee.vaasant.Ui;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.winbee.vaasant.R;


public class SubmitAssignment extends Fragment {
    private EditText description;
    private Button uploadButton,addImageButton;
    
    public SubmitAssignment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_submit_assignment, container, false);
        description = view.findViewById(R.id.description);
        addImageButton = view.findViewById(R.id.addImageButton);
        uploadButton = view.findViewById(R.id.uploadButton);

        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                fileValidation();
            }
        });
        
        return view;
    }

    private void fileValidation() {

    }

    private void selectImage() {
        
    }
}