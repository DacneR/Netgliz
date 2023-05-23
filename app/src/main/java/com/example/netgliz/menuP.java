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
        elementos.add(new ListElement("Imperdonable","Nora Fingscheidt ('System Crasher') dirigía a Sandra Bullock (junto a Viola Davis, Vincent D'Onofrio y Jon Bernthal) como una mujer que en prisión por un crimen violento y que cumplió con su tiempo, pero que al salir se encuentra con una sociedad que juzga sus actos como imperdonables, literalmente.","Drama",R.drawable.imperdonable));
        elementos.add(new ListElement("El irlandès"," La película dura tres horas y media que tienen que verse del tirón, pero es una gozada mayúscula sobre el crimen organizado en Estados Unidos durante la época de la posguerra, vista a través de los ojos de un veterano de la Segunda Guerra Mundial.","Drama",R.drawable.irlandes));
        elementos.add(new ListElement("Troll","Dirigida por Roar Uthaug, la historia sigue a un trol gigante que se abre paso por Noruega y se dirige a la capital, Oslo, donde podría causar destrozos irreparables.","Fantasía",R.drawable.troll));
        elementos.add(new ListElement("Highway to hell","Señores, AC/DC es la banda preferida del que esto escribe. Tenía que elegir una, con Bon Scott, y aunque es el hit, la canción por la que todo dios les conoce (junto a Thunderstuck en el caso de los más advenedizos), es tan gloriosa, tan todo, que te tiene que gustar sí o sí.","Rock",R.drawable.hightohell));
        elementos.add(new ListElement("Freebird","A ver por dónde empiezo. Freebird es ese tema que cuando muera, quiero que suene en mi funeral. No hace falta decir más, ¿verdad? Y sí, tiene el mejor solo de guitarra multitudinario de la historia.","Rock",R.drawable.freebird));
        elementos.add(new ListElement("Whole lotta love","En serio, ¿necesitas que te digamos algo de este orgasmo hecho canción?","Rock",R.drawable.whoelll));
        elementos.add(new ListElement("En la sombra","Ryan Reynolds, Ben Hardy, Mélanie Laurent y Corey Hawkins. Daban vida a un grupo de millonarios que decide fingir su muerte para formar un grupo de vigilantes cuyo objetivo es dar caza a peligrosos criminales a lo largo del planeta.","Acción",R.drawable.enlasombra));
        elementos.add(new ListElement("Thunder road","Una de esas canciones que cuando la escuchas, y lees lo que dice, te hace pensar: \"Si yo hubiera escrito y compuesto algo así, me hubiera retirado en ese mismo momento\". Porque sí, amigos, no se puede hacer algo mejor.","Rock",R.drawable.thunderroda));


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