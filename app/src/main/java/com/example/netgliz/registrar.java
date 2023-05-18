package com.example.netgliz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrar extends AppCompatActivity {

    EditText CC, U, P;

    Button REGISTRASE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        CC = findViewById(R.id.Txtced);
        U = findViewById(R.id.Txtusuario);
        P = findViewById(R.id.Txtpin);

        REGISTRASE = findViewById(R.id.btnRegistrar);
    }

    public void onStart(){
        super.onStart();
        REGISTRASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });
    }

    public void insertar(){
        AdminBD admin = new AdminBD(this,"BD", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        int cedula, usuario, pin;
        cedula = Integer.parseInt(CC.getText().toString());
        usuario = Integer.parseInt(U.getText().toString());
        pin = Integer.parseInt(P.getText().toString());

        if(cedula>100000 && usuario!=0 && pin>1000)
        {
            ContentValues registro = new ContentValues();
            registro.put("cedula",cedula);
            registro.put("usuario",usuario);
            registro.put("pin",pin);
            BD.insert("usuarios", null, registro);
            BD.close();

            CC.setText("");
            U.setText("");
            P.setText("");


            Toast.makeText(this, "Registro exitoso",Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this, "Complete los campos vacíos",Toast.LENGTH_LONG).show();
        }


    }
}