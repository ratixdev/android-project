package com.ucok.konversipanjang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner sp;
    private EditText edt_awal, edt_KM, edt_M, edt_DM, edt_CM, edt_MM;
    private String[] list={"km","m","dm","cm","mm"};
    Double awal, kilometer, meter, desimeter, sentimeter, milimeter;
    ArrayAdapter adapter;
    Button btnKonversi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=(Spinner) findViewById(R.id.spinner1);
        edt_awal=(EditText) findViewById(R.id.editText1);
        edt_KM=(EditText) findViewById(R.id.editTextKm);
        edt_M=(EditText) findViewById(R.id.editTextM);
        edt_DM=(EditText) findViewById(R.id.editTextDm);
        edt_CM=(EditText) findViewById(R.id.editTextCm);
        edt_MM=(EditText) findViewById(R.id.editTextMm);
        btnKonversi= (Button) findViewById(R.id.button1);

        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String satuan = String.valueOf(sp.getSelectedItemPosition());
                if (edt_awal.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Masukkan nilai awal, jika kosong maka nilai default adalah 0", Toast.LENGTH_LONG).show();
                    awal = 0.0;
                } else {
                    awal = Double.parseDouble(edt_awal.getText().toString());
                }
                if (satuan.equals("0")) {
                    kilometer = awal;
                    meter = 1000 * awal;
                    desimeter = 10000 * awal;
                    sentimeter = 100000 * awal;
                    milimeter = 1000000 * awal;

                    edt_KM.setText(String.valueOf(kilometer));
                    edt_M.setText(String.valueOf(meter));
                    edt_DM.setText(String.valueOf(desimeter));
                    edt_CM.setText(String.valueOf(sentimeter));
                    edt_MM.setText(String.valueOf(milimeter));
                } else if (satuan.equals("1")) {
                    kilometer = awal / 1000;
                    meter = awal;
                    desimeter = awal / 10000;
                    sentimeter = awal / 100000;
                    milimeter = awal / 1000000;

                    edt_KM.setText(String.valueOf(kilometer));
                    edt_M.setText(String.valueOf(meter));
                    edt_DM.setText(String.valueOf(desimeter));
                    edt_CM.setText(String.valueOf(sentimeter));
                    edt_MM.setText(String.valueOf(milimeter));
                } else if (satuan.equals("2")) {
                    kilometer = awal / 10000;
                    meter = awal / 10;
                    desimeter = awal;
                    sentimeter = awal * 10;
                    milimeter = awal * 100;

                    edt_KM.setText(String.valueOf(kilometer));
                    edt_M.setText(String.valueOf(meter));
                    edt_DM.setText(String.valueOf(desimeter));
                    edt_CM.setText(String.valueOf(sentimeter));
                    edt_MM.setText(String.valueOf(milimeter));
                } else if (satuan.equals("3")) {
                    kilometer = awal * 100000;
                    meter = awal / 100;
                    desimeter = awal / 10;
                    sentimeter = awal;
                    milimeter = awal * 10;

                    edt_KM.setText(String.valueOf(kilometer));
                    edt_M.setText(String.valueOf(meter));
                    edt_DM.setText(String.valueOf(desimeter));
                    edt_CM.setText(String.valueOf(sentimeter));
                    edt_MM.setText(String.valueOf(milimeter));
                }else if (satuan.equals("4")) {
                    kilometer = awal * 1000000;
                    meter = awal / 1000;
                    desimeter = awal / 100;
                    sentimeter = awal / 10;
                    milimeter = awal;

                    edt_KM.setText(String.valueOf(kilometer));
                    edt_M.setText(String.valueOf(meter));
                    edt_DM.setText(String.valueOf(desimeter));
                    edt_CM.setText(String.valueOf(sentimeter));
                    edt_MM.setText(String.valueOf(milimeter));
                }

            }

        });

    }
}