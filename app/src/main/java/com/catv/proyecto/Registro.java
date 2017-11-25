package com.catv.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {

    private static final String TAG = "Registro";
    private FirebaseAuth auth;
    EditText correo, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        auth = FirebaseAuth.getInstance();

        correo = (EditText) findViewById(R.id.editTextCorreo_R);
        contraseña = (EditText) findViewById(R.id.editTextContraseña_R);


    }


    public boolean Registrar() {

        String email = correo.getText().toString().trim();
        String password = contraseña.getText().toString().trim();

        boolean flag = false;

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            flag = false;

        } else {
            flag = true;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            flag = false;

        } else {
            flag = true;
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            flag = false;
        } else {
            flag = true;
        }


        return flag;
    }

    public void Agregar(View view) {

        Log.d(TAG, "Agregar: " + Registrar());
        if (Registrar()) {
            String email = correo.getText().toString().trim();
            String password = contraseña.getText().toString().trim();
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(Registro.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(Registro.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Toast.makeText(Registro.this, "Authentication failed." + task.getException(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Registro.this, Login.class));
                                finish();
                            }
                        }
                    });
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


}
