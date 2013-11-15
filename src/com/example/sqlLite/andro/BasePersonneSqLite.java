package com.example.sqlLite.andro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BasePersonneSqLite extends SQLiteOpenHelper{
	

	
	private static final String TABLE_PERSONNE = "table_personne";
	private static final String COL_ID = "id";
	private static final String COL_NOM = "nom";
	private static final String COL_PRENOM = "prenom";
	private static final String COL_USER = "user";
	private static final String COL_PSW = "psw";
	private static final String COL_FORMATION = "formation";
	private static final String COL_EMP_TEMPS= "emp_temps";
 
	private static final String CREATE_BDD = "CREATE TABLE " + TABLE_PERSONNE + " ("
	+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	+ COL_NOM + " TEXT NOT NULL, "
	+ COL_PRENOM + " TEXT NOT NULL, " 
	+ COL_USER + " TEXT NOT NULL, "
	+ COL_PSW + " TEXT NOT NULL, "
	+ COL_FORMATION +  " TEXT NOT NULL, "
	+ COL_EMP_TEMPS + " TEXT NOT NULL );";
	

	public BasePersonneSqLite(Context context, String name, CursorFactory factory, int version) 
	{
		super(context, name, factory, version);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db)
	{

		db.execSQL(CREATE_BDD);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE " + TABLE_PERSONNE + ";");
		onCreate(db);
	}
 

}
