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

public class CLS_Class extends android.support.v4.app.Fragment {

    View view;
    List<DataModel> list;

    public CLS_Class(){

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate( R.layout.activity_cls__class,container,false );



        RecyclerView recyclerView=(RecyclerView) view.findViewById( R.id.recycler1 );

        list=new ArrayList<DataModel>(  );

        list.add( new DataModel( "CLS 2012",getString( R.string.Cls2012 ),R.id.share,R.id.message,R.drawable.cls2012 ) );
        list.add( new DataModel( "CLS 2013",getString( R.string.Cls2013 ),R.id.share,R.id.message,R.drawable.cls2013) );
        list.add( new DataModel( "CLS 2015",getString( R.string.Cls2015 ),R.id.share,R.id.message ,R.drawable.cls2015) );
        list.add( new DataModel( "CLS New",getString( R.string.Cls_new ),R.id.share,R.id.message,R.drawable.clsnew ) );


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter fragment__recyclerview=new RecyclerViewAdapter( getContext(),list );
        recyclerView.setAdapter( fragment__recyclerview );

        return view;


    }
}

