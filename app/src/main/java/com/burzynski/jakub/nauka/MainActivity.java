package com.burzynski.jakub.nauka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int liczba1 = 1;
    int liczba2 = 1;
    int wynik = 0;
    double licz1 = 1.5689;
    double licz2 = 21.212132;
    double wyn;
    double wyn1;
    boolean falsz = false;
    boolean prawda = true;
    int warunek = 0;
    int a;
    int i;
    Button b1, b2;
    EditText imie, numer;
    TextView tekst;
    List<String> tablica;
    String teksici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablica = new ArrayList<String>();
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.bazy);
        imie = (EditText)findViewById(R.id.editText);
//        numer = (EditText)findViewById(R.id.editText2);
        tekst = (TextView)findViewById(R.id.textView);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), bazy.class);
                startActivity(i);
            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teksici = imie.getText().toString() + "\n";
                tablica.add(teksici);


                tekst.setText(String.valueOf(tablica) + System.getProperty("Live.separator"));

//                for (i=0; i<tablica.size(); i++) {
//                    tekst.setText(String.valueOf(tablica.get(i)));
//                }

            }
        });


//        tablica = new String[]{"Kasia", "Magda", "Zosia", "Andrzej", "Beata Szydło"};
//        for (i=0; i<tablica.length; i++) {
//            Log.d("Tablica :", tablica[4]);
//        }
//        Log.d("Tablica", tablica[0]);


//        for (int i=0; i<10; i++) {
//            if (warunek == 0) {
//                Log.d("Kobieta", "kurde");
//                warunek = 1;
//            } else {
//                Log.d("Mężczyzna", "Bo tak");
//                warunek = 0;
//            }
//            Log.d("//////////////////", "//////////////////////");
//            Log.d("FUNKCJA DODAWANIA", String.valueOf(i));
//        }


    }
}
