package com.example.netgliz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class menuP extends AppCompatActivity {

    List<ListElement> elementos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_p);

        elementos = new ArrayList<>();
        elementos.add(new ListElement("El hombre araña","el man araña pa","accion",R.drawable.img_uno));
        elementos.add(new ListElement("deluxe","un hombre acechando la ciudad","accion",R.drawable.img_dos));
        elementos.add(new ListElement("El hombre x","el man x pa","accion",R.drawable.img_tres));
        elementos.add(new ListElement("El hombre x","el man x pa","accion",R.drawable.img_cuatro));
        elementos.add(new ListElement("El hombre x","el man x pa","accion",R.drawable.img_cinco));
        elementos.add(new ListElement("El hombre x","el man x pa","accion",R.drawable.img_seis));

        RecyclerView contenedor = findViewById(R.id.Contenedor);
        contenedor.setHasFixedSize(true);

        ListAdapter adaptador = new ListAdapter(elementos, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                //moveToDescription(item);
            }
        });
        contenedor.setLayoutManager(new LinearLayoutManager(this));
        contenedor.setAdapter(adaptador);
    }

    /*public void moveToDescription(ListElement item)
    {
        try {
            Intent in = new Intent(this,descripP.class);
            in.putExtra("ListElement", item);
            startActivity(in);
        }catch (Exception e){
            Log.i("DEPURACION","Error capturado en movetodescription "+e);
        }

    }*/

}