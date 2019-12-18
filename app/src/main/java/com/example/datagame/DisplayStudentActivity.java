package com.example.datagame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datagame.Model.Student;

import java.util.List;


public class DisplayStudentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnBackToAddStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);
        recyclerView = findViewById(R.id.recyclerViewStudents);
        btnBackToAddStudents = findViewById(R.id.btnBackToAdd);

        DatabaseHelper dbHelper = new DatabaseHelper(DisplayStudentActivity.this);
        List<Student> studentList = dbHelper.displayStudents();

        com.example.datagame.Adapter.StudentAdapter studentAdapter =
                new com.example.datagame.Adapter.StudentAdapter(DisplayStudentActivity.this, studentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);

        btnBackToAddStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (DisplayStudentActivity.this, com.example.datagame.MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
