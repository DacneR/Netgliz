package com.net.netgliz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.netgliz.R;
import com.example.netgliz.menuP;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText USUARIO, PIN;
    Button INICIAR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        USUARIO = findViewById(R.id.Txtusuario);
        PIN = findViewById(R.id.Txtpin);
        INICIAR = findViewById(R.id.btnLoguear);
    }

    @Override
    public void onStart() {
        super.onStart();

        INICIAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarU(view);
            }
        });

        insertar();
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

                Intent in = new Intent(this, menuP.class);

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

    public void insertar() {
        try{
            AdminBD admin = new AdminBD(this, "BD", null, 1);
            SQLiteDatabase BD = admin.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("cedula", "1017922915");
            registro.put("usuario", "777");
            registro.put("pin", "9999");
            BD.insert("usuarios", null, registro);
            BD.close();


            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();
        }catch (Exception e){

        }


    }
}


