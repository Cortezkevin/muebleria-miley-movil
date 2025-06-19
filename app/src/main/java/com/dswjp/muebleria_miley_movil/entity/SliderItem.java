package com.dswjp.muebleria_miley_movil.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class SliderItem {
    private String titulo;
    private int imagen;

    public SliderItem() {
    }

    public SliderItem(int imagen, String titulo) {
        this.imagen = imagen;
        this.titulo = titulo;

    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
