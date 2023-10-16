package com.example.conversiondegrados.Models;

public class Kelvin extends Grados{

    public Kelvin(Double valor){
        this.setValor(valor);
        this.setUnidad("F");
    }
    public Kelvin(){

    }

    public Kelvin parse(Celsius c){
        Double valor = c.getValor() + 273.15;
        return new Kelvin(valor);
    }

    public Kelvin parse(Farenheit f){
        Double valor = (f.getValor() - 32) * (5/9) + 273.15;
        return new Kelvin(valor);
    }



}
