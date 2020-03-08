package com.example.cs311T_u3_subnode_rafsanbhuiyan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText sub1;
    EditText sub2;
    EditText sub3;

    TextView heading;
    TextView resultMax;
    TextView resultMin;
    TextView resultAvg;
    TextView letterGrade;

    Button submit;
    Button next;

    Boolean validateA = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create intent to get intent from Main2Activity
        Intent intent = getIntent();
        //Get the string input from second activtiy page
        String text = intent.getStringExtra(Main2Activity.TEXT_EXTRA);

        //find the headinglabel
        heading = findViewById(R.id.headingLabel);

        //Dynamic update of headingLabel
        heading.setText(text);

        //Get the next button from the layout
        next = findViewById(R.id.nextButton);

        //Set the onClickListener
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });


        //Get the submit button from the layout
        submit = findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //Get the inputs from the layout resource
            sub1 = findViewById(R.id.subInput1);
            sub2 = findViewById(R.id.subInput2);
            sub3 = findViewById(R.id.subInput3);

            //Get the TextViews member type from the layout resource
            resultMax = findViewById(R.id.maxOutput);
            resultMin = findViewById(R.id.minOutput);
            resultAvg = findViewById(R.id.avgOutput);
            letterGrade = findViewById(R.id.letterOutput);

            //Initialize three string variables
            String subNum1;
            String subNum2;
            String subNum3;

            //Get the inputs from the user and assign it to double variables
            subNum1 = sub1.getText().toString().trim();
            subNum2 = sub2.getText().toString().trim();
            subNum3 = sub3.getText().toString().trim();

            //if statement to evaluate if the fields are empty
            //if the fields are not empty start the calculation process
            if(subNum1.isEmpty() || subNum2.isEmpty() || subNum3.isEmpty())
            {
                Toast.makeText(getApplicationContext(), "Error! " +
                                "Field can't be empty",
                        Toast.LENGTH_SHORT).show();
            }
            else
             {
                 //Initialize integer variables
                int s1, s2, s3;

                //PerseInt function to convert strings to integer
                s1 = Integer.parseInt(subNum1);
                s2 = Integer.parseInt(subNum2);
                s3 = Integer.parseInt(subNum3);

                 //Get the grades for subject1,2 and 3
                 //Add a condition the app only takes valid inputs from 0 to 100
                 //In case of invalid inputs, prompt the user for a valid input
                 if ((s1 < 0) || (s2 < 0) || (s3 < 0)) {
                     Toast.makeText(getApplicationContext(), "Error! Number Cannot be less " +
                                     "than 0",
                             Toast.LENGTH_SHORT).show();
                 } else if ((s1 > 100) || (s2 > 100) || (s3 > 100)) {
                     Toast.makeText(getApplicationContext(), "Error! Number Cannot be greater " +
                                     "than 100",
                             Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     //Initialize variables
                     double totalGpaAvg = 0;
                     int gpaVal = s1+s2+s3;

                     //Build an array with the inputs
                     int[] numArr = {s1,s2,s3};

                     //Sort the array
                     Arrays.sort(numArr);

                     //Print the max
                     resultMax.setText(""+numArr[numArr.length-1]);

                     //Print the min
                     resultMin.setText(""+numArr[0]);

                     //Calculate the average gpa
                     totalGpaAvg = gpaVal/3;

                     //calculate the result
                     resultAvg.setText(""+totalGpaAvg);

                     //if else condition statement to determine the letter grade
                     if(totalGpaAvg >= 90)
                     {
                         letterGrade.setText("A");
                     }
                     else if(totalGpaAvg >=80 && totalGpaAvg < 90 )
                     {
                         letterGrade.setText("B");
                     }
                     else if(totalGpaAvg >= 70 && totalGpaAvg <80)
                     {
                         letterGrade.setText("C");
                     }
                     else if(totalGpaAvg >= 60 && totalGpaAvg <70)
                     {
                         letterGrade.setText("D");
                     }
                     else
                     {
                         letterGrade.setText("F");
                     }

                 }
            }

            }




        });
    }
    public void openActivity()
    {

        Intent i = new Intent(this, Main2Activity.class);

        startActivity(i);
    }
}
