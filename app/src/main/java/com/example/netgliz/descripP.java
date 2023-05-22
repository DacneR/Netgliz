package com.example.netgliz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class descripP extends AppCompatActivity {

    public ImageView iconImg;
    public TextView titulo, descrip, genero;
    public ListElement Item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descrip_p);
        iconImg = findViewById(R.id.iconoImageView);
        titulo = findViewById(R.id.nameTextView);
        descrip = findViewById(R.id.descripTextView);
        genero = findViewById(R.id.generoTextView);

        Item = (ListElement) getIntent().getExtras().getSerializable("ListElement");

    }

    public void onStart(){
        super.onStart();

        iconImg.setImageResource(Item.getImg());
        titulo.setText(Item.getName());
        descrip.setText(Item.getDescrip());
        genero.setText(Item.getGenero());
    }
}