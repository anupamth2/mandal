package com.example.mad_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

import static java.time.LocalDateTime.*;

public class student_class extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.student_xml );


    }
    public void student_quiz_fun(View view)
    {
        EditText e1=findViewById( R.id.editTextTextPersonName8 );
        String s=e1.getText().toString();
        int k120=Integer.parseInt( s );
        Intent in6=new Intent( getApplicationContext(),student_quiz_class.class );
        in6.putExtra( "uniq_no",k120 );
        Calendar cal = Calendar.getInstance( TimeZone.getTimeZone("GMT+5:30"));
        Calendar calendar = Calendar.getInstance();
        int minutes = calendar.get(Calendar.MINUTE);
        in6.putExtra( "minute",minutes );


        startActivity( in6 );
    }

}
