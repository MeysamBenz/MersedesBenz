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

public class G_Class extends android.support.v4.app.Fragment {

    View view;
    List<DataModel> list;

    public G_Class(){

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate( R.layout.activity_g__class,container,false );



        RecyclerView recyclerView=(RecyclerView) view.findViewById( R.id.recycler1 );

        list=new ArrayList<DataModel>(  );

        list.add( new DataModel( "G 65",getString( R.string.G65 ),R.id.share,R.id.message,R.drawable.g65) );
        list.add( new DataModel( "G Amg",getString( R.string.G_AMG_66),R.id.share,R.id.message,R.drawable.gamg) );
        list.add( new DataModel( "G Class",getString( R.string.G_Class2018),R.id.share,R.id.message ,R.drawable.gclass) );


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter fragment__recyclerview=new RecyclerViewAdapter( getContext(),list );
        recyclerView.setAdapter( fragment__recyclerview );

        return view;
    }



}
