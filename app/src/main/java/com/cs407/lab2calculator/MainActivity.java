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
    public void initialize(View view){
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        //Toast.makeText(MainActivity.this, num1.getText().toString(), Toast.LENGTH_LONG).show();
        //Toast.makeText(MainActivity.this, num2.getText().toString(), Toast.LENGTH_LONG).show();
        String x = num1.getText().toString();
        String y = num2.getText().toString();
        this.x1 = Integer.parseInt(x);
        this.y1 = Integer.parseInt(y);
    }
    public void add(View view) {
        initialize(view);
        goToActivity(x1+y1);
    }

    public void sub(View view) {
        initialize(view);
        goToActivity(x1-y1);
    }

    public void mul(View view) {
        initialize(view);
        goToActivity(x1*y1);
    }

    public void div(View view) {
        initialize(view);
        goToActivity(x1/y1);
    }

    public void goToActivity(double x){
        Intent intent = new Intent(this, CalculatorActivity.class);
        intent.putExtra("message", x);
        startActivity(intent);
    }
}