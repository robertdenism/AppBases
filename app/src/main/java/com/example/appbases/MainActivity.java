package com.example.appbases;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button botonAniadir;
    Button botonRefrescar;
    Button botonBorrar;
    EditText addTitulo, addDireccion, addCategoria, addDesc;
    TextView datos;
    AppDatabase db;
    OcioDAO userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonAniadir = findViewById(R.id.botonAniadir);
        botonRefrescar = findViewById(R.id.botonRefrescar);
        botonBorrar = findViewById(R.id.botonBorrar);

        datos = findViewById(R.id.datos);

        addTitulo = findViewById(R.id.addTitulo);
        addDireccion = findViewById(R.id.addDireccion);
        addCategoria = findViewById(R.id.addCategoria);
        addDesc = findViewById(R.id.addDesc);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        userDao = db.userDao();


        //List<User> users = userDao.getAll();

        botonAniadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = new User();
                u.ocio = addTitulo.getText().toString();
                u.categoria = addCategoria.getText().toString();
                u.descripcion = addDesc.getText().toString();
                u.direccion = addDireccion.getText().toString();
                userDao.insertAll(u);

            }
        });

        //boton borrar corregir
        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        botonRefrescar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> ocios = userDao.getAll();
                String uDatos = "";
                for(User a : ocios){
                    uDatos += a.ocio + "-" + a.categoria + "-" + a.descripcion + "-" + a.direccion + "\n";
                }
                datos.setText(uDatos);
            }
        });



    }
}