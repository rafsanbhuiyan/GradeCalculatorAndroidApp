package com.example.cs311T_u3_subnode_rafsanbhuiyan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    public static final String TEXT_EXTRA = "com.example.cs311T_u3_subnode_rafsanbhuiyan.TEXT_EXTRA";

    Button submit2;
    EditText subject;
    TextView subChange;

    String getSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        submit2 = findViewById(R.id.submitButton2);

        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //subChange = findViewById(R.id.headingLabel);

                //subChange.setText(getSubject);

                openActivity2();
            }
        });

    }
    public void openActivity2()
    {
        subject = findViewById(R.id.subjectInput);
        getSubject = subject.getText().toString().trim();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(TEXT_EXTRA, getSubject);
        startActivity(intent);
    }
}
