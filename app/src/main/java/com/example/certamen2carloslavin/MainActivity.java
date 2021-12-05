package com.example.certamen2carloslavin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //----------MetodoBotonSiguiente
    public void Siguiente(View view){
        Intent siguiente = new Intent(this, MainActivity2.class);
        startActivity(siguiente);
    }
    //----------MetodoBotonSiguiente
    public void Siguiente2(View view){
        Intent siguiente = new Intent(this, MapsActivity.class);
        startActivity(siguiente);
    }
}