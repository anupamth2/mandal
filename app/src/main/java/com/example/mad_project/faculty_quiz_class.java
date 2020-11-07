package com.example.mad_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class faculty_quiz_class extends MainActivity {
    int quiz_no1=65424;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.faculty_quiz_xml );
        quiz_no1=98463;
        Intent in2=getIntent();
        int j1=in2.getIntExtra( "quiz_no",452234 );
        quiz_no1=j1;
        Toast.makeText(getApplicationContext(),"we have reevied as "+j1,Toast.LENGTH_LONG).show();


    }
    public void set_quiz_question(View view)
    {
        EditText t1=findViewById( R.id.editTextTextPersonName3 );
        String s1=t1.getText().toString();
       if(s1.length()==0)
           return;

        int a=Integer.parseInt( s1 );
        Random rand=new Random();
        int k=rand.nextInt(99999);
        a=a+k;

        EditText t2=findViewById( R.id.editTextTextPersonName4);
        String s2=t2.getText().toString();
        if(s2.length()==0)
            return;


        int b=Integer.parseInt( s2 );
       // Toast.makeText( this,"we have reached here ",Toast.LENGTH_LONG ).show();

       Intent in7= new Intent( this,set_quiz_question_class.class );
                //.show();
        in7.putExtra("id",quiz_no1);


        in7.putExtra( "no",a );


        in7.putExtra( "time",b );


        startActivity( in7 );


    }

}
