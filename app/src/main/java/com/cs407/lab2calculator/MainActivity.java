package com.cs407.lab2calculator;

import androidx.appcompat.app.AppCompatActivity;

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
    public void add(View view) {
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        Toast.makeText(MainActivity.this, num1.getText().toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this, num2.getText().toString(), Toast.LENGTH_LONG).show();
        //goToActivity(myTextField.getText().toString());
    }
}