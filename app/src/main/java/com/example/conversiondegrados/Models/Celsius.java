package com.example.conversiondegrados.Models;

public class Celsius extends Grados{

    public Celsius(Double valor){
        this.setValor(valor);
        this.setUnidad("C");
    }
    public Celsius(){

    }

    public Celsius parse(Farenheit f){
        Double valor = (f.getValor() - 32) * 5/9;

        return new Celsius(valor);
    }
    public Celsius parse(Kelvin k){
        Double valor = k.getValor() - 273.15;
        return new Celsius(valor);
    }

}
