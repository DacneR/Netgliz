package com.example.netgliz;

public class ListElement {
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

    public ListElement(String name, String descrip, String genero, int img) {
        this.name = name;
        this.descrip = descrip;
        this.genero = genero;
        this.img = img;
    }

    public String name, descrip, genero;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int img;
}
