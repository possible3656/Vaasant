package com.winbee.vaasant.Ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.winbee.vaasant.R;

public class HomeworkDiscriptionFragment extends Fragment implements bottomDialogForAttachment.BottomSheetListener {

    TextView titleHomeworkDescription
            ,subjectHomeworkDescription
            ,dateHomeworkDescription
            ,attachmentTitleHomeworkDescription
            ,doneOrNotHomeworkDescription;

    Button buttonAttachmentHomeworkDescription;

    RelativeLayout attachmentLayoutHomeworkDescription;


    public HomeworkDiscriptionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_homework_discription, container, false);

        titleHomeworkDescription=view.findViewById(R.id.titleHomeworkDescription);
        subjectHomeworkDescription=view.findViewById(R.id.subjectHomeworkDescription);
        dateHomeworkDescription=view.findViewById(R.id.dateHomeworkDescription);
        attachmentTitleHomeworkDescription=view.findViewById(R.id.attachmentTitleHomeworkDescription);
        doneOrNotHomeworkDescription=view.findViewById(R.id.doneOrNotHomeworkDescription);
        buttonAttachmentHomeworkDescription=view.findViewById(R.id.buttonAttachmentHomeworkDescription);
        attachmentLayoutHomeworkDescription=view.findViewById(R.id.attachmentLayoutHomeworkDescription);


        getInfo();
        addAttachment();




        return view;
    }

    private void addAttachment() {

        buttonAttachmentHomeworkDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomDialogForAttachment bottomDialogForAttachment = new bottomDialogForAttachment();
                bottomDialogForAttachment.show(getFragmentManager(),"bottomDialogForAttachment");

            }
        });

    }

    private void getInfo() {
        Bundle bundle=getArguments();
        if (bundle != null) {
            String title = bundle.getString("title");
            String subject = bundle.getString("subject");
            String date = bundle.getString("date");
            String pdfUrl = bundle.getString("pdfUrl");


            titleHomeworkDescription.setText(title);
            subjectHomeworkDescription.setText(subject);
            dateHomeworkDescription.setText(date);
            attachmentTitleHomeworkDescription.setText(title);


            openThePdf(pdfUrl);

        }else{
            Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
        }




    }

    private void openThePdf(final String pdfUrl) {
        attachmentLayoutHomeworkDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo open pdf on web herTo
                Toast.makeText(getContext()," opening pdf", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse(pdfUrl); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPhotoAttachmentClicked() {
        //todo open intent for image picking
        Toast.makeText(getContext()," on photo clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPdfAttachmentClicked() {
        //todo open image for pdf picking
        Toast.makeText(getContext()," on pdf clicked", Toast.LENGTH_SHORT).show();
    }
}