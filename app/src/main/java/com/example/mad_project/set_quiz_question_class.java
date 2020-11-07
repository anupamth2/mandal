package com.example.mad_project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.O)
public class set_quiz_question_class extends MainActivity {
    int k1=0;
    int k2=5;
    int k3=0;
    int order=0;
    int q_no=0;
    int cnt=10;
    String ques_list="";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String,Object> docdata=new HashMap<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.set_quiz_question_xml );
        Intent in4=getIntent();
        k1=in4.getIntExtra( "id",89943 );
        k2=in4.getIntExtra( "no",10 );
        k3=in4.getIntExtra( "time",10 );
        //docdata.put(cnt+" id",k1);
        ques_list=ques_list+order+" id "+k1+"/";
        order++;
        ques_list=ques_list+order+" no "+k2+"/";
        order++;
        ques_list=ques_list+order+" time "+k3+"/";
        order++;
        //cnt++;

        //docdata.put(cnt+" no",k2);
        //cnt++;
        //docdata.put(cnt+" time",k3);
        //cnt++;





        Toast.makeText( getApplicationContext(),"we have recieved intent"+k1+" "+k2+" "+k3,Toast.LENGTH_LONG ).show();


    }
    public void set_background1(View view)
    {
        EditText t1=findViewById( R.id.editTextTextPersonName );
        t1.setBackgroundColor(-65536);
    }
    public void set_background2(View view)
    {
        EditText t1=findViewById( R.id.editTextTextPersonName2 );
        t1.setBackgroundColor(-65536);
    }
    public void set_background3(View view)
    {
        EditText t1=findViewById( R.id.editTextTextPersonName5 );
        t1.setBackgroundColor(-65536);
    }
    public void set_background4(View view)
    {
        EditText t1=findViewById( R.id.editTextTextPersonName6 );
        t1.setBackgroundColor(-65536);
    }
    public void set_background5(View view)
    {
        EditText t1=findViewById( R.id.editTextTextPersonName7 );
        t1.setBackgroundColor(-65536);
    }

    public void send_to_firebase(View view)
    {

        EditText t1=findViewById( R.id.editTextTextPersonName );
        EditText t2=findViewById( R.id.editTextTextPersonName2 );
        EditText t3=findViewById( R.id.editTextTextPersonName5 );
        EditText t4=findViewById( R.id.editTextTextPersonName6 );
        EditText t5=findViewById( R.id.editTextTextPersonName7 );
        String s1=t1.getText().toString();
        String s2=t2.getText().toString();
        String s3=t3.getText().toString();
        String s4=t4.getText().toString();
        String s5=t5.getText().toString();
        t1.setText("enter the question");
        t2.setText( "option 1" );
        t3.setText( "option 2" );
        t4.setText( "option 3" );
        t5.setText( "option 4" );
        t1.setBackgroundColor(-16711936);
        t2.setBackgroundColor(-16711936);
        t3.setBackgroundColor(-16711936);
        t4.setBackgroundColor(-16711936);
        t5.setBackgroundColor(-16711936);


        q_no=q_no+1;

        /*

        docdata.put(cnt+" Question "+q_no,s1);
        cnt++;
        docdata.put(cnt+" "+q_no+" option 1",s2);
        cnt++;
        docdata.put(cnt+" "+q_no+" option 2",s3);
        cnt++;
        docdata.put(cnt+" "+q_no+" option 3",s4);
        cnt++;
        docdata.put(cnt+" "+q_no+" option 4",s5);
        cnt++;

         */
        ques_list=ques_list+order+" Question "+q_no+s1+"/";
        order++;
        ques_list=ques_list+order+" "+q_no+" option 1 -:"+s2+"/";
        order++;
        ques_list=ques_list+order+" "+q_no+" option 2 -: "+s3+"/";
        order++;
        ques_list=ques_list+order+" "+q_no+" option 3 -: "+s4+"/";
        order++;
        ques_list=ques_list+order+" "+q_no+" option 4 -: "+s5+"/*";
        order++;




        TextView t6=findViewById( R.id.textView7 );
        int k23=q_no+1;
        String s6="ENTER THE "+k23+" QUESTION BELOW";
        t6.setText( s6 );









    }
    public  void submit_to_firebase(View view)
    {
        if(q_no==0)
        {
            Toast.makeText( getApplicationContext(),"enter minimum 1 question",Toast.LENGTH_LONG ).show();
         return;

        }
        docdata.put( "questin_list/",ques_list );
        int k13=k1;
        String s12=Integer.toString( k13 );
        db.collection("QUIZ_DATABASE").document(s12)
                .set(docdata)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Log.d(TAG, "DocumentSnapshot successfully written!");
                        Toast.makeText( getApplicationContext(),"your quiz is regisered with id  "+k1,Toast.LENGTH_LONG ).show();
                        Button b1=findViewById( R.id.button5 );
                        b1.setText( "share "+k1+" with student for attempting quiz" );
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG, "Error writing document", e);
                    }
                });


    }




}
