package com.example.mad_project;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class recycle_view extends MainActivity  {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.recycle_view_xml1 );

        RecyclerView recl=(RecyclerView)findViewById( R.id.rclview );
        recl.setLayoutManager(new LinearLayoutManager(this));
        String arr[]={"rema","noje","siys ","dataf","rema","noje","siys ","dataf"};
        recl.setAdapter( new myadapter( arr ) );
    }
}
