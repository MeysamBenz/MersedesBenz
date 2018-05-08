package com.example.mercedes_benz;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CLASIC extends android.support.v4.app.Fragment {
    View view;
    List <DataModel> list;

    public CLASIC(){

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.activity_clasic, container, false );



        RecyclerView recyclerView = (RecyclerView) view.findViewById( R.id.recycler1 );

        list = new ArrayList <DataModel>();

        list.add( new DataModel( "Classic_220 S", getString( R.string.Classic_220S ), R.id.share, R.id.message, R.drawable.classic220s) );
        list.add( new DataModel( "Classic_380", getString( R.string.Classic_300SL ), R.id.share, R.id.message , R.drawable.classic380) );
        list.add( new DataModel( "Classic_Lovly", getString( R.string.Classic_Lovly ), R.id.share, R.id.message, R.drawable.classiclovly) );


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity());
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter fragment__recyclerview = new RecyclerViewAdapter( getContext(),list);
        recyclerView.setAdapter( fragment__recyclerview );

        return view;
    }



}
