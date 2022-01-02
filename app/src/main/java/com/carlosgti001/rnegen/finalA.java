package com.carlosgti001.rnegen;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBanners;
import com.unity3d.services.banners.view.BannerPosition;

public class finalA extends AppCompatActivity {

    Button copy;
    AlertDialog.Builder builder;
    TextView run;
    private final String interstitialAdPlacement = "Interstitial_Android";
    String gameID = "4056667";
    boolean testMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Si te fue de provecho, recuerda valorar la app con 5 estrellas y dejar tu opinion sobre la misma!")
                .setTitle("Alerta");
        builder.setNegativeButton("No, Gracias.", null);
        builder.setPositiveButton("Vamos alla!", (dialog, which) -> {
        });

        setContentView(R.layout.finalizar);
        super.onCreate(savedInstanceState);
        UnityAds.initialize(finalA.this, gameID, testMode);
        UnityAds.load(interstitialAdPlacement);
        IUnityAdsListener unityAdsListener = new IUnityAdsListener() {
            @Override
            public void onUnityAdsReady(String s) {

            }

            @Override
            public void onUnityAdsStart(String s) {

            }

            @Override
            public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {
                ClipboardManager clipboard = (ClipboardManager)
                        getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("RNE", run.getText());
                clipboard.setPrimaryClip(clip);
                builder.setMessage("Ya el RNE esta copiado al portapapeles. Desea ir a la pagina de los certificados y resultados de las pruebas nacionales? Si te fue de provecho, recuerda valorar la app con 5 estrellas y dejar tu opinion sobre la misma")
                        .setTitle("Suceso");
                builder.setNegativeButton("No, Gracias.", null);
                builder.setPositiveButton("Vamos alla!", (dialog, which) -> {
                    Intent ir = new Intent("android.intent.action.VIEW", Uri.parse("https://certificado.ministeriodeeducacion.gob.do/"));
                    startActivity(ir);
                });
                builder.setNeutralButton("Valora la APP", ((dialog, which) -> {
                    Intent lo = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.carlosgti001.rnegen"));
                    startActivity(lo);
                }));
                AlertDialog dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {
                ClipboardManager clipboard = (ClipboardManager)
                        getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("RNE", run.getText());
                clipboard.setPrimaryClip(clip);
                builder.setMessage("Ya el RNE esta copiado al portapapeles. Desea ir a la pagina de los certificados y resultados de las pruebas nacionales? Si te fue de provecho, recuerda valorar la app con 5 estrellas y dejar tu opinion sobre la misma")
                        .setTitle("Suceso");
                builder.setNegativeButton("No, Gracias.", null);
                builder.setPositiveButton("Vamos alla!", (dialog, which) -> {
                    Intent ir = new Intent("android.intent.action.VIEW", Uri.parse("https://certificado.ministeriodeeducacion.gob.do/"));
                    startActivity(ir);
                });
                builder.setNeutralButton("Valora la APP", ((dialog, which) -> {
                    Intent lo = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.carlosgti001.rnegen"));
                    startActivity(lo);
                }));
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        };
        UnityAds.setListener(unityAdsListener);
        Intent intent = getIntent();
        intent.getExtras();
        run = findViewById(R.id.run2);
        run.setText(intent.getStringExtra("datos"));
        copy = findViewById(R.id.copypaste);
    }

    public void terminar(View v) {
        if(UnityAds.isReady()){
            UnityAds.show(this, interstitialAdPlacement);
        }else{
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "El anuncio no ha cargado, porfavor espere", Toast.LENGTH_LONG);
            toast1.show();
        }
    }

    public void volveratras(View v){
        this.finish();
    }
}