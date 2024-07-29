package com.example.formdata;

public class CourseModal {
    // variables for our coursename,
    // description, tracks and duration, id.
    private final String courseName;
    private final String courseDuration;
    private final String courseTracks;
    private final String courseDescription;

    // creating getter and setter methods
    public String getCourseName() { return courseName; }

    public String getCourseDuration()
    {
        return courseDuration;
    }

    public String getCourseTracks() { return courseTracks; }

    public String getCourseDescription()
    {
        return courseDescription;
    }

    // constructor
    public CourseModal(String courseName,
                       String courseDuration,
                       String courseTracks,
                       String courseDescription)
    {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseTracks = courseTracks;
        this.courseDescription = courseDescription;
    }
}