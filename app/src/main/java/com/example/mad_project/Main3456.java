package com.example.mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Main3456 extends AppCompatActivity {


    Button b1;
    Button b2;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main345 );
        b1 = (Button) findViewById( R.id.sign_in );
        b2 = (Button) findViewById( R.id.sign_up );
        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace( R.id.holder, new signin_fragment() ).addToBackStack( null ).commit();


            }
        } );
        b2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace( R.id.holder, new signup_fragment() ).addToBackStack( null ).commit();


            }
        } );
    }
    public void get_answer(View view)
    {
        int pass=56789;
        final EditText e1=findViewById( R.id.editTextTextPersonName9 );
        String pas11=e1.getText().toString();


        if((pas11.length()!=5))
        {
            Toast.makeText( getApplicationContext(),"wrong password",Toast.LENGTH_LONG).show();
            return;

        }
        Integer pas1=Integer.parseInt( pas11 );

        if(pas1==pass)
        {
            db.collection("QUIZ_ANSWER_DATABASE")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    //Log.d(TAG, document.getId() + " => " + document.getData());
                                    String d2=document.getData().toString();
                                    String d4=document.getId().toString();
                                    e1.append( d4 );
                                    e1.append( d2 );
                                }
                            } else {
                               // Log.d(TAG, "Error getting documents: ", task.getException());
                            }
                        }
                    });


        }


    }
}

