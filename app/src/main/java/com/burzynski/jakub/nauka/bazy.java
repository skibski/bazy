package com.burzynski.jakub.nauka;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by student on 24.04.2017.
 */

public class bazy extends AppCompatActivity {
    Button read, add, clear;
    EditText imie, numer;
    TextView text;
    private static DBTelefon db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bazy);

        db = new DBTelefon(this);


        read = (Button)findViewById(R.id.button2);
        add = (Button)findViewById(R.id.button3);
        imie = (EditText)findViewById(R.id.editText2);
        numer = (EditText)findViewById(R.id.editText3);
        text = (TextView)findViewById(R.id.textView2);
        clear = (Button)findViewById(R.id.clear);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nazwa = imie.getText().toString();
                String numero = numer.getText().toString();

                db.addTelefon(new CTelefon(nazwa, numero));

                Log.d("Czytaj", "Zczytaj wszystkie alarmy");
                List<CTelefon> zosia = db.getAllTelephones();
                for (CTelefon z : zosia){
                    String log = "Id: " + z.get_id() + " ,Imie: " + z.getName() + " ,Numer: " + z.getTelefon();
                    Log.d("Logi: ", log);
                }

            }


        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteAll();
            }
        });
    }
}
