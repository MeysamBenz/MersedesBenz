package com.example.mercedes_benz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class A_Class extends android.support.v4.app.Fragment{

    View view;
    List<DataModel> list;

    @SuppressLint("ValidFragment")
    public A_Class() {

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate( R.layout.activity_a__class,container,false );

        RecyclerView recyclerView=(RecyclerView) view.findViewById( R.id.recycler1 );

        list=new ArrayList <DataModel>(  );

        list.add( new DataModel( "New A_Class",getString( R.string.Aclass ),R.id.share,R.id.message,R.drawable.aclass) );
        list.add( new DataModel( "A_Class_1997",getString( R.string.Aclass1997 ),R.id.share,R.id.message,R.drawable.aclass1997) );
        list.add( new DataModel( "A_Class_2005",getString( R.string.Aclass2005 ),R.id.share,R.id.message,R.drawable.aclass2005) );
        list.add( new DataModel( "A_Class_2012",getString( R.string.Aclass21012 ),R.id.share,R.id.message,R.drawable.aclass2012) );


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter( getContext(),list );
        recyclerView.setAdapter( recyclerViewAdapter );

        return view;

    }




}

