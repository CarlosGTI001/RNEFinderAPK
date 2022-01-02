package com.carlosgti001.rnegen;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBanners;
import com.unity3d.services.banners.view.BannerPosition;

import java.util.Calendar;

public class fechaNacimiento extends AppCompatActivity {

    String fecha;
    Button abrirDtP;
    Button continuar;
    TextView tv, tvno;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        String gameID = "4056667";
        boolean testMode = false;
        setContentView(R.layout.activity_nacimientofecha);

        super.onCreate(savedInstanceState);

        UnityAds.initialize(fechaNacimiento.this, gameID);
        IUnityBannerListener iUnityBannerListener = new IUnityBannerListener() {
            @Override
            public void onUnityBannerLoaded(String s, View view) {
                ((ViewGroup)findViewById(R.id.adlayoutfecha)).removeView(view);
                ((ViewGroup)findViewById(R.id.adlayoutfecha)).addView(view);
            }

            @Override
            public void onUnityBannerUnloaded(String s) {

            }

            @Override
            public void onUnityBannerShow(String s) {

            }

            @Override
            public void onUnityBannerClick(String s) {

            }

            @Override
            public void onUnityBannerHide(String s) {

            }

            @Override
            public void onUnityBannerError(String s) {

            }
        };
        UnityBanners.setBannerListener(iUnityBannerListener);
        UnityBanners.setBannerPosition(BannerPosition.TOP_CENTER);
        String bannerAdPlacement = "Banner_Android";
        UnityBanners.loadBanner(fechaNacimiento.this, bannerAdPlacement);


        Intent intent = getIntent();
        intent.getExtras();
        tv = findViewById(R.id.fecha);
        tvno = findViewById(R.id.bien);
        if(intent.getStringExtra("nombre") != null){
            String Nombre = intent.getStringExtra("nombre");
            tvno.setText("Muy bien, " + Nombre);
        }else{
            tvno.setText("");
        }
        String nameApellido12 = intent.getStringExtra("NAA");
        final Calendar calendario = Calendar.getInstance();
        int dia=calendario.get(Calendar.DAY_OF_MONTH);
        int mes=calendario.get(Calendar.MONTH);
        int anio=calendario.get(Calendar.YEAR);
         Intent cont = new Intent(this, finalA.class);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, monthOfYear, dayOfMonth) -> {
            UnityBanners.loadBanner(fechaNacimiento.this, bannerAdPlacement);
            if(monthOfYear < 9){
                fecha = dayOfMonth+"/0"+(monthOfYear+1)+"/"+year;
                if (dayOfMonth < 10){
                    fecha = "0"+dayOfMonth+"/0"+(monthOfYear+1)+"/"+year;
                }
            }else {
                if (dayOfMonth < 10){
                    fecha = "0"+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
                }
            }
            if(dayOfMonth > 9 && monthOfYear > 9){
                fecha = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
            }
            tv.setText(fecha);
        }
                ,anio, mes, dia);
        abrirDtP = findViewById(R.id.pickDateBtn);
        abrirDtP.setOnClickListener(v -> datePickerDialog.show());


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("No has elegido una fecha de nacimiento, por favor elige una en el boton de Definir Fecha de Nacimiento")
                .setTitle("Alerta");
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        continuar = findViewById(R.id.continuar);

        continuar.setOnClickListener(v -> {
            char[] fechaDesp;
            String temporal = tv.getText().toString();
            if(!temporal.equals("--/--/----")){
                fechaDesp = fecha.toCharArray();
                String datoSemiFinal;
                datoSemiFinal = nameApellido12 + fechaDesp[8] + fechaDesp[9] + fechaDesp[3] + fechaDesp[4] + fechaDesp[0] + fechaDesp[1];
                String dateSemiFinal = ""+datoSemiFinal + "0001";
                cont.putExtra("datos", dateSemiFinal);
                startActivity(cont);
            }else{
                dialog.show();
            }
        });
    }
    public void volveratras(View v){
        this.finish();
    }
}