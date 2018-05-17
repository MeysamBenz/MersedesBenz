package com.example.mercedes_benz;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public  class FIRSET_CAR extends Fragment{
    View view;
    List<DataModel> list;

    public FIRSET_CAR(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate( R.layout.activity_firset__car,container,false );


        RecyclerView recyclerView=(RecyclerView) view.findViewById( R.id.recycler1 );

        list = new ArrayList<DataModel>();

        list.add( new DataModel( "First 1", getString( R.string.Classic_FirstCar1 ), R.id.share, R.id.message, R.drawable.firstcar1 ) );
        list.add( new DataModel( "First 2", getString( R.string.First_Car2 ), R.id.share, R.id.message,R.drawable.firstcar2 ) );
        list.add( new DataModel( "First 3", getString( R.string.First_Car3 ), R.id.share, R.id.message, R.drawable.firstcar3 ) );


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter fragment__recyclerview=new RecyclerViewAdapter( getContext(),list );
        recyclerView.setAdapter( fragment__recyclerview );

        return view;
    }



}
