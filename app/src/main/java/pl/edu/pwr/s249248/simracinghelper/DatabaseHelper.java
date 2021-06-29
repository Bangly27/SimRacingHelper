package pl.edu.pwr.s249248.simracinghelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SETUPS_TABLE = "SETUPS_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_SETUP_NAME = "SETUP_NAME";
    public static final String COLUMN_SETUP_AERODYNAMICS = "SETUP_AERODYNAMICS";
    public static final String COLUMN_SETUP_TRANSMISSION = "SETUP_TRANSMISSION";
    public static final String COLUMN_SETUP_SUSPENSION = "SETUP_SUSPENSION";
    public static final String COLUMN_SETUP_SUSPENSION_GEOMETRY = COLUMN_SETUP_SUSPENSION + "_GEOMETRY";
    public static final String COLUMN_SETUP_BRAKES = "SETUP_BRAKES";
    public static final String COLUMN_SETUP_TYRES = "SETUP_TYRES";
    public static final String COLUMN_SETUP_WET = "SETUP_WET";


    public DatabaseHelper(@Nullable Context context) {
        super(context, "setups.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + SETUPS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SETUP_NAME + " TEXT, " + COLUMN_SETUP_AERODYNAMICS + " TEXT, " + COLUMN_SETUP_TRANSMISSION + " TEXT, " + COLUMN_SETUP_SUSPENSION_GEOMETRY + " TEXT, " + COLUMN_SETUP_SUSPENSION + " TEXT, " + COLUMN_SETUP_BRAKES + " TEXT, " + COLUMN_SETUP_TYRES + " TEXT, " + COLUMN_SETUP_WET + " BOOL)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(SetupModel setupModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        
        cv.put(COLUMN_SETUP_NAME, setupModel.getTrack_name());
        cv.put(COLUMN_SETUP_AERODYNAMICS, setupModel.getAero());
        cv.put(COLUMN_SETUP_TRANSMISSION, setupModel.getTransmission());
        cv.put(COLUMN_SETUP_SUSPENSION, setupModel.getSuspension());
        cv.put(COLUMN_SETUP_SUSPENSION_GEOMETRY, setupModel.getGeometry());
        cv.put(COLUMN_SETUP_BRAKES, setupModel.getBrakes());
        cv.put(COLUMN_SETUP_TYRES, setupModel.getTyres());
        cv.put(COLUMN_SETUP_WET, setupModel.isAreWetTyresOn());

        long insert = db.insert(SETUPS_TABLE, null, cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean deleteOne(SetupModel setupModel){
        SQLiteDatabase db = this.getWritableDatabase();

        String queryString = "DELETE FROM " + SETUPS_TABLE + " WHERE " + COLUMN_ID + "=" + setupModel.getId();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }
    }

    public List<SetupModel> selectAll(){
        List<SetupModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + SETUPS_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do {
                int setup_id=cursor.getInt(0);
                String setup_name=cursor.getString(1);
                String aero=cursor.getString(2);
                String transmission=cursor.getString(3);
                String suspension=cursor.getString(4);
                String geometry=cursor.getString(5);
                String brakes=cursor.getString(6);
                String tyres=cursor.getString(7);
                boolean wets =cursor.getInt(8) == 1? true: false;

                SetupModel setupModel = new SetupModel(setup_id, setup_name, aero, transmission, suspension, geometry, brakes, tyres, wets);
                returnList.add(setupModel);

            } while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
        db.close();
        return returnList;
    }

    public List<SetupModel> returnNames(){
        List<SetupModel> returnList2 = new ArrayList<>();

        String queryString = "SELECT * FROM " + SETUPS_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToNext()){
            do {
                String setup_name=cursor.getString(1);

                SetupModel setupModel = new SetupModel(setup_name);
                returnList2.add(setupModel);

            } while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
        db.close();
        return returnList2;
    }
}