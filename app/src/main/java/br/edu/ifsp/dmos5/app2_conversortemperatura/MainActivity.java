package br.edu.ifsp.dmos5.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FahrenheitStrategy FahrenheitConversion = new FahrenheitStrategy();
    private CelsiusStrategy CelsiusConversion = new CelsiusStrategy();
    private KelvinStrategy KelvinConversion = new KelvinStrategy();
    private EditText inputEditText;

    private Spinner spinner;
    private Button converterButton;
    private TextView outputTextView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associar atributos XML com os objetos Java

        inputEditText = findViewById(R.id.edittext_input);
        spinner = findViewById(R.id.spin_escala);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.escala_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        converterButton = findViewById(R.id.button_converter);
        outputTextView = findViewById(R.id.textview_output);
        converterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == converterButton) {

            String escala = spinner.getSelectedItem().toString();

            if (escala.equals("Celsius")) {
                getCelsiusConversion();
            } else if (escala.equals("Fahrenheit")) {
                getFahrenheitConversion();
            } else {
                getKelvinConversion();
            }

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