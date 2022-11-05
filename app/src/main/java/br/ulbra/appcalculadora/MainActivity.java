package br.ulbra.appcalculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText valor1, valor2;

    Button somar, subtrair, multiplicar, dividir;

    public void mostrarResultado(String titulo,String mensagem,String botao)
    {
        AlertDialog.Builder resultado = new AlertDialog.Builder(MainActivity.this);
        resultado.setTitle(titulo);
        resultado.setMessage(mensagem);
        resultado.setNeutralButton(botao,null);
        resultado.show();
    }

    public double calcular(int op, double valor1, double valor2)
    {
        double res = 0;

        if (op == 1) {
            res = valor1 + valor2;
        } else if (op == 2) {
            res = valor1 - valor2;
        } else if (op == 3) {
            res = valor1 * valor2;
        } else {
            res = valor1 / valor2;
        }

        /*
        try
        {

        }
        catch ()
        {

        }
        */

        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = findViewById(R.id.edvalor1);
        valor2 = findViewById(R.id.edvalor2);



        somar = findViewById(R.id.somar);
        subtrair = findViewById(R.id.subtrair);
        multiplicar = findViewById(R.id.multiplicar);
        dividir = findViewById(R.id.dividi);

        somar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int op = 1;
                double val1 = Double.parseDouble(valor1.getText().toString());
                double val2 = Double.parseDouble(valor2.getText().toString());

                if(valor1.getText().toString().isEmpty() && valor2.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Campo em branco", Toast.LENGTH_LONG);
                }
                else
                {
                    mostrarResultado("Resultados da calculadora","O resultado da soma: " + calcular(op,val1, val2),"Ok");
                }
            }
        });

        subtrair.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int op = 2;
                double val1 = Double.parseDouble(valor1.getText().toString());
                double val2 = Double.parseDouble(valor2.getText().toString());

                mostrarResultado("Resultados da calculadora","O resultado da subtração: " + calcular(op,val1, val2),"Ok");
            }
        });

        multiplicar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int op = 3;
                double val1 = Double.parseDouble(valor1.getText().toString());
                double val2 = Double.parseDouble(valor2.getText().toString());

                mostrarResultado("Resultados da calculadora","O resultado da multiplicação: " + calcular(op,val1, val2),"Ok");
            }
        });

        dividir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int op = 4;
                double val1 = Double.parseDouble(valor1.getText().toString());
                double val2 = Double.parseDouble(valor2.getText().toString());


                mostrarResultado("Resultados da calculadora","O resultado da divisão: " + calcular(op,val1, val2),"Ok");
            }
        });

    }
}