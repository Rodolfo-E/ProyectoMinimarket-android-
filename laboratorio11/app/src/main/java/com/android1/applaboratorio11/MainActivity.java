package com.android1.applaboratorio11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    EditText txtUsu,txtCla,txtRecla;
    Button btnRegistrar,btnLogin;

    String usu="",cla="",recla="";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        txtUsu=findViewById(R.id.txtUsu);
        txtCla=findViewById(R.id.txtCla);
        txtRecla=findViewById(R.id.txtRecla);
        btnRegistrar=findViewById(R.id.btnRegistrar);
        btnLogin=findViewById(R.id.btnLogin);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usu=txtUsu.getText().toString();
                cla=txtCla.getText().toString();
                recla=txtRecla.getText().toString();

                if(usu.equals("")){
                    Toast.makeText(MainActivity.this,"Ingrese el Usuario ",Toast.LENGTH_LONG).show();
                    txtUsu.requestFocus();
                }else if(cla.equals("")){
                    Toast.makeText(MainActivity.this,"Ingrese la Clave",Toast.LENGTH_LONG).show();
                    txtCla.requestFocus();
                }else if(recla.equals("")){
                    Toast.makeText(MainActivity.this,"Repita la Clave",Toast.LENGTH_LONG).show();
                    txtRecla.requestFocus();
                }else {
                    if(cla.equals(recla)){

                        ejecutarservicio("http://192.168.1.41/minimarKet/agregarusuario.php");

                    }else{
                        Toast.makeText(MainActivity.this,"Clave no coincide",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrar=new Intent(getApplicationContext(),Login.class);
                startActivity(mostrar);
            }
        });
    }
    private void ejecutarservicio(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(),"Registro Exitoso",Toast.LENGTH_SHORT).show();
                Intent mostrar = new Intent(getApplicationContext(), Login.class);
                startActivity(mostrar);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error de Conexion",Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String,String>parametros=new HashMap<>();
                parametros.put("Usu",usu);
                parametros.put("Cla",cla);

                return parametros;

            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
    private void verificarusuario(String URL){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Toast.makeText(MainActivity.this,"EL Usuario ya existe",Toast.LENGTH_SHORT).show();
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error de Conexion",Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);


    }
}