package com.example.areacalculator;
/*
Assignment Number :In Class Assignment 2
File Name : MainActivity.java
Full Name : Team: 15
            Sahil Sood
            Harshitha Keshavaraju Vijayalakshmi
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private ImageView imageViewTriangle, imageViewCircle, imageViewSquare;
    private TextView textViewShapeSelected, textView2, length2, length1, textViewResult;
    double len1, len2;
    private Button clearButton, calculateButton;
    String selectedShape;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator");
        clearButton = (Button) findViewById(R.id.clearButton);
        calculateButton = (Button) findViewById(R.id.calculateButton);

        textViewShapeSelected = (TextView) findViewById(R.id.textViewShapeSelected);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textView2 = (TextView) findViewById(R.id.textView2);
        length2 = (TextView) findViewById(R.id.length2);
        length1 = (TextView) findViewById(R.id.length1);

        imageViewTriangle = (ImageView) findViewById(R.id.imageViewTriangle);
        imageViewCircle = (ImageView) findViewById(R.id.imageViewCircle);
        imageViewSquare = (ImageView) findViewById(R.id.imageViewSquare);


        clearButton();
        calculateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (length1.getText().toString().equals("")) {
                    length1.setError("hey! I need a value!");
                    len1 = 0;
                } else {
                    len1 = Double.parseDouble(length1.getText().toString());
                    length1.setError(null);
                }
                if (length2.getText().toString().equals("")) {
                    length2.setError("hey! I need a value!");
                    len2 = 0;
                } else {
                    len2 = Double.parseDouble(length2.getText().toString());
                    length1.setError(null);
                }
                double result = 0;
                switch (selectedShape) {
                    case "Triangle":
                        Log.i("shape selected", selectedShape);
                        result = 0.5 * len1 * len2;
                        result = Math.round(result * 100.0) / 100.0;
                        textViewResult.setText(Double.toString(result));
                        Log.d("result for triangle", Double.toString(result));
                        break;
                    case "Circle":
                        Log.i("shape selected", selectedShape);
                        result = 3.1416*len1*len1;
                        result = Math.round(result * 100.0) / 100.0;
                        textViewResult.setText(Double.toString(result));
                        Log.d("result for circle", Double.toString(result));
                        break;
                    case "Square":
                        Log.i("shape selected", selectedShape);
                        result = len1 * len1;
                        result = Math.round(result * 100.0) / 100.0;
                        textViewResult.setText(Double.toString(result));
                        Log.d("result for Square", Double.toString(result));
                        break;
                    default:
                        textViewShapeSelected.setError("No shape selected!");
                }

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });


        imageViewTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewShapeSelected.setError(null);
                textViewResult.setText("");
                textView2.setVisibility(View.VISIBLE);
                length2.setVisibility(View.VISIBLE);
                textViewShapeSelected.setText("Triangle");
                selectedShape = textViewShapeSelected.getText().toString();
                //  Log.d("selected shape", selectedShape);


            }
        });
        imageViewCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewShapeSelected.setError(null);
                textViewResult.setText("");
                textViewShapeSelected.setText("Circle");
                textView2.setVisibility(View.GONE);
                length2.setVisibility(View.GONE);
                selectedShape = textViewShapeSelected.getText().toString();
                //   Log.d("selected shape", selectedShape);
            }
        });
        imageViewSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewShapeSelected.setError(null);
                textViewResult.setText("");
                textViewShapeSelected.setText("Square");
                textView2.setVisibility(View.GONE);
                length2.setVisibility(View.GONE);
                selectedShape = textViewShapeSelected.getText().toString();

            }
        });

    }

    public void clearButton() {
        length1.setText("");
        length1.setError(null);
        length2.setError(null);
        length2.setText("");
        textView2.setVisibility(View.VISIBLE);
        length2.setVisibility(View.VISIBLE);
        textViewShapeSelected.setError(null);
        textViewShapeSelected.setText("Select a shape");
        textViewResult.setText("");
        selectedShape = "";

    }

}
