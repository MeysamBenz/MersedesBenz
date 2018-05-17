package com.example.mercedes_benz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private ImageButton BtnSearch,BtnRefresh;
//    private EditText edit1;
//    private AppBarLayout appBarLayout;
      private TabLayout tabLayout;
      private ViewPager viewPager;
//    private CoordinatorLayout coordinatorLayout;
//    private WebView webView;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );



//        BtnSearch=(ImageButton) findViewById( R.id.search );
//        BtnRefresh=(ImageButton) findViewById( R.id.refresh );
//        appBarLayout=(AppBarLayout) findViewById( R.id.appBar );
          tabLayout=(TabLayout) findViewById( R.id.tab1 );
          viewPager=(ViewPager) findViewById( R.id.viewPager );
//        coordinatorLayout=(CoordinatorLayout) findViewById( R.id.coordinaitor );//        webView=(WebView) findViewById( R.id.web1 );
//        edit1=(EditText) findViewById( R.id.edit1 );
//
//        edit1.setOnTouchListener( new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                edit1.setFocusable(true);
//                edit1.setFocusableInTouchMode(true);
//                return false;
//            }
//        } );
//
//        //==========================================================================================
//
//        BtnSearch.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String Url=edit1.getText().toString();
//                webView.loadUrl( "http://www."+Url );
//
//                webView.setVisibility( View.VISIBLE );
//
//
//            }
//        } );
//
//
//        BtnRefresh.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                webView.reload();
//
//
//            }
//        } );

        //==========================================================================================

        Fragment_Manager fragment_manager=new Fragment_Manager( getSupportFragmentManager() );

        fragment_manager.AddFragment_Title( new Biography(),"Biography");
        fragment_manager.AddFragment_Title( new FIRSET_CAR(),"First_Car" );
        fragment_manager.AddFragment_Title( new A_Class(),"A_Class" );
        fragment_manager.AddFragment_Title( new C_CLass(),"C_Class" );
        fragment_manager.AddFragment_Title( new CLK_Class(),"CLK_Class" );
        fragment_manager.AddFragment_Title( new CLS_Class(),"CLS_Class" );
        fragment_manager.AddFragment_Title( new E_Class(),"E_Class" );
        fragment_manager.AddFragment_Title( new G_Class(),"G_Class"  );
        fragment_manager.AddFragment_Title( new GL_Class(),"GL_Class " );
        fragment_manager.AddFragment_Title( new S_Class(),"S_Class" );
        fragment_manager.AddFragment_Title( new SLS_Class(),"SLS_Class" );


        viewPager.setAdapter( fragment_manager );
        tabLayout.setupWithViewPager( viewPager );

    }


}
