package com.cs407.lab2calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //first number
    public int x1;
    //second number
    public int y1;
    //error idx
    public int e;
    public void initialize(View view){
        e = 0;
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        //Toast.makeText(MainActivity.this, num1.getText().toString(), Toast.LENGTH_LONG).show();
        //Toast.makeText(MainActivity.this, num2.getText().toString(), Toast.LENGTH_LONG).show();
        String x = num1.getText().toString();
        String y = num2.getText().toString();
        try {
            this.x1 = Integer.parseInt(x);
            this.y1 = Integer.parseInt(y);

            // Check if y1 is zero
            if (y1 == 0) {
                handleError(1); // Call your error handling function
            }
        } catch (NumberFormatException e) {
            handleError(2); // Handle the case where x or y cannot be parsed as integers
        }
    }

    public void handleError(int i){
        if (i == 1){
            Toast.makeText(this, "Error: Division by zero", Toast.LENGTH_SHORT).show();
        }
        if (i == 2){
            Toast.makeText(this, "Error: Non-integer inputs", Toast.LENGTH_SHORT).show();
        }
        e = 1;
    }
    public void add(View view) {
        initialize(view);
        if (e == 0) {
            goToActivity(x1 + y1);
        }
    }

    public void sub(View view) {
        initialize(view);
        if (e == 0) {
            goToActivity(x1 - y1);
        }
    }

    public void mul(View view) {
        initialize(view);
        if (e == 0) {
            goToActivity(x1 * y1);
        }
    }

    public void div(View view) {
        initialize(view);
        if (e == 0) {
            double result = (double) x1 / y1;
            String formattedResult = String.format("%.3f", result);
            double formattedResultDouble = Double.parseDouble(formattedResult);
            goToActivity(formattedResultDouble);
        }
    }

    public void goToActivity(double x){
        Intent intent = new Intent(this, CalculatorActivity.class);
        intent.putExtra("message", x);
        startActivity(intent);
    }
}