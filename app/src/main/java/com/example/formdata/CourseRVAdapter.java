package com.example.formdata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    private final ArrayList<CourseModal> courseModalArrayList;
    private final Context context;

    public CourseRVAdapter(ArrayList<CourseModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseModal modal = courseModalArrayList.get(position);

        // Bind data to views
        holder.courseNameTV.setText(modal.getCourseName());
        holder.courseTracksTV.setText(modal.getCourseTracks());
        holder.courseDurationTV.setText(modal.getCourseDuration());
        holder.courseDescriptionTV.setText(modal.getCourseDescription());

        // Add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(v -> {
            // Calling an intent.
            Intent i = new Intent(context, UpdateCourseActivity.class);

            // Passing all our values.
            i.putExtra("name", modal.getCourseName());
            i.putExtra("description", modal.getCourseDescription());
            i.putExtra("duration", modal.getCourseDuration());
            i.putExtra("tracks", modal.getCourseTracks());

            // Starting our activity.
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView courseNameTV;
        private final TextView courseTracksTV;
        private final TextView courseDurationTV;
        private final TextView courseDescriptionTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views from course_rv_item.xml
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseTracksTV = itemView.findViewById(R.id.idTVCourseTracks);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);
            courseDescriptionTV = itemView.findViewById(R.id.idTVCourseDescription);
        }
    }
}