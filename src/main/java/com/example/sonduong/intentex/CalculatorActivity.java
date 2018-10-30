package com.example.sonduong.intentex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private float num1;
    private float num2;
    private TextView txt1;
    private TextView txt2;
    private String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        txt1 = (TextView) findViewById(R.id.num1);
        txt2 = (TextView) findViewById(R.id.num2);
        Intent intent = getIntent();



        Student hi = (Student) intent.getSerializableExtra("MyObject");

        txt1.setText(hi.getName()+".0");
        txt2.setText(hi.getAge()+".0");
    }
    public void send(){
        Intent intent = new Intent ( this, MainActivity.class);
        intent.putExtra("name", result);
        setResult(123,intent);
        finish();
    }
    public void add(View v){
        float hi = Float.parseFloat(txt1.getText().toString()) + Float.parseFloat(txt2.getText().toString());
        result =""+ txt1.getText().toString() + " + " + txt2.getText().toString() + " = " + hi;
        send();
    }
    public void chia(View v){
        float hi =Float.parseFloat(txt1.getText().toString()) % Float.parseFloat(txt2.getText().toString());
        result =""+ txt1.getText().toString() + " % " + txt2.getText().toString() + " = " + hi;
        send();
    }
}
