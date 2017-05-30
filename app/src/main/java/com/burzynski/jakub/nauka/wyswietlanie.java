package com.burzynski.jakub.nauka;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by student on 25.04.2017.
 */

public class wyswietlanie extends AppCompatActivity {
    TelefonRow telefon_data[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wypisywanie);
    }
}
