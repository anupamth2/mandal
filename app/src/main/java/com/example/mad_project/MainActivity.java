package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    public void faculty_fun(View view)
    {
        Intent in=new Intent( getApplicationContext(),faculty_class.class );
        startActivity( in );
    }
    public void student_fun(View view)
    {
        Intent in1=new Intent( getApplicationContext(),student_class.class );
        startActivity( in1 );
    }

}