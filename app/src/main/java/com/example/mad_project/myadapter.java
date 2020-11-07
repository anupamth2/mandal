package com.example.mad_project;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myadapter extends RecyclerView.Adapter<myadapter.holder> {
    String data[];

    public myadapter(String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from( parent.getContext() );
        View view=inflater.inflate( R.layout.linear_layout,parent,false );
        return  new holder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.tv.setText( data[position] );

    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    class holder extends RecyclerView.ViewHolder {
        TextView tv;

        public holder(@NonNull View itemView) {
            super( itemView );
            tv=(TextView)itemView.findViewById( R.id.t1 );

        }
    }
}
