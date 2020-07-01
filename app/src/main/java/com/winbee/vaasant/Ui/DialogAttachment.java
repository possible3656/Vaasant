package com.winbee.vaasant.Ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.winbee.vaasant.R;

import java.util.Objects;

public class DialogAttachment extends AppCompatDialogFragment {

    ImageView imageView;
    TextView textView;
    OnConfirmClicked onConfirmClicked;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater= Objects.requireNonNull(getActivity()).getLayoutInflater();

        View v= inflater.inflate(R.layout.attachment_dialog,null);
        imageView=v.findViewById(R.id.imageViewDialog);
        textView=v.findViewById(R.id.attachmentNameDialog);

        imageView.setImageBitmap(HomeworkDiscriptionFragment.bitmap);


        builder.setView(v)
                .setTitle("You Choose")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Confirm Upload", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onConfirmClicked.onConfirmClickedPhoto(HomeworkDiscriptionFragment.bitmap);
            }
        });
        return builder.create();
    }

    public interface OnConfirmClicked{
        void onConfirmClickedPhoto(Bitmap bitmap);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnConfirmClicked)
        {
            onConfirmClicked = (OnConfirmClicked) context;
        } else  {
//            throw new ClassCastException(context.toString()
//                    + " must implement BottomSheetListener");
            throw new RuntimeException(context.toString()
                    + " must implement onConfirm");
        }
    }
}
