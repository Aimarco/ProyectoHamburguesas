package com.example.aimar.proyectohamburguesas;

import java.io.Serializable;

/**
 * Created by adminportatil on 03/02/2016.
 */
public class hamburguesas implements Serializable {
    private int clasica,clasiqueso,dobleq,vegetal,especial,tamaño,tipoc;
    private float totalh;

    public int getClasica() {
        return clasica;
    }

    public void setClasica(int clasica) {
        this.clasica = clasica;
    }

    public int getClasiqueso() {
        return clasiqueso;
    }

    public void setClasiqueso(int clasiqueso) {
        this.clasiqueso = clasiqueso;
    }

    public int getDobleq() {
        return dobleq;
    }

    public void setDobleq(int dobleq) {
        this.dobleq = dobleq;
    }

    public int getVegetal() {
        return vegetal;
    }

    public void setVegetal(int vegetal) {
        this.vegetal = vegetal;
    }

    public int getEspecial() {
        return especial;
    }

    public void setEspecial(int especial) {
        this.especial = especial;
    }

    public float getTotalh() {
        return totalh;
    }

    public void setTotalh(float totalh) {
        this.totalh = totalh;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getTipoc() {
        return tipoc;
    }

    public void setTipoc(int tipoc) {
        this.tipoc = tipoc;
    }
}
