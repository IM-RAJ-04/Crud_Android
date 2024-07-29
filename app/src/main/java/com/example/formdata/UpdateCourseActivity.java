package com.example.formdata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateCourseActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private DBHandler dbHandler;
    String courseName, courseDesc, courseDuration, courseTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);

        // initializing all our variables.
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        Button updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);
        Button deleteCourseBtn = findViewById(R.id.idBtnDelete);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateCourseActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        courseName = getIntent().getStringExtra("name");
        courseDesc = getIntent().getStringExtra("description");
        courseDuration = getIntent().getStringExtra("duration");
        courseTracks = getIntent().getStringExtra("tracks");

        // setting data to edit text
        // of our update activity.
        courseNameEdt.setText(courseName);
        courseDescriptionEdt.setText(courseDesc);
        courseTracksEdt.setText(courseTracks);
        courseDurationEdt.setText(courseDuration);

        // adding on click listener to our update course button.
        updateCourseBtn.setOnClickListener(v -> {

            // inside this method we are calling an update course
            // method and passing all our edit text values.
            dbHandler.updateCourse(courseName, courseNameEdt.getText().toString(), courseDescriptionEdt.getText().toString(), courseTracksEdt.getText().toString(), courseDurationEdt.getText().toString());
            // displaying a toast message that our course has been updated.
            Toast.makeText(UpdateCourseActivity.this, "Data Updated..", Toast.LENGTH_SHORT).show();

            // launching our main activity.
            Intent i = new Intent(UpdateCourseActivity.this, MainActivity.class);
            startActivity(i);
        });

        // adding on click listener for delete button to delete our course.
        deleteCourseBtn.setOnClickListener(v -> {

            // calling a method to delete our course.
            dbHandler.deleteCourse(courseName);
            Toast.makeText(UpdateCourseActivity.this, "Deleted the data", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(UpdateCourseActivity.this, MainActivity.class);
            startActivity(i);
        });
    }
}