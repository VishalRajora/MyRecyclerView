package com.example.idcarddemo;

import android.app.DownloadManager;
import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    static  String url="http://demo8716682.mockable.io/cardData";

     JsonArrayRequest jsonArrayRequest;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<itemAdapter>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        recyclerView=(RecyclerView)findViewById ( R.id.recyclerView );
        recyclerView.setHasFixedSize ( true );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        list=new ArrayList <> (  );

        finalData ();

    }
    public void finalData()
    {
        final ProgressDialog progressDialog=new ProgressDialog ( this );
        progressDialog.setMessage ( "Processing.." );
        progressDialog.show ();

       jsonArrayRequest=new JsonArrayRequest ( url ,  new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response)
            {
                progressDialog.dismiss ();

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {

                    //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                    try {

                        jsonObject = response.getJSONObject(i);
                        itemAdapter anime = new itemAdapter ();

                        anime.setmImage (jsonObject.getString("url"));
                        anime.setmName (jsonObject.getString("name"));
                        anime.setLocation (jsonObject.getString("location"));
                        anime.setAge ( jsonObject.getString ( "age" ) );


                        list.add(anime);
                    }


                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                    adapter=new myAdapter (list,getApplicationContext () );
                    recyclerView.setAdapter ( adapter );
                }



            }
        } , new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.i ( "aaaaaa",error.getMessage () );
                Toast.makeText ( MainActivity.this , error.getMessage () , Toast.LENGTH_SHORT ).show ();

            }
        } );

        RequestQueue requestQueue= Volley.newRequestQueue ( this );
        requestQueue.add ( jsonArrayRequest);
    }
}
