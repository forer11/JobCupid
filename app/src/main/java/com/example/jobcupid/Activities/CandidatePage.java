package com.example.jobcupid.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jobcupid.AppData;
import com.example.jobcupid.Candidate;
//import com.example.jobcupid.Profile;
import com.example.jobcupid.R;
//import com.example.jobcupid.TinderCard;
import com.example.jobcupid.Utils;

public class CandidatePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_page);
        AppData appData = (AppData)getApplicationContext();
        Candidate profile = appData.candidate;

        ImageView img_profile = findViewById(R.id.imageView);
        Glide.with(CandidatePage.this).load(profile.getImageUrl()).into(img_profile);
        TextView name= findViewById(R.id.name);
        TextView age= findViewById(R.id.age);
        TextView phone= findViewById(R.id.phone);
        TextView location= findViewById(R.id.location);
        TextView salary= findViewById(R.id.salary);
        TextView freeText= findViewById(R.id.freeText);
        TextView previousExperience= findViewById(R.id.previousExperience);
        TextView jobPercentage= findViewById(R.id.jobPercentage);
        name.setText(profile.getName());
        age.setText("Age: "+profile.getAge());
        phone.setText("0"+profile.getPhone());
        location.setText(profile.getLocation());
        if(profile.getSalary() != null)
            salary.setText("Salary:"+profile.getSalary());
        //freeText.setText(profile.ge);
        if(profile.getPreviousExperience() != null)
            previousExperience.setText("Previous Experience: "+profile.getPreviousExperience());
        if(profile.getFreeText() != null)
            freeText.setText("Free Text: "+profile.getFreeText() );
        jobPercentage.setText("Job Percentage: "+profile.getJobPercentage());







    }


}