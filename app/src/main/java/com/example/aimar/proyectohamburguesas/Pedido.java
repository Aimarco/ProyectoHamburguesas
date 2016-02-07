package com.example.aimar.proyectohamburguesas;

/**
 * Created by adminportatil on 03/02/2016.
 */
public class Pedido {
    private hamburguesas hamburguesas;
    private Bebidas bebidas;
    private float total;

    public hamburguesas getHamburguesas() {
        return hamburguesas;
    }

    public void setHamburguesas(hamburguesas hamburguesas) {
        this.hamburguesas = hamburguesas;
    }

    public Bebidas getBebidas() {
        return bebidas;
    }

    public void setBebidas(Bebidas bebidas) {
        this.bebidas = bebidas;
    }
}
