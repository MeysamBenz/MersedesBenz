package com.example.mercedes_benz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

//    private ImageButton BtnSearch,BtnRefresh;
//    private EditText edit1;
//    private AppBarLayout appBarLayout;
      private TabLayout tabLayout;
      private ViewPager viewPager;
      private android.support.v7.widget.Toolbar toolbar1;
//      private Toolbar toolbar2;
      private ImageView logo;
      private NavigationView navigation1;
      private TextView text1;
      private ImageButton btn1;
      private DrawerLayout drawerLayout;
//    private CoordinatorLayout coordinatorLayout;
//    private WebView webView;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.drawer_view );

//=============================================

        tabLayout=(TabLayout) findViewById( R.id.tab1 );
          viewPager=(ViewPager) findViewById( R.id.viewPager );
          text1 = (TextView) findViewById( R.id.text1 );
          toolbar1 = (android.support.v7.widget.Toolbar) findViewById( R.id.toolbar1 );
          btn1 = (ImageButton) findViewById( R.id.imgbtn1 );
          drawerLayout = (DrawerLayout) findViewById( R.id.drawer1 );
          navigation1 = (NavigationView) findViewById( R.id.navigation1 );
//        toolbar2 =(android.support.v7.widget.Toolbar) findViewById( R.id.toolbar2 );
//        BtnSearch=(ImageButton) findViewById( R.id.search );
//        BtnRefresh=(ImageButton) findViewById( R.id.refresh );
//        appBarLayout=(AppBarLayout) findViewById( R.id.appBar );
//        coordinatorLayout=(CoordinatorLayout) findViewById( R.id.coordinaitor );
//        webView=(WebView) findViewById( R.id.web1 );
//        edit1=(EditText) findViewById( R.id.edit1 );
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
        //==================================================================
        //==================================================================


        navigation1.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.contact :
                        Snackbar.make( navigation1,"Telegram Id : @MeysamManiei69"+"\n"+"Gmail : meysam.benz69@gmail.com",Snackbar.LENGTH_LONG ).show();
                        break;

                    case R.id.share :
                        ApplicationInfo app = getApplicationContext().getApplicationInfo();
                        String filePath = app.publicSourceDir;
                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                        Uri uri = Uri.parse(filePath);
                        sharingIntent.setType("*/*");
                        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
                        sharingIntent.putExtra(Intent.EXTRA_TEXT, "Click to blue link and download thegame. https://drive.google.com/open?id=10Nc5BoYn4NZ_O8ae32UVQwyzdCzFxNy");
                        startActivity(Intent.createChooser(sharingIntent, "Share app using"));
                        break;

                    case R.id.exit :
                        finish();
                        break;
                }
                return true;
            }
        } );
        //==========================================================================================
        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer( Gravity.LEFT );
            }
        } );
        //==========================================================================================

        Fragment_Manager fragment_manager=new Fragment_Manager( getSupportFragmentManager() );
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.addToBackStack( null );
//        transaction.commit();



        fragment_manager.AddFragment_Title( new Biography(),"Biography");
        fragment_manager.AddFragment_Title( new FIRSET_CAR(),"First Car" );
        fragment_manager.AddFragment_Title( new A_Class(),"A Class" );
        fragment_manager.AddFragment_Title( new C_CLass(),"C Class" );
        fragment_manager.AddFragment_Title( new CLK_Class(),"CLK Class" );
        fragment_manager.AddFragment_Title( new CLS_Class(),"CLS Class" );
        fragment_manager.AddFragment_Title( new E_Class(),"E Class" );
        fragment_manager.AddFragment_Title( new G_Class(),"G Class"  );
        fragment_manager.AddFragment_Title( new GL_Class(),"GL Class " );
        fragment_manager.AddFragment_Title( new S_Class(),"S Class" );
        fragment_manager.AddFragment_Title( new SLS_Class(),"SLS Class" );


        viewPager.setAdapter( fragment_manager );
        tabLayout.setupWithViewPager( viewPager );

    }

}
