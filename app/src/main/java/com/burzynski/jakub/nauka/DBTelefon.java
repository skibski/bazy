package com.burzynski.jakub.nauka;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by mgr inż. Albert Kowalewski on 07.04.2017.
 * COMPANY : 2Strefa Albert Kowalewski
 * ADDRESS : 16-070 Choroszcz, ul. Zastawie I 11, POLAND
 * MOBILE : +48 782 500 210, PHONE : +48 85 719 34 71
 * WWW : http://2strefa.pl
 * E-MAIL : biuro@2strefa.pl
 */

public class DBTelefon extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "telefonManager";

    // Contacts table name
    private static final String TABLE_TELEFON = "ksiazka";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_IMIE = "imie";
    private static final String KEY_TELEFON = "nazwisko";
    public static int klasyk;
    public static int powter;

    public DBTelefon(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TELEFON + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_IMIE + " TEXT, " + KEY_TELEFON + "TEXT, " + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TELEFON);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addTelefon(CTelefon contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMIE, contact.getName());
        values.put(KEY_TELEFON, contact.getTelefon());


        // Inserting Row
        db.insert(TABLE_TELEFON, null, values);
//        db.close(); // Closing database connection
    }

    // Getting single contact
    CTelefon getAlarm(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TELEFON, new String[] { KEY_ID,
                        KEY_IMIE, KEY_TELEFON}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        CTelefon contact = new CTelefon(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;

    }

    // Getting All Contacts
    public List<CTelefon> getAllTelephones() {
        List<CTelefon> contactList = new ArrayList<CTelefon>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TELEFON;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CTelefon contact = new CTelefon();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setTelefon(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    // Updating single contact
    public int updateContact(CTelefon contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMIE, contact.getName());
        values.put(KEY_TELEFON, contact.getTelefon());
        // updating row
        return db.update(TABLE_TELEFON, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.get_id()) });
    }

    // Deleting single contact
    public void deleteAlarm(CTelefon contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TELEFON, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.get_id()) });
        db.close();
    }

    public void deleteAll()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(TABLE_TELEFON, null, null);

    }

    // Getting contacts Count
    public int getAlarmCount() {
        String countQuery = "SELECT  * FROM " + TABLE_TELEFON;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();

        // return count
        return cursor.getCount();
    }

    public int getLastAlarmID() {
        int lastId = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String queryty = "SELECT "+ KEY_ID +" FROM "+ TABLE_TELEFON + " order by " + KEY_ID + " DESC limit 1";
        Cursor c = db.rawQuery(queryty, null);
        if (c != null && c.moveToFirst()) {
            lastId = (int) c.getLong(0); //The 0 is the column index, we only have 1 column, so the index is 0
            c.close();
        }
        return lastId;
    }

}