package com.example.certamen2carloslavin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.certamen2carloslavin.Models.Pelicula;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity2 extends AppCompatActivity {
    private List<Pelicula> ListAutor= new ArrayList<Pelicula>();
    ArrayAdapter<Pelicula> arrayAdapterAutor;

    EditText etNombre, etGenero;
    Button bTAceptar;
    ListView lvAutores;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etNombre = findViewById(R.id.eTNombre);
        etGenero=findViewById(R.id.eTGenero);
        bTAceptar=findViewById(R.id.bTAceptar);
        lvAutores=findViewById(R.id.lvAutores);

        inicializarFireBase();
        listarDatos();

        bTAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula=new Pelicula();
                pelicula.setIdPelicula(UUID.randomUUID().toString());
                pelicula.setNombre(etNombre.getText().toString());
                pelicula.setGenero(etGenero.getText().toString());
                databaseReference.child("Pelicula").child(pelicula.getIdPelicula()).setValue(pelicula);
            }
        });
    }

    //----------MetodoBotonSAnterior
    public void Anterior(View view) {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
    private void inicializarFireBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
    }
//Al Listar los datos se visualizan de forma no deseada, pero hace una correcta conexion hace la base de datos
    private void listarDatos() {
        databaseReference.child("Pelicula").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListAutor.clear();
                for (DataSnapshot objSnapShot : snapshot.getChildren()){
                    Pelicula au = objSnapShot.getValue(Pelicula.class);
                    ListAutor.add(au);
                    arrayAdapterAutor = new ArrayAdapter<Pelicula>(MainActivity2.this, android.R.layout.simple_expandable_list_item_1,ListAutor);
                    lvAutores.setAdapter(arrayAdapterAutor);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
