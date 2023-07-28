package com.example.educationnotes.bca.fifthsem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationnotes.R;

public class UploadPdfFifthActivity extends AppCompatActivity {

    Spinner spinner;
    String selectedOption =""; //Declare the variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_pdf_fifth);


        spinner = findViewById(R.id.spinner);

        // Create an array of options
        String[] options = {"Select PDF Type","Text Notes", "E-Books", "Question Papers"};

        // Create the ArrayAdapter using the options array and a default layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);

        // Set the layout for dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedOption = (String) parent.getItemAtPosition(position);
                Toast.makeText(UploadPdfFifthActivity.this, "Selected: " + selectedOption, Toast.LENGTH_SHORT).show();

                if(selectedOption.equals("Text Notes")) {
                    openNotesUploadActivity();
                } else if(selectedOption.equals("E-Books")) {
                    openEBooksUploadActivity();
                } else if(selectedOption.equals("Question Papers")) {
                    openQuestionPapersUploadActivity();
                } else {
                    Toast.makeText(UploadPdfFifthActivity.this, "Select PDF Type", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when no option is selected
            }
        });
    }

    private void openNotesUploadActivity() {
        Intent intent = new Intent(UploadPdfFifthActivity.this, NotesFifthUploadActivity.class);
        startActivity(intent);
        finish();
    }

    private void openEBooksUploadActivity() {
        Intent intent = new Intent(UploadPdfFifthActivity.this, EBooksFifthUploadActivity.class);
        startActivity(intent);
        finish();
    }

    private void openQuestionPapersUploadActivity() {
        Intent intent = new Intent(UploadPdfFifthActivity.this, QuestionPapersFifthUploadActivity.class);
        startActivity(intent);
        finish();
    }
}