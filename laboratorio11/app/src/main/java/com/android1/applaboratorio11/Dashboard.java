package com.android1.applaboratorio11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    CardView cardclient,cardofertas,cardcompras,carddeudas;

    Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        cardclient=findViewById(R.id.Cardcliente);
        cardofertas=findViewById(R.id.Cardofertas);
        cardcompras=findViewById(R.id.Cardcompras);
        carddeudas=findViewById(R.id.Carddeudas);
        btnSalir=findViewById(R.id.btnSalir);

        cardclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrar = new Intent(getApplicationContext(), lstCliente.class);
                startActivity(mostrar);
            }
        });

        cardofertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mostrar = new Intent(getApplicationContext(),Ofertas.class);
                startActivity(mostrar);
            }
        });

        cardcompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrar = new Intent(getApplicationContext(),lstCompra.class);
                startActivity(mostrar);
            }
        });
        carddeudas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrar = new Intent(getApplicationContext(),lstDeudas.class);
                startActivity(mostrar);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrar = new Intent(getApplicationContext(),Login.class);
                startActivity(mostrar);
            }
        });
    }

}