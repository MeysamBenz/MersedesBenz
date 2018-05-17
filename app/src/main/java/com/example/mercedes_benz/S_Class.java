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

public class S_Class extends android.support.v4.app.Fragment {

    View view;
    List<DataModel> list;

    public S_Class(){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate( R.layout.activity_s__class,container,false );


        RecyclerView recyclerView=(RecyclerView) view.findViewById( R.id.recycler1 );

        list = new ArrayList<DataModel>();

        list.add( new DataModel( "S 350", getString( R.string.S_550 ), R.id.share, R.id.message , R.drawable.s350) );
        list.add( new DataModel( "S 550_2012", getString( R.string.S_550_2012 ), R.id.share, R.id.message, R.drawable.s550_2012 ) );
        list.add( new DataModel( "S 550", getString( R.string.S_550 ), R.id.share, R.id.message , R.drawable.s550) );
        list.add( new DataModel( "S_2018", getString( R.string.S2018 ), R.id.share, R.id.message, R.drawable.s2018 ) );
        list.add( new DataModel( "S_2018New", getString( R.string.S_2018N ), R.id.share, R.id.message,R.drawable.s2018n) );
        list.add( new DataModel( "S_Royal", getString( R.string.S_Royal ), R.id.share, R.id.message, R.drawable.sroyall) );


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter fragment__recyclerview=new RecyclerViewAdapter( getContext(),list );
        recyclerView.setAdapter( fragment__recyclerview );

        return view;
    }

}
