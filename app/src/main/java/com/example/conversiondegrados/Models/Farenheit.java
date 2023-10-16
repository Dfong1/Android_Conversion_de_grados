package com.example.conversiondegrados.Models;

public class Farenheit extends Grados{

    public Farenheit(Double valor){
        this.setValor(valor);
        this.setUnidad("K");

    }
    public Farenheit() {

    }

    public Farenheit parse(Celsius c){
        Double valor = (c.getValor() * (9/5) + 32);
        return new Farenheit(valor);
    }

    public Farenheit parse(Kelvin k){
        Double valor = (k.getValor() - 273.15) * (9/5) + 32;
        return new Farenheit(valor);
    }

}
