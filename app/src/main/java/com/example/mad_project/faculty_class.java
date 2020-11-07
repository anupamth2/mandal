package com.example.mad_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class faculty_class extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.facluty_xml );

    }
    public void faculty_quiz(View view)
    {
        EditText e1=findViewById( R.id.e1 );
        String s=e1.getText().toString();
        int n=Integer.parseInt( s );
        Intent in1=new Intent( getApplicationContext(),faculty_quiz_class.class );
        in1.putExtra( "quiz_no",n );
        startActivity( in1 );

    }
    public void check_answer_fun(View view)
    {
        Intent en2=new Intent( getApplicationContext(),Main3456.class );
        startActivity( en2 );
    }
}
