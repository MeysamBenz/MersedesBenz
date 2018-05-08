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

public class SLS_Class extends android.support.v4.app.Fragment {

    View view;
    List <DataModel> list;


    public SLS_Class() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.activity_sls__class, container, false );

        list = new ArrayList <DataModel>();

        list.add( new DataModel( "SLS_2011", getString( R.string.SLS_2011 ), R.id.share, R.id.message, R.drawable.sls2011 ) );
        list.add( new DataModel( "SLS_GTR", getString( R.string.SLS_GTR ), R.id.share, R.id.message, R.drawable.slsgtr ) );


        RecyclerView recyclerView = (RecyclerView) view.findViewById( R.id.recycler1 );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), list);
        recyclerView.setAdapter( adapter );



        return view;
    }

    //==============================================================================================


}

