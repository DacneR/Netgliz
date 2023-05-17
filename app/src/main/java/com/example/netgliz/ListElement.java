package com.example.netgliz;

import java.io.Serializable;

public class ListElement implements Serializable {


    public ListElement(String name, String descrip, String genero) {
        this.name = name;
        this.descrip = descrip;
        this.genero = genero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String name;
    public String descrip;
    public String genero;




}
