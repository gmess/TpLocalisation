package com.example.sqlLite.andro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;


public class BaseSalleInfosSqLite extends SQLiteOpenHelper
{


	private static final String TABLE_SALLE = "salle";
	private static final String COL_ID = "ID";
	private static final String COL_NOM_SALLE = "nom_salle";
	private static final String COL_ID_BARRE = "id_barre";
	private static final String COL_ETAGE = "etage";
	private static final String COL_BATIMENT = "batiment";

	private static final String CREATE_BDD = "CREATE TABLE " + TABLE_SALLE + " ("
	+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	+ COL_NOM_SALLE + " TEXT NOT NULL, "
	+ COL_ID_BARRE+ " TEXT NOT NULL, "
	+ COL_ETAGE + " TEXT NOT NULL, "
	+ COL_BATIMENT +  " TEXT NOT NULL);" ;
	

	public BaseSalleInfosSqLite(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_BDD);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE " + TABLE_SALLE + ";");
		onCreate(db);
	}
	

 



}//fin classe
