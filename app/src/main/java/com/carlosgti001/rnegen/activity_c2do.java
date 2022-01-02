package com.carlosgti001.rnegen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.UnityBanners;

@SuppressWarnings("ALL")
public class activity_c2do extends AppCompatActivity {
    public Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2d);
        Intent intent = new Intent(this, nameApellido.class);
        continuar = findViewById(R.id.cont1);
        continuar.setOnClickListener(v -> startActivity(intent));
    }


    private void mostrarInsteristatial(){


    }


}