package com.example.mercedes_benz;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by KARIZsystem on 20/04/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context _Context;
    private List<DataModel> arrayList;



    public RecyclerViewAdapter(Context _Context, List<DataModel> arrayList) {
        this._Context = _Context;
        this.arrayList = arrayList;
    }

    public RecyclerViewAdapter(MainActivity mainActivity) {
    }


    //==============================================================================================
    public RecyclerViewAdapter(List<DataModel> list, Context context) {
    }

    public RecyclerViewAdapter() {

    }


    //==============================================================================================

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from( _Context ).inflate( R.layout.viewpager_design,parent,false );

        return new MyViewHolder( view );
    }

    //==============================================================================================

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final DataModel data_model=arrayList.get( position );

       // Log.d( "meysaam" ,data_model.getCarName() +"");
        Glide.with( _Context ).load( data_model.getImgCar() ).into( holder.carImg );
        holder.txtcarName.setText( data_model.getCarName() );
        holder.txtcarDescription.setText( data_model.getCarDescription() );

        //============about save image in gallery=============
//        holder.BtnSave.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final AlertDialog builder = new AlertDialog.Builder( _Context ).create();
//                builder.setTitle( "save..." );
//                builder.setMessage( "Are you sure save this file ? " );
//                builder.setButton( " yes ", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        FileOutputStream fileOutputStream = null ;
//                        File file = getDisc() ;
//                        if(!file.exists() && !file.mkdir()){
//                            Snackbar.make( holder.BtnSave,"Dont save!!",Snackbar.LENGTH_SHORT ).show();
//                        }
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(  );
//                        String date = simpleDateFormat.format( new Date(  ) );
//                        String name = "Image" + date + ".gpg";
//                        String fileName = file.getAbsolutePath()+ "/" +name;
//
//                        File newFile = new File( fileName );
//
//                        try {
//                            fileOutputStream = new FileOutputStream( newFile);
//                            Bitmap bitmap = viewBitmap( holder.carImg,holder.carImg.getWidth(),holder.carImg.getHeight() );
//                            bitmap.compress( Bitmap.CompressFormat.JPEG,100,fileOutputStream );
//                            Snackbar.make( holder.BtnSave,"Save is successfull ",Snackbar.LENGTH_SHORT ).show();
//                            fileOutputStream.flush();
//                            fileOutputStream.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                        refreshing( newFile );
//                        builder.show();
//
//                    }
//                } );

 //           }
//        } );
        //==========================================================================================
        holder.Btnwallpaper.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperManager wallpaperManager=WallpaperManager.getInstance( _Context );
                try {
                    wallpaperManager.setBitmap( viewBitmap( holder.carImg,holder.carImg.getWidth(),holder.carImg.getHeight() ) );
                }catch (IOException e){
                    e.printStackTrace();
                }
                Snackbar.make( view,"Set The Wallpaper.",Snackbar.LENGTH_LONG ).show();
            }
        } );

        holder.BtnShare.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap=viewBitmap( holder.carImg,holder.carImg.getWidth(),holder.carImg.getHeight() );
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

                intent.putExtra( Intent.EXTRA_STREAM,Uri.parse( " .jpg" ) );
                _Context.startActivity( Intent.createChooser( intent,"Share Image" ) );


            }
        } );


        //==========================================================================================

        holder.cardView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent( _Context,ScrollingActivity.class );

                intent.putExtra( "carName",arrayList.get( holder.getAdapterPosition() ).getCarName() );
                intent.putExtra( "carDescription",arrayList.get( holder.getAdapterPosition() ).getCarDescription() );
                intent.putExtra( "carImg",arrayList.get( holder.getAdapterPosition() ).getImgCar() );
                intent.putExtra( "Share",arrayList.get( holder.getAdapterPosition() ).getBtnShare() );
                _Context.startActivity( intent );

            }
        } );

    }

    @Override
    public int getItemCount() {
        return arrayList==null ? 0 : arrayList.size();

//        if(arrayList == null)
//        {
//            return 0;
//        }
//        else
//        {
//            return arrayList.size();
//        }
    }


    //==============================================================================================

    public static class MyViewHolder extends RecyclerView.ViewHolder{


    public ImageButton BtnShare,Btnwallpaper;
    public RecyclerView recyclerView;
    public TextView txtcarName,txtcarDescription;
    public ImageView carImg;
    public CardView cardView;
    public LinearLayout linearLayout;

    public MyViewHolder(View itemView) {
        super( itemView );



        recyclerView=(RecyclerView) itemView.findViewById( R.id.recycler1 );
        Btnwallpaper=(ImageButton) itemView.findViewById( R.id.wallpaper );
        BtnShare=(ImageButton) itemView.findViewById( R.id.share );
        txtcarDescription=(TextView) itemView.findViewById( R.id.textdescription );
        txtcarName=(TextView) itemView.findViewById( R.id.textName );
        carImg=(ImageView) itemView.findViewById( R.id.imgcar1 );
        cardView=(CardView) itemView.findViewById( R.id.card1 );
        linearLayout=(LinearLayout) itemView.findViewById( R.id.linear );
    }
}
    //==============================================================================================


    public static Bitmap viewBitmap(View view,int width,int heigth){
        Bitmap bitmap=Bitmap.createBitmap( width,heigth,Bitmap.Config.ARGB_8888 );
        Canvas canvas=new Canvas( bitmap );
        view.draw( canvas );
        return bitmap;
    }

    //for save the picture

    public void refreshing(File file){
        Intent intent=new Intent( Intent.ACTION_MEDIA_SCANNER_SCAN_FILE );
        intent.setData( Uri.fromFile( file ) );
        _Context.sendBroadcast( intent );
    }

    public File getDisc(){
        File file= Environment.getExternalStoragePublicDirectory( Environment.DIRECTORY_DCIM );
        return new File( file,"photo" );
    }



}

