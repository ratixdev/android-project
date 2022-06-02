package com.ratix.konversisuhu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Konversi extends AppCompatActivity {

    private Spinner sp;
    private EditText edt_awal, edt_C, edt_R, edt_F, edt_K, edt_Ra;
    private String[] list={"C","R","F","K","Ra"};
    Double awal, celcius, reamur, fahrenheit, kelvin, rankine;
    ArrayAdapter adapter;
    Button btnKonversi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi);
        sp=(Spinner) findViewById(R.id.spinner1);
        edt_awal=(EditText) findViewById(R.id.editText1);
        edt_C=(EditText) findViewById(R.id.editTextCelcius);
        edt_R=(EditText) findViewById(R.id.editTextReamur);
        edt_F=(EditText) findViewById(R.id.editTextFahrenheit);
        edt_K=(EditText) findViewById(R.id.editTextKelvin);
        edt_Ra=(EditText) findViewById(R.id.editTextRankine);
        btnKonversi= (Button) findViewById(R.id.button1);

        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String satuan = String.valueOf(sp.getSelectedItemPosition());
                if (edt_awal.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Masukkan suhu awal, jika kosong maka nilai default adalah 0", Toast.LENGTH_LONG).show();
                    awal = 0.0;
                } else {
                    awal = Double.parseDouble(edt_awal.getText().toString());
                }
                if (satuan.equals("0")) {
                    celcius = awal;
                    reamur = 0.8 * awal;
                    fahrenheit = (1.8 * awal) + 32;
                    kelvin = awal + 273;
                    rankine = (awal + 273.15)*1.8;

                    edt_C.setText(String.valueOf(celcius));
                    edt_R.setText(String.valueOf(reamur));
                    edt_F.setText(String.valueOf(fahrenheit));
                    edt_K.setText(String.valueOf(kelvin));
                    edt_Ra.setText(String.valueOf(rankine));
                } else if (satuan.equals("1")) {
                    celcius = 1.25 * awal;
                    reamur = awal;
                    fahrenheit = (2.25 * awal) + 32;
                    kelvin = celcius + 273;
                    rankine = (awal * 2.25) + 491.67;

                    edt_C.setText(String.valueOf(celcius));
                    edt_R.setText(String.valueOf(reamur));
                    edt_F.setText(String.valueOf(fahrenheit));
                    edt_K.setText(String.valueOf(kelvin));
                    edt_Ra.setText(String.valueOf(rankine));
                } else if (satuan.equals("2")) {
                    celcius = 0.55555 * (awal - 32);
                    reamur = 0.44444 * (awal - 32);
                    fahrenheit = awal;
                    kelvin = celcius + 273;
                    rankine = awal + 459.67;

                    edt_C.setText(String.valueOf(celcius));
                    edt_R.setText(String.valueOf(reamur));
                    edt_F.setText(String.valueOf(fahrenheit));
                    edt_K.setText(String.valueOf(kelvin));
                    edt_Ra.setText(String.valueOf(rankine));
                } else if (satuan.equals("3")) {
                    celcius = awal - 273;
                    reamur = 0.8 * (awal - 273);
                    fahrenheit = (1.8 * (awal - 273)) + 32;
                    kelvin = awal;
                    rankine = awal * 1.8;

                    edt_C.setText(String.valueOf(celcius));
                    edt_R.setText(String.valueOf(reamur));
                    edt_F.setText(String.valueOf(fahrenheit));
                    edt_K.setText(String.valueOf(kelvin));
                    edt_Ra.setText(String.valueOf(rankine));
                }else if (satuan.equals("4")) {
                    celcius = (awal - 491.67)*0.56;
                    reamur = (awal / 1.8 + 273.15) * 0.8;
                    fahrenheit = awal - 459.67;
                    kelvin = awal - 0.56;
                    rankine = awal;

                    edt_C.setText(String.valueOf(celcius));
                    edt_R.setText(String.valueOf(reamur));
                    edt_F.setText(String.valueOf(fahrenheit));
                    edt_K.setText(String.valueOf(kelvin));
                    edt_Ra.setText(String.valueOf(rankine));
                }

            }

        });

    }
}