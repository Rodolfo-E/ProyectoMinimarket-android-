package com.android1.applaboratorio11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class lstCliente extends AppCompatActivity {
    private RecyclerView ress;
    private static String url = "http://192.168.1.41/minimarKet/clientes.php";
    List<Clientes> clientesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_cliente);
        ress = findViewById(R.id.recli);
        ress.setHasFixedSize(true);
        ress.setLayoutManager(new LinearLayoutManager(this));
        clientesList = new ArrayList<>();
        mostrar();
    }
    public void cerrar(View View) {

        Intent visualizar = new Intent(getApplicationContext(), Dashboard.class);
        startActivity(visualizar);
    }

    private void mostrar() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {

                        JSONObject Clientes= array.getJSONObject(i);
                       clientesList.add(new Clientes(Clientes.getString ("Codigo"),
                                Clientes.getString("Nombre"),
                                Clientes.getString("Apellido"),
                                Clientes.getString("Direccion"),
                                Clientes.getString("Correo"),
                                Clientes.getString("Celular"),
                                        Clientes.getString("Distrito")

                        ));

                    }
                    AdapterClientes adapter = new AdapterClientes(lstCliente.this, clientesList);
                    ress.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error de Conexion", Toast.LENGTH_SHORT).show();
            }

        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}