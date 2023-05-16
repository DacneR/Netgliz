package com.example.netgliz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button REGISTRAR, INICIAR;

    EditText USUARIO, PIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        REGISTRAR = findViewById(R.id.btnRegistrar);
        INICIAR = findViewById(R.id.btnLoguear);

        USUARIO = findViewById(R.id.Txtusuario);
        PIN = findViewById(R.id.Txtpin);
    }
    public void  onStart(){
        super.onStart();

        REGISTRAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla(v);
            }
        });

        INICIAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarU(v);
            }
        });
    }

    public void pasarPantalla(View view){
        Intent P = new Intent(this, registrar.class);
        startActivity(P);
    }

    public void consultarU(View view) {
        int U = 0, P = 0;
        try {
            U = Integer.parseInt(USUARIO.getText().toString());
            P = Integer.parseInt(PIN.getText().toString());
        } catch (Exception e) {

        }


        if (U != 0 && P > 1000) {
            Log.i("DEPURACION", "Estoy dentro del si");

            AdminBD admin = new AdminBD(this, "BD", null, 1);
            SQLiteDatabase BD = admin.getWritableDatabase();

            Cursor row = BD.rawQuery("Select cedula, usuario, pin from usuarios where usuario=" + U + " and pin=" + P, null);
            Log.i("DEPURACION", "Estoy hay en row" + row);

            String cedula, usuario, pin;
            if (row.moveToFirst()) {
                cedula = row.getString(0);
                usuario = row.getString(1);
                pin = row.getString(2);

                Intent in = new Intent(this, segunP.class);

                in.putExtra("usuario", usuario);
                in.putExtra("cedula", cedula);
                in.putExtra("pin", pin);
                BD.close();

                startActivity(in);

                USUARIO.setText("");
                PIN.setText("");


            } else {
                Toast.makeText(this, "No se encuentra el usuario", Toast.LENGTH_LONG).show();
            }


        } else {
            Toast.makeText(this, "Usuario y/o contraseña incorrecto/s o vacío ", Toast.LENGTH_LONG).show();
        }


    }
}