package br.edu.ifsp.dmos5.app2_conversortemperatura;

public class FahrenheitStrategy implements ConversorTemperatura{

    //converter para Celsius
    @Override
    public double getConversion(double temperature) {

        double conversion = (temperature - 32) / 1.8;

        return conversion;
    }
}
