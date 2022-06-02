package com.poulpen.bucinsmart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnLogout;
    FirebaseAuth mAuth;
    TextView txt, txtWelcome, txtAktivitas;
    Button btn, btnRandom;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Keluar aplikasi?");
        alertDialogBuilder
                .setMessage("Klik Iya untuk keluar!")
                .setCancelable(false)
                .setPositiveButton("Iya",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("Nanti", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();

        btnLogout.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, Login.class));
        });

        //define for access
        txt = findViewById(R.id.textRandom);
        btn = findViewById(R.id.btnRandom);
        btnRandom = findViewById(R.id.btnAktivitas);
        txtWelcome = findViewById(R.id.textView);
        txtAktivitas = findViewById(R.id.textAktivitas);

        //action to perform when clicked on the button
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n") //to remove the warning
            @Override
            public void onClick(View view) {
                txtWelcome.setVisibility(View.GONE);
                String[] makanan = new String[] {
                        "Bakso" ,"Nasi Goreng" ,"Sate Ayam" ,"Gado-gado" , "Rendang" ,"Gulai ikan" ,"Soto" ,
                        "Nasi Uduk" ,"Nasi Padang" ,"Sop Buntut" , "Indomie" ,"Ayam Goreng" ,"Gudeg" , "Bakmi" ,"Rawon" ,"Rujak Cingur" , "Nasi Pecel" ,"Pecel Lele" ,"Bubur Ayam" ,"Pepes Ikan" , "Gulai" ,"Pempek" ,"Sayur Asem" ,"Lalapan" , "Tahu Gejrot" ,"Bulgogi" ,"Ketoprak" ,"Lontong" , "Batagor" ,"Nasi Campur"
                };
                String[] minuman = new String[] {
                        "Es Teh" ,"Teh Hangat" ,"Es jeruk" ,"Jeruk Hangat" ,
                        "Air putih" ,"Air es", "Susu soda","Boba","Kuku Bima","Extra joss","Es kelapa","Es Cincau",
                        "Pop ice"
                };
                Random r = new Random();
                int idx = r.nextInt(makanan.length);
                int ids = r.nextInt(minuman.length);
                txt.setText("Hari ini kalian makan: " + makanan[idx] + " dan Minumnya: " + minuman[ids]);
            }
        });

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n") //to remove the warning
            @Override
            public void onClick(View view) {
                txtWelcome.setVisibility(View.GONE);
                String[] aktivitas = new String[] {
                        "Nonton Bioskop" ,"Jalan ke taman" ,"Main kelerang" ,"Ngopi di warkop",
                        "Keliling kota" ,"Baca buku di perpustakaan" ,"Nonton Youtube" ,"Nge Vlog" ,
                        "Nyanyi" ,"Main Tiktok" ,"Berenang" ,"Joging bareng" ,"Berkebun" ,"Memasak" ,"Piknik" ,
                        "Jalan-jalan ke lapmer" ,"jalan ke kebun binatang" ,"Melamar pekerjaan" ,"Berjualan biar dapat uang" ,
                        "Push rank ML" ,"Push rank pubg" ,"Main game dota" ,
                };

                Random r = new Random();
                int xdi = r.nextInt(aktivitas.length);
                txtAktivitas.setText("Habis makan kalian bisa coba: " + aktivitas[xdi]);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.aboutApps){
            startActivity(new Intent(this, AboutApps.class));
        } else if (item.getItemId() == R.id.aboutme) {
            startActivity(new Intent(this, About.class));
        } else if (item.getItemId() == R.id.lainnya) {
            startActivity(new Intent(this, Lainnya.class));
        }
        return true;
    }

}