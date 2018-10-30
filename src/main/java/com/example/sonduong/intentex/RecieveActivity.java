package com.example.sonduong.intentex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class RecieveActivity extends AppCompatActivity {


    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
        mTv = (TextView) findViewById(R.id.txtMessage);
        Intent intent = getIntent();
        Student hi = (Student) intent.getSerializableExtra("MyObject");

        mTv.setText(hi.getName());

    }
}
