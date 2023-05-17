package com.example.netgliz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class menuP extends AppCompatActivity {

    ArrayList<ListElement> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_p);
    }

    @Override
    public  void onStart(){
        super.onStart();

        Log.i("DEPURACION","LLegue a menu" );
        try {
            elementos = new ArrayList<>();
            elementos.add(new ListElement("El hombre araña","el man araña pa","accion"));

            RecyclerView contenedor = findViewById(R.id.Contenedor);
            contenedor.setHasFixedSize(true);

            ListAdapter adaptador = new ListAdapter(elementos, this, new ListAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(ListElement item) {
                    moveToDescription(item);
                }
            });
            contenedor.setLayoutManager(new LinearLayoutManager(this));
            contenedor.setAdapter(adaptador);

        }catch (Exception e){
            Log.i("DEPURACION","Hubo un error en menu " + e);

        }







    }

    public void moveToDescription(ListElement item)
    {
        try {
            Intent in = new Intent(this,descripP.class);
            in.putExtra("ListElement", item);
            startActivity(in);
        }catch (Exception e){
            Log.i("DEPURACION","Error capturado en movetodescription "+e);
        }

    }
}