package com.burzynski.jakub.nauka;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by student on 24.04.2017.
 */

public class bazy extends AppCompatActivity {
    Button read, add;
    EditText imie, numer;
    TextView text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bazy);
        read = (Button)findViewById(R.id.button2);
        add = (Button)findViewById(R.id.button3);
        imie = (EditText)findViewById(R.id.editText2);
        numer = (EditText)findViewById(R.id.editText3);
        text = (TextView)findViewById(R.id.textView2);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(DBTelefon);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }

        });
    }
}
