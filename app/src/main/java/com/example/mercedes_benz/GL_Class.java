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

public class GL_Class extends android.support.v4.app.Fragment {

    View view;
    List <DataModel> list;

    public GL_Class(){

    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.activity_gl__class, container, false );



        RecyclerView recyclerView=(RecyclerView) view.findViewById( R.id.recycler1 );

        list = new ArrayList <DataModel>();

        list.add( new DataModel( "GL_2013", getString( R.string.GL2013 ), R.id.share, R.id.message, R.drawable.gl2013 ) );
        list.add( new DataModel( "GL_2015", getString( R.string.GL_2015 ), R.id.share, R.id.message, R.drawable.gl2015 ) );
        list.add( new DataModel( "GL_2016", getString( R.string.GL_2016 ), R.id.share, R.id.message , R.drawable.gl2016) );


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter fragment__recyclerview=new RecyclerViewAdapter( getContext(),list );
        recyclerView.setAdapter( fragment__recyclerview );

        return view;


    }

}
