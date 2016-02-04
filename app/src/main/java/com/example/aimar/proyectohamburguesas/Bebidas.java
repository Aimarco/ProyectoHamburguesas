package com.example.aimar.proyectohamburguesas;

import java.io.Serializable;

/**
 * Created by adminportatil on 03/02/2016.
 */
public class Bebidas implements Serializable {
    private int agua,nestea,limon,naranja,cocacola,cerveza;
    private float totalb;

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getNestea() {
        return nestea;
    }

    public void setNestea(int nestea) {
        this.nestea = nestea;
    }

    public int getLimon() {
        return limon;
    }

    public void setLimon(int limon) {
        this.limon = limon;
    }

    public int getNaranja() {
        return naranja;
    }

    public void setNaranja(int naranja) {
        this.naranja = naranja;
    }

    public int getCocacola() {
        return cocacola;
    }

    public void setCocacola(int cocacola) {
        this.cocacola = cocacola;
    }

    public int getCerveza() {
        return cerveza;
    }

    public void setCerveza(int cerveza) {
        this.cerveza = cerveza;
    }
}
