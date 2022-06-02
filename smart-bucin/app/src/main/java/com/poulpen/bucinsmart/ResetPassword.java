package com.poulpen.bucinsmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {
    EditText etEmail;
    Button btnReset, btnBack;
    FirebaseAuth firebaseAuth;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_reset_password);

        etEmail = findViewById(R.id.etResetEmail);
        btnReset = findViewById(R.id.btnReset);
        firebaseAuth = FirebaseAuth.getInstance();
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();

                if (TextUtils.isEmpty(email)){
                    etEmail.setError("Email gak boleh kosong yaa");
                    etEmail.requestFocus();
                } else {

                    firebaseAuth.sendPasswordResetEmail(etEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ResetPassword.this, "Email ganti sandi terkirim!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(ResetPassword.this,
                                        task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}

