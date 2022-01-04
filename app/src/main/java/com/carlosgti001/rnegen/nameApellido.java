package com.carlosgti001.rnegen;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class nameApellido extends AppCompatActivity {


    String dato1;
    String nameString, ap1String, ap2String;
    char [] n1C, a1C, a2C;
    EditText nombre;
    EditText apellido1;
    EditText apellido2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        setContentView(R.layout.activity_dashboard2);
        super.onCreate(savedInstanceState);
        Toolbar tool = findViewById(R.id.toolbar);
        setActionBar(tool);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        UnityAds.initialize(nameApellido.this, gameID);

        //banner = findViewById(R.id.adLayout);
        nombre = findViewById(R.id.name);




        apellido1 = findViewById(R.id.ape1);
        apellido2 = findViewById(R.id.ape2);
        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnityBanners.loadBanner(nameApellido.this, bannerAdPlacement);

            }
        });

         */
    }


    public void obtenerdatos(View v)
    {
      /*  if(nombre.getText().toString().isEmpty() || apellido1.getText().toString().isEmpty())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("No puedes dejar el primer nombre ni el primer apellido vacio, rellenenlos porfavor.")
                    .setTitle("Alerta");
            AlertDialog dialog = builder.create();
            dialog.show();
        }else{
            nameString = nombre.getText().toString();
            ap1String = apellido1.getText().toString();
            if(apellido2.getText().toString().isEmpty()){
                ap2String = "-";
            }else{
                ap2String = apellido2.getText().toString();
            }
            n1C = nameString.toCharArray();
            a1C = ap1String.toCharArray();
            a2C = ap2String.toCharArray();
            dato1 = ""+n1C[0]+a1C[0]+a2C[0]+"".toUpperCase();
            Intent intent = new Intent(this, fechaNacimiento.class);
            intent.putExtra("NAA", dato1);
            intent.putExtra("nombre", nameString);
            startActivity(intent);
        }*/
    }
}