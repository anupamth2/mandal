package com.example.mad_project;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import static com.example.mad_project.R.color.colorPrimary;

public class student_quiz_class extends MainActivity {
    ListView l1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    HashMap<String,String> hash=new HashMap(  );
    HashMap<String,String> h12=new HashMap<>(  );
    ArrayList<String> cars = new ArrayList<String>();
    int index=8;
    final ArrayList<String> cars1 = new ArrayList<String>();
    final ArrayList<String> cars2 = new ArrayList<String>();
    final ArrayList<String> car3 = new ArrayList<String>();
    int random1=97655;
    int minutess;
    int uniq_no=99332;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.student_quiz_xml );
        // we are the created a intent variable in6 to get intent

        Intent in6 = getIntent();
        final ArrayAdapter<String> array= new ArrayAdapter<>(getApplicationContext(),R.layout.list_view,cars2 );
        Random rand=new Random( );
        random1=rand.nextInt(9999);
        random1+=10000;
        minutess=in6.getIntExtra( "minutes",5 );
         uniq_no=in6.getIntExtra( "uniq_no",53223 );



        int val=in6.getIntExtra( "uniq_no",57999 );
        String s=Integer.toString( val );
        DocumentReference docRef = db.collection("QUIZ_DATABASE").document(s);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        String s=document.getData().toString();

                        Toast.makeText( getApplicationContext(),"we have download text ",Toast.LENGTH_LONG ).show();
                      //  TextView t1=findViewById( R.id.textView8 );
                      //  t1.setText( s );
                        int i,j,k;
                        String sk="";
                        for(i=0;i<s.length();i++)
                        {
                            if(s.charAt( i )=='/')
                            {
                                cars.add( sk );
                                sk="";
                            }
                            else
                                sk=sk+s.charAt( i );


                        }
                        for(i=0;i<cars.size();i++)
                        {
                            cars2.add(cars.get( i ));


                        }

                            l1 = findViewById( R.id.L1 );


                            l1.setAdapter( array );
                            final EditText er23=findViewById( R.id.editTextTextPersonName10 );

                            l1.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                    Toast.makeText( getApplicationContext(), "you have answered  " + i + " " + l, Toast.LENGTH_LONG ).show();
                                    //adapterView.getChildAt( i ).setBackgroundColor( Color.parseColor( "#000000" ) );
                                    int k09=i-3;
                                    int k19=k09%5;
                                    k19-=1;
                                    int k3451=k09/5;
                                    k3451+=1;
                                    if(k19==0)
                                        Toast.makeText( getApplicationContext(), "you have clicke the question "+k3451, Toast.LENGTH_LONG ).show();
                                    else
                                    {
                                        if(k19==-1)
                                        {k19=4;k3451-=1;}
                                        Toast.makeText( getApplicationContext(),"you have answer "+k3451+"question  answer  "+k19,Toast.LENGTH_LONG ).show();
                                        er23.append( Integer.toString( k3451 ) );
                                        er23.append( "," );
                                        send_answer_to_firebase(k3451,k19);
                                    }

                                    //findViewById( view.getId() ).setBackgroundColor( -65504 );

                                }
                            } );





                    } else {
                        //Log.d(TAG, "No such document");
                        Intent in54=new Intent( getApplicationContext(),student_class.class );
                        Toast.makeText(getApplicationContext(),"no such quiz no exist",Toast.LENGTH_LONG).show();
                        startActivity( in54 );
                    }
                } else {
                    //Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });


    }

    private void send_answer_to_firebase(int k3451, int k19) {
       // DocumentReference docRef = db.collection("QUIZ_DATABASE").document(Integer.toString( random1 ));
        h12.put( Integer.toString(k3451),Integer.toString( k19) );


    }

    public void take_photo_and_submit(View view)
    {
        Calendar calendar = Calendar.getInstance();
        int minut = calendar.get(Calendar.MINUTE);
        if(minutess>40)
            minut+=60;
        if(minut-minutess>15)
            Toast.makeText( getApplicationContext(),"your time is completed" ,Toast.LENGTH_LONG).show();
        String errt=Integer.toString( random1 )+"___"+Integer.toString( uniq_no );
         db.collection("QUIZ_ANSWER_DATABASE").document(errt).set( h12 );

        dispatchTakePictureIntent();

        Toast.makeText(getApplicationContext(),"your response is recorded ",Toast.LENGTH_LONG).show();
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            Toast.makeText( this,"an error in taking photo ",Toast.LENGTH_LONG ).show();
            // display error state to the user
        }
    }
    public void next_question(View view)
    {
        cars2.clear();
        if(index+5>=cars.size())
            return;
        for(int i=0;i<4;i++)
            cars2.add(cars.get( i ));
        for(int i=index+1;i<index+5;i++)
        {
            cars2.add(cars.get( i ));
        }
        l1 = findViewById( R.id.L1 );
        final ArrayAdapter<String> array= new ArrayAdapter<>(getApplicationContext(),R.layout.list_view,cars2 );


        l1.setAdapter( array );
        EditText er2=findViewById( R.id.editTextTextPersonName10 );



        l1.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText( getApplicationContext(), "you have clicked " + i + " " + l, Toast.LENGTH_LONG ).show();
               // findViewById( view.getId() ).setBackgroundColor( -65504 );
                //gersetBackgroundColor( Integer.parseInt( "#ffffff" ) );
                //view.findViewById( i ).setBackgroundColor( Integer.parseInt( "##4287f5" ) );



            }
        } );


    }
    public  void go_to_recycle_class()
    {
        Intent n1=new Intent(this,new_rc.class );
        //n1.putStringArrayListExtra( "car2",cars2 );
        startActivity( n1 );

    }



}
