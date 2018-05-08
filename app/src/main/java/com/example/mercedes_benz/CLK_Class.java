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

public class CLK_Class extends android.support.v4.app.Fragment{

    View view;
    List<DataModel> list;

    public CLK_Class(){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate( R.layout.activity_clk__class,container,false );



        RecyclerView recyclerView=(RecyclerView) view.findViewById( R.id.recycler1 );

        list=new ArrayList<DataModel>(  );

        list.add( new DataModel( "CLK 280",getString( R.string.CLK280 ),R.id.share,R.id.message ,R.drawable.clk280) );
        list.add( new DataModel( "CLK 320",getString( R.string.CLK320 ),R.id.share,R.id.message,R.drawable.clk320 ) );
        list.add( new DataModel( "CLK 350",getString( R.string.CLK350 ),R.id.share,R.id.message,R.drawable.clk350 ) );
        list.add( new DataModel( "CLK GTR",getString( R.string.CLK_GTR ),R.id.share,R.id.message,R.drawable.clkgtr ) );


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter fragment__recyclerview=new RecyclerViewAdapter( getContext(),list );
        recyclerView.setAdapter( fragment__recyclerview );



        return view;
    }



}
