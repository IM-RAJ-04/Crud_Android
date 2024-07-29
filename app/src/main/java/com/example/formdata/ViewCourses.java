package com.example.formdata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);

        // Inisialisasi array list, DBHandler, dan RecyclerView
        ArrayList<CourseModal> courseModalArrayList;
        DBHandler dbHandler = new DBHandler(ViewCourses.this);
        courseModalArrayList = dbHandler.readCourses();

        // Inisialisasi adapter
        CourseRVAdapter courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);
        RecyclerView coursesRV = findViewById(R.id.idRVCourses);

        // Setting layout manager dan adapter untuk RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourses.this);
        coursesRV.setLayoutManager(linearLayoutManager);
        coursesRV.setAdapter(courseRVAdapter);
    }
}