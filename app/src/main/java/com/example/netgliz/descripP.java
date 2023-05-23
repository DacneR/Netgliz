package com.example.netgliz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class descripP extends AppCompatActivity {

    public ImageView iconImg;
    public TextView TITULO, descrip, genero;
    public ListElement Item;

    public Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descrip_p);
        iconImg = findViewById(R.id.iconoImageView);
        TITULO = findViewById(R.id.nameTextView);
        descrip = findViewById(R.id.descripTextView);
        genero = findViewById(R.id.generoTextView);

        buscar= findViewById(R.id.btnSearch);

        Item = (ListElement) getIntent().getExtras().getSerializable("ListElement");

    }

    public void onStart(){
        super.onStart();

        iconImg.setImageResource(Item.getImg());
        TITULO.setText(Item.getName());
        descrip.setText(Item.getDescrip());
        genero.setText(Item.getGenero());

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirEnalce();
            }
        });
    }

    public void abrirEnalce(){
        String titulo = TITULO.getText().toString();

        if(titulo.equals("Highway to hell")){
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=l482T0yNkeo&ab_channel=acdcVEVO"));
            startActivity(in);
        }else if (titulo.equals("Troll")){
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tokyvideo.com/es/video/troll-completa-en-espanol"));
            startActivity(in);

        }else if (titulo.equals("El irlandes")){
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.netflix.com/title/80175798"));
            startActivity(in);

        }else if (titulo.equals("Imperdonable")){
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cuevana.pro/pelicula/imperdonable"));
            startActivity(in);
        }else if (titulo.equals("Freebird")){
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=D0W1v0kOELA"));
            startActivity(in);

        }else if (titulo.equals("Whole lotta love")){
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=HQmmM_qwG4k"));
            startActivity(in);

        }else if (titulo.equals("En la sombra")){
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.justwatch.com/es/pelicula/en-la-sombra"));
            startActivity(in);
        }else if (titulo.equals("Thunder road")){
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=UDIDawmeeI0"));
            startActivity(in);
        }

    }
}