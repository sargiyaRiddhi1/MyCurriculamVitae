package com.example.riddhi.riddhiresumeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoriesActivity extends AppCompatActivity {
    @Bind(R.id.cardViewExperience)
    CardView card_view_experience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);


    }
    @OnClick(R.id.cardViewExperience)
    public void cardViewExperienceOnClickHandler(){
        Intent intent=new Intent(CategoriesActivity.this,ExperienceActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.card_view_education)
    public void cardViewEductaionOnClickHandler(){
        Intent intent=new Intent(CategoriesActivity.this,EducationActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.card_view_projectsandcourses)
    public void cardViewProjectsAndCoursesOnClickHAndler(){
        Intent intent=new Intent(CategoriesActivity.this,ProjectsAndCoursesActivity.class);
        startActivity(intent);
    }
}
