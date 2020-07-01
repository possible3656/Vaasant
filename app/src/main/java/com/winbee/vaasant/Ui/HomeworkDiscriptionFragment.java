package com.winbee.vaasant.Ui;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.winbee.vaasant.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;

public class HomeworkDiscriptionFragment extends Fragment  {

    TextView titleHomeworkDescription,subjectHomeworkDescription,dateHomeworkDescription,attachmentTitleHomeworkDescription,doneOrNotHomeworkDescription;
    Button buttonAttachmentHomeworkDescription;
    RelativeLayout attachmentLayoutHomeworkDescription;
    private  static final int IMG_REQUEST=777;
    public static Bitmap bitmap;


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
                /// Add activity to open pdf  url
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }


    public void onPhotoAttachmentClicked() {
        //todo open intent for image picking
        // Toast.makeText(getContext()," on photo clicked", Toast.LENGTH_SHORT).show();
        selectImage();
    }

    public void onPdfAttachmentClicked() {
        //todo open image for pdf picking
        Toast.makeText(getContext()," on pdf clicked", Toast.LENGTH_SHORT).show();
    }
    private void selectImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMG_REQUEST && resultCode == RESULT_OK && data!=null) {
            Uri selectedImage = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(Objects.requireNonNull(getContext()).getContentResolver()
                        , selectedImage);

                //image_view.setImageBitmap(bitmap);



                DialogAttachment dialogAttachment = new DialogAttachment();
                if (getFragmentManager() != null) {
                    dialogAttachment.show(getFragmentManager(),"DialogAttachment");
                }

//                addImageButton.setVisibility(View.GONE);
//                uploadButton.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String imageToString()
    {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }


    public void OnImageConfirmed(Bitmap bitmap){
        //upload here

        Toast.makeText(getActivity(), "File Selected", Toast.LENGTH_SHORT).show();

    }

}