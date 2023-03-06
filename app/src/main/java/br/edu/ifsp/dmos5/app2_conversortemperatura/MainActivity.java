package br.edu.ifsp.dmos5.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FahrenheitStrategy FahrenheitConvertion = new FahrenheitStrategy();
    private EditText inputEditText;
    private Button converterCelsiusButton;
    private TextView outputTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associar atributos XML com os objetos Java

        inputEditText = findViewById(R.id.edittext_input);
        converterCelsiusButton = findViewById(R.id.button_converter_celsius);
        outputTextView = findViewById(R.id.textview_output);
        converterCelsiusButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == converterCelsiusButton){
            getCelsiusConvertion();
        }
    }

    private void getCelsiusConvertion(){
        double value = getValue();
        double celsius;

        celsius = FahrenheitConvertion.getConversion(value);

        outputTextView.setText(String.valueOf(celsius + "ºC"));
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