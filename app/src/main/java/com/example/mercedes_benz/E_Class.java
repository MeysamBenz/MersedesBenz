package com.example.mercedes_benz;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class E_Class extends android.support.v4.app.Fragment {

    View view;
    ArrayList<DataModel> arraylist;

    public E_Class(){

    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate( R.layout.activity_e__class,container,false );


        RecyclerView recyclerView=(RecyclerView) view.findViewById( R.id.recycler1 );

        arraylist=new ArrayList<DataModel>(  );

        arraylist.add( new DataModel( "E_1999",getString( R.string.E1999 ),R.id.share,R.id.message,R.drawable.e1999) );
        arraylist.add( new DataModel( "E_2010",getString( R.string.E2009Coupe ),R.id.share,R.id.message ,R.drawable.e2010) );
        arraylist.add( new DataModel( "E_2015",getString( R.string.E2015),R.id.share,R.id.message,R.drawable.e2015) );
        arraylist.add( new DataModel( "E_2017",getString( R.string.E2017 ),R.id.share,R.id.message,R.drawable.e2017 ) );


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter fragment__recyclerview=new RecyclerViewAdapter( arraylist,getContext() );
        recyclerView.setAdapter( fragment__recyclerview );

        return view;
    }

}
