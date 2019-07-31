package com.example.idcarddemo;

import android.app.LauncherActivity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolderClass>
{
    List<itemAdapter>myList;
    Context context;

    public myAdapter(List < itemAdapter > myList , Context context)
    {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup , int i) {
        LayoutInflater layoutInflater=LayoutInflater.from ( viewGroup.getContext () );
      View myView=  layoutInflater.inflate ( R.layout.item_layout,viewGroup,false );
        return new myViewHolderClass (  myView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolderClass myViewHolderClass , int i)
    {

        myViewHolderClass.name.setText ( myList.get ( i ).getmName () );
        myViewHolderClass.location.setText ( myList.get ( i ).getLocation () );
        myViewHolderClass.age.setText ( myList.get ( i ).getAge () );

        Glide.with ( context ).load ( myList.get ( i ).getmImage () ).into ( myViewHolderClass.imageView );

    }

    @Override
    public int getItemCount() {
        return myList.size ();
    }

    public class myViewHolderClass extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView name;
        TextView age;
        TextView location;
        public myViewHolderClass(@NonNull View itemView) {
            super ( itemView );
            imageView =(ImageView)itemView.findViewById ( R.id.imageView );
            name=(TextView)itemView.findViewById ( R.id.name );
            age=(TextView)itemView.findViewById ( R.id.age );
            location=(TextView)itemView.findViewById ( R.id.location );
        }
    }
}
