package br.edu.ifsp.dmos5.app2_conversortemperatura;

public class KelvinStrategy implements ConversorTemperatura{
    @Override
    public double getConversion(double temperature) {

        double conversion = temperature + 273.15;

        return conversion;
    }
}
