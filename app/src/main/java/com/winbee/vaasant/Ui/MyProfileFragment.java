package com.winbee.vaasant.Ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.winbee.vaasant.R;
import com.winbee.vaasant.Utils.SharedPrefManager;

public class MyProfileFragment extends Fragment {
    TextView studentName, studentRollNumber, studentPhoneNumber, studentClass;
    TextView mentorName, mentorPhoneNumber;
    ImageView mentorCall, mentorMessage;
    String Name,Mobile,Roll,Class;


    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        Name = SharedPrefManager.getInstance(getActivity()).refCode().getName();
        Mobile = SharedPrefManager.getInstance(getActivity()).refCode().getUsername();
        Roll = SharedPrefManager.getInstance(getActivity()).refCode().getRegistration_number();
        Class = SharedPrefManager.getInstance(getActivity()).refCode().getClass_data();
        studentName = view.findViewById(R.id.studentNameFee);
        studentName.setText(Name);
        studentRollNumber = view.findViewById(R.id.rollNumberMyProfile);
        studentRollNumber.setText(Roll);
        studentPhoneNumber = view.findViewById(R.id.phoneNumberMyProfile);
        studentPhoneNumber.setText(Mobile);
        studentClass = view.findViewById(R.id.classMyProfile);
        studentClass.setText(Class);
        mentorName = view.findViewById(R.id.mentorNameMyProfile);
        mentorPhoneNumber = view.findViewById(R.id.mentorPhoneNumberNameMyProfile);
        mentorCall = view.findViewById(R.id.callImageMyprofile);
        mentorMessage = view.findViewById(R.id.messageImageMyProfile);





        return view;
    }
}