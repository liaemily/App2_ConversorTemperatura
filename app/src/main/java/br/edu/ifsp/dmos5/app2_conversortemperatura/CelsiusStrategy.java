package br.edu.ifsp.dmos5.app2_conversortemperatura;

public class CelsiusStrategy implements ConversorTemperatura {
    @Override
    public double getConversion(double temperature) {

        double conversion = 1.8 * temperature + 32;

        return conversion;
    }
}
