package com.example.staff;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static String DATABASE = "database.db";
    public static String TABLE = "MUST";
    public static String FNAME = "fname";
    public static String SNAME = "sname";
    public static String EMAIL = "email";
    public static String TEL = "tel";
    public static String ID = "id";
    public static String STATION = "station";

    String br;

    public DatabaseHelper(Context context) {

        super( context, DATABASE, null, 1 );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        br = "CREATE TABLE " + TABLE + "(" + FNAME + " Text, " + SNAME + " Text, " + EMAIL + " Text, "+ TEL +" Text ,"+ ID +" Text, "+ STATION +" Text   );";
        db.execSQL( br );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE + " ;" );
    }


    public void insertdata(String sname, String fname, String email, String tel, String id, String station) {
//        System.out.print( "Hello " + br );
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put( FNAME, fname );
        contentValues.put( SNAME, sname );
        contentValues.put( EMAIL, email );
        contentValues.put( TEL, tel );
        contentValues.put( ID, id );
        contentValues.put( STATION, station);
        db.insert( TABLE, null, contentValues );


    }

    public List<NoteHelper> getdata() {
        // DataModel dataModel = new DataModel();
        List<NoteHelper> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery( "select * from " + TABLE + " ;", null );
        StringBuffer stringBuffer = new StringBuffer();
        NoteHelper dataModel = null;
        while (cursor.moveToNext()) {
            dataModel = new NoteHelper();
            String fname = cursor.getString( cursor.getColumnIndexOrThrow( "fname" ) );
            String sname = cursor.getString( cursor.getColumnIndexOrThrow( "sname" ) );
            String email = cursor.getString( cursor.getColumnIndexOrThrow( "email" ) );
            String tel = cursor.getString( cursor.getColumnIndexOrThrow( "tel" ) );
            String id = cursor.getString( cursor.getColumnIndexOrThrow( "id" ) );
            String station = cursor.getString( cursor.getColumnIndexOrThrow( "station" ) );
            dataModel.setFname( fname );
            dataModel.setSname( sname );
            dataModel.setEmail( email );
            dataModel.setTel( tel );
            dataModel.setId( id );
            dataModel.setStation( station );
            stringBuffer.append( dataModel );
            // stringBuffer.append(dataModel);
            data.add( dataModel );
        }

        for (NoteHelper mo : data) {

//            Log.i( "Helle", "" + mo.getNoteBoddy() );
        }

        //

        return data;
    }

}