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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText txtUsu,txtCla;
    Button btnAcceso,btnRegresar;

    String usu="",cla="";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsu=findViewById(R.id.txtLogusu);
        txtCla=findViewById(R.id.txtLogcla);
        btnAcceso=findViewById(R.id.btnAcceso);
        btnRegresar=findViewById(R.id.btnRegresar);

        btnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu=txtUsu.getText().toString();
                cla=txtCla.getText().toString();
                if(usu.equals("")) {

                    Toast.makeText(Login.this, "Ingrese su Usuario", Toast.LENGTH_LONG).show();
                    txtUsu.requestFocus();
                }else if (cla.equals("")){
                    Toast.makeText(Login.this, "Ingrese su Clave", Toast.LENGTH_LONG).show();
                    txtCla.requestFocus();

                }else{
                    verificarusuarioclave("http://192.168.1.41/minimarKet/verificarusuarioclave.php");
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visualizar=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(visualizar);
            }
        });
    }
    private void verificarusuarioclave(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equalsIgnoreCase("ingresos")){
                   Intent visualizar=new Intent(getApplicationContext(),Dashboard.class);
                   startActivity(visualizar);
                    Toast.makeText(getApplicationContext(), "Bienvenido al Sistema", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Credenciales no Validas", Toast.LENGTH_SHORT).show();
                }


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

                Map<String,String>parametros=new HashMap<String, String>();

                parametros.put("Usu",usu);
                parametros.put("Cla",cla);
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}