package com.example.areacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewTriangle, imageViewCircle, imageViewSquare;
    private TextView textViewShapeSelected, textView2, length2, length1, textViewResult;
    double len1, len2;
    private Button clearButton,calculateButton;
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
        len1 =0.0;
        len2 =0.0;
        calculateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (length1.getText().toString().equals("")) {
                    length1.setError("hey! i need a value!");
                }
                else{
                    len1 = Double.parseDouble(length1.getText().toString());
                }
                if (length2.getText().toString().equals("")) {
                    length2.setError("hey! i need a value!");
                }
                else{
                    len2 = Double.parseDouble(length2.getText().toString());
                }
                double result= 0;
                switch (selectedShape) {
                    case "Triangle":
                        Log.i("shape selected", selectedShape);
                        result = .5 * len1 * len2;
                        textViewResult.setText(Double.toString(result));
                        Log.d("result for triangle", Double.toString(result));
                        break;
                    case "Circle":
                        Log.i("shape selected", selectedShape);
                        result = Math.round(3.14 * Math.pow(len1,2));
                        textViewResult.setText(Double.toString(result));
                        Log.d("result for circle", Double.toString(result));
                        break;
                    case "Square":
                        Log.i("shape selected", selectedShape);
                        result = len1 * len1;

                        textViewResult.setText(Double.toString(result));

                        Log.d("result for Square", Double.toString(result));
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "No shape selected!", Toast.LENGTH_SHORT).show();
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
                textViewResult.setText("");
                textViewShapeSelected.setText("Square");
                textView2.setVisibility(View.GONE);
                length2.setVisibility(View.GONE);
                selectedShape = textViewShapeSelected.getText().toString();
             //   Log.d("selected shape", selectedShape);

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
        textViewShapeSelected.setText("Select a shape");
        textViewResult.setText("");
        selectedShape ="";
    }

}
