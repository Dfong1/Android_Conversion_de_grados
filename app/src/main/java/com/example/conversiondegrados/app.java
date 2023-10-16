package com.example.conversiondegrados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.conversiondegrados.Models.Celsius;
import com.example.conversiondegrados.Models.Farenheit;
import com.example.conversiondegrados.Models.Kelvin;

public class app extends AppCompatActivity {

    Spinner grados;
    EditText g;
    Spinner gradosConv;
    Button convertir;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        grados = findViewById(R.id.medidaGrados);
        gradosConv = findViewById(R.id.gradosAConv);
        g = findViewById(R.id.grados);
        convertir = findViewById(R.id.convertir);
        res = findViewById(R.id.gradosDevueltos);

        // Inserción de las opciones en los spinners de grados
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.opciones_spinner, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grados.setAdapter(adaptador);
        gradosConv.setAdapter(adaptador);

        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener las selecciones de los Spinners
                String fromUnit = grados.getSelectedItem().toString();
                String toUnit = gradosConv.getSelectedItem().toString();

                // Obtener el valor de temperatura en Celsius desde el EditText
                double valor = Double.parseDouble(g.getText().toString());

                // Realizar la conversión
                if ("Celsius".equals(fromUnit) && "Farenheit".equals(toUnit)) {
                    Celsius grados = new Celsius(valor);
                    Farenheit resultado = new Farenheit();
                    res.setText("Grados: " + resultado.parse(grados).getValor() + "°F");
                }
                else if ("Celsius".equals(fromUnit) && "Kelvin".equals(toUnit)) {
                    Celsius grados = new Celsius(valor);
                    Kelvin resultado = new Kelvin();
                    res.setText("Grados: " + resultado.parse(grados).getValor() + "°K");
                }
                else if("Celsius".equals(fromUnit) && "Celsius".equals(toUnit)){
                    res.setText("Grados: " + g.getText() + "°C");
                }

                else if ("Farenheit".equals(fromUnit) && "Celsius".equals(toUnit)) {
                    Farenheit grados = new Farenheit(valor);
                    Celsius resultado = new Celsius();
                    res.setText("Grados: " + resultado.parse(grados).getValor() + "°C");
                }
                else if ("Farenheit".equals(fromUnit) && "Kelvin".equals(toUnit)) {
                    Farenheit grados = new Farenheit(valor);
                    Kelvin resultado = new Kelvin();
                    res.setText("Grados: " + resultado.parse(grados).getValor() + "°K");
                }
                else if("Farenheit".equals(fromUnit) && "Farenheit".equals(toUnit)){
                    res.setText("Grados: " + g.getText() + "°F");
                }
                else if ("Kelvin".equals(fromUnit) && "Farenheit".equals(toUnit)) {
                    Kelvin grados = new Kelvin(valor);
                    Farenheit resultado = new Farenheit();
                    res.setText("Grados: " + resultado.parse(grados).getValor() + "°F");
                }
                else if ("Kelvin".equals(fromUnit) && "Celsius".equals(toUnit)) {
                    Kelvin grados = new Kelvin(valor);
                    Celsius resultado = new Celsius();
                    res.setText("Grados: " + resultado.parse(grados).getValor() + "°C");
                }
                else{
                    res.setText("Grados: " + g.getText() + "°K");
                }
            }
        });
    }
}
