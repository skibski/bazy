package com.burzynski.jakub.nauka;

/**
 * Created by student on 24.04.2017.
 */

public class CTelefon {

    int _id;
    String _name;
    String _telefon;

    public CTelefon() {
    }

    public CTelefon(int id, String telefon, String name){
        this._id = id;
        this._name = name;
        this._telefon = telefon;
    }

    public CTelefon(String name, String telefon){
        this._name = name;
        this._telefon = telefon;
    }

    public CTelefon(String name){
        this._name = name;
    }

   public int get_id(){
        return this._id;
    }

    public void set_id(int id){
        this._id = id;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name)
    {
        this._name = name;
    }

    public String getTelefon(){
        return this._telefon;
    }

    public void setTelefon(String telefon){
        this._telefon = telefon;
    }
}
