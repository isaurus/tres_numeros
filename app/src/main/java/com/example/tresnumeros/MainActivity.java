package com.example.tresnumeros;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText edtNumOne;
    EditText edtNumTwo;
    EditText edtNumThree;

    TextView txtResultLeft;
    TextView txtResultCenter;
    TextView txtResultRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de los botones
        findViewById(R.id.btnLower).setOnClickListener(v -> calculate(1));
        findViewById(R.id.btnHigher).setOnClickListener(v -> calculate(2));
        findViewById(R.id.btnAscendant).setOnClickListener(v -> calculate(3));
        findViewById(R.id.btnDescendant).setOnClickListener(v -> calculate(4));

        // Inicialización del botón "BORRAR TODO"
        findViewById(R.id.btnEraseAll).setOnClickListener(v -> eraseAll());

        // Declaración e inicialización de los Edit Text para los valores numéricos
        edtNumOne = findViewById(R.id.edtNumOne);
        edtNumTwo = findViewById(R.id.edtNumTwo);
        edtNumThree = findViewById(R.id.edtNumThree);

        // Declaración e inicialización de los Text View de los resultados
        txtResultLeft = findViewById(R.id.txtResultLeft);
        txtResultCenter = findViewById(R.id.txtResultCenter);
        txtResultRight = findViewById(R.id.txtResultRight);
    }

    // Método que utilizará la operación correspondiente según el botón pulsado (menor, mayor, ord asc, ord desc)
    public void calculate(int operationId){
        // Recogemos los valores introducidos y los parseamos a int
        int numOne = Integer.parseInt(edtNumOne.getText().toString());
        int numTwo = Integer.parseInt(edtNumTwo.getText().toString());
        int numThree = Integer.parseInt(edtNumThree.getText().toString());

        // Variables para almacenar el mínimo y máximo valor para representarlos en pantalla
        int minValue;
        int maxValue;

        // Array de los valores para ordenarlos
        int[] values = {numOne, numTwo, numThree};

        switch (operationId){
            case 1:
                if(numOne < numTwo && numOne < numThree){
                    txtResultCenter.setText("" + numOne);
                } else if(numTwo < numOne && numTwo < numThree){
                    txtResultCenter.setText("" + numTwo);
                } else{
                    txtResultCenter.setText("" + numThree);
                }
                break;
            case 2:
                if(numOne > numTwo && numOne > numThree){
                    txtResultCenter.setText("" + numOne);
                } else if(numTwo > numOne && numTwo > numThree){
                    txtResultCenter.setText("" + numTwo);
                } else{
                    txtResultCenter.setText("" + numThree);
                }
                break;
            case 3:
                Arrays.sort(values); // Orden ascendente
                txtResultLeft.setText(String.valueOf(values[0]));
                txtResultCenter.setText(String.valueOf(values[1]));
                txtResultRight.setText(String.valueOf(values[2]));
                break;
            case 4:
                Arrays.sort(values);
                txtResultLeft.setText(String.valueOf(values[2]));
                txtResultCenter.setText(String.valueOf(values[1]));
                txtResultRight.setText(String.valueOf(values[0]));
                break;
        }
    }

    // Método para borrar los valores de los campos de texto al pulsar el botón BORRAR TODO
    public void eraseAll(){
        // Deja en blanco los campos Edit Text
        edtNumOne.setText("");
        edtNumTwo.setText("");
        edtNumThree.setText("");

        // Deja en blanco los campos Text View
        txtResultLeft.setText("");
        txtResultCenter.setText("");
        txtResultRight.setText("");
    }
}