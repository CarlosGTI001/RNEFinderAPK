package com.carlosgti001.rnegen;
import static java.lang.Thread.sleep;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.AppTheme_NoActionBar);

        Intent intent1 = new Intent(this, activity_c2do.class);
        Intent intent2 = new Intent(this, nameApellido.class);
        if(leer()){
            startActivity(intent2);
        }else{
            verdadero();
            setContentView(R.layout.activity_main);
            Button continuar = findViewById(R.id.continuar1);
            continuar.setOnClickListener((View v) -> startActivity(intent1));
        }
    }
    @SuppressLint("ApplySharedPref")
    void verdadero(){
        SharedPreferences preferences = getSharedPreferences("primeravez", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("valor", true);
        editor.commit();
    }
    boolean leer(){
        SharedPreferences preferences = getSharedPreferences("primeravez", Context.MODE_PRIVATE);
        return preferences.getBoolean("valor", false);
    }
}