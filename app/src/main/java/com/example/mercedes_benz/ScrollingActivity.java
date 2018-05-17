package com.example.mercedes_benz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_scrolling );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        toolbar.setTitle( getIntent().getStringExtra( "carName" ) );
        setSupportActionBar( toolbar );

        final TextView textView=(TextView) findViewById( R.id.Description );
        textView.setText( getIntent().getStringExtra( "carDescription" ) );

        final ImageView imageView=(ImageView) findViewById( R.id.carImg1 );
        int resId = getIntent().getIntExtra( "carImg",0);
        imageView.setImageResource( getIntent().getIntExtra( "carImg",resId ) );

        final FloatingActionButton fabShare=(FloatingActionButton) findViewById( R.id.fab );
        fabShare.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bitmap bitmap=viewBitmap( imageView,imageView.getWidth(),imageView.getHeight() );
                Intent intent=new Intent( Intent.ACTION_SEND );
                intent.setType( "Image/jpeg" );
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(  );
                bitmap.compress( Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream );

                File file=new File( Environment.getExternalStorageDirectory()+File.separator+".jpg" );
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream( file );
                    fileOutputStream.write( byteArrayOutputStream.toByteArray() );
                }catch (IOException e){
                    e.printStackTrace();
                }

                intent.putExtra( Intent.EXTRA_STREAM, Uri.parse( "/.jpg" ) );
                startActivity( Intent.createChooser( intent,"Share Image" ) );
            }
        } );

    }

    public static Bitmap viewBitmap(View view,int width,int heigth){
        Bitmap bitmap=Bitmap.createBitmap( width,heigth,Bitmap.Config.ARGB_8888 );
        Canvas canvas=new Canvas( bitmap );
        view.draw( canvas );
        return bitmap;
    }
}
