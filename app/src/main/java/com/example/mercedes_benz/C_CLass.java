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

public class C_CLass extends android.support.v4.app.Fragment {
     View view;
    List<DataModel> list;

    public C_CLass(){

    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate( R.layout.activity_c__class,container,false );


        RecyclerView recyclerView=(RecyclerView) view.findViewById( R.id.recycler1 );

        list=new ArrayList <DataModel>(  );

        list.add( new DataModel( "C_Clasa_2000",getString( R.string.C2000 ),R.id.share,R.id.message,R.drawable.c2000 ) );
        list.add( new DataModel( "C63",getString( R.string.C63 ),R.id.share,R.id.message ,R.drawable.c63) );
        list.add( new DataModel( "C_Clasa_2012",getString( R.string.CClass2012 ),R.id.share,R.id.message,R.drawable.ccalss2012 ) );
        list.add( new DataModel( "C_Clasa_1999",getString( R.string.C1999 ),R.id.share,R.id.message,R.drawable.cclass1999 ) );
        list.add( new DataModel( "C_Clasa_Coupe",getString( R.string.CClassCoupe ),R.id.share,R.id.message,R.drawable.cclasscoupe ) );
        list.add( new DataModel( "C_Clasa_Sadan",getString( R.string.CClassSadan ),R.id.share,R.id.message,R.drawable.cclasssadan ) );


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );
        RecyclerViewAdapter fragment__recyclerview=new RecyclerViewAdapter( getContext(),list );
        recyclerView.setAdapter( fragment__recyclerview );

        return view;
    }


}


