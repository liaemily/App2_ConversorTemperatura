package br.edu.ifsp.dmos5.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FahrenheitStrategy FahrenheitConversion = new FahrenheitStrategy();
    private CelsiusStrategy CelsiusConversion = new CelsiusStrategy();

    private KelvinStrategy KelvinConversion = new KelvinStrategy();
    private EditText inputEditText;
    private Button converterCelsiusButton;
    private Button converterFahrenheitButton;
    private Button converterKelvinButton;
    private TextView outputTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associar atributos XML com os objetos Java

        inputEditText = findViewById(R.id.edittext_input);
        converterCelsiusButton = findViewById(R.id.button_converter_celsius);
        converterFahrenheitButton = findViewById(R.id.button_converter_fahrenheit);
        converterKelvinButton = findViewById(R.id.button_converter_kelvin);
        outputTextView = findViewById(R.id.textview_output);
        converterCelsiusButton.setOnClickListener(this);
        converterFahrenheitButton.setOnClickListener(this);
        converterKelvinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == converterCelsiusButton){
            getCelsiusConversion();
        }

        else if (v == converterFahrenheitButton){
            getFahrenheitConversion();
        }

        else if (v == converterKelvinButton){
            getKelvinConversion();
        }
    }

    private void getCelsiusConversion(){
        double value = getValue();
        double celsius;

        celsius = FahrenheitConversion.getConversion(value);

        outputTextView.setText(String.valueOf(celsius + "ºC"));
    }

    private void getFahrenheitConversion(){
        double value = getValue();
        double fahrenheit;

        fahrenheit = CelsiusConversion.getConversion(value);

        outputTextView.setText(String.valueOf(fahrenheit + "ºF"));
    }

    private void getKelvinConversion(){
        double value = getValue();
        double kelvin;

        kelvin = KelvinConversion.getConversion(value);

        outputTextView.setText(String.valueOf(kelvin + "ºK"));
    }

    private double getValue(){

        double value;

        String valueString;

        valueString = inputEditText.getText().toString();

        try{
            value = Double.valueOf(valueString);
        }catch (NumberFormatException nfException){
            value = 0;
            Toast.makeText(this,"Valor digitado é inválido",Toast.LENGTH_SHORT).show();
        }

        return value;
    }
}