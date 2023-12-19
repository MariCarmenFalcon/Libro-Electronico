package com.example.libroelectronico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    public DrawerLayout drawer;
    public int numPaginaActual = 1;
    public TextView num;
   // public EditText pagNumber;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        drawer = findViewById(R.id.drawerLayout);
        num = findViewById(R.id.pagNumber);

        //Enlace de menuDrawer a pag. fragment
        Button button1 = findViewById(R.id.button6);
        Button button2 = findViewById(R.id.button7);
        Button button3 = findViewById(R.id.button8);
        Button button4 = findViewById(R.id.button9);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPaginaActual = 1;
                cargaFragment(new BlankFragment1());
                drawer.closeDrawer(GravityCompat.END);
                //Tengo que actualizar la pag
                num.setText(String.valueOf(numPaginaActual));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPaginaActual = 2;
                cargaFragment(new BlankFragment2());
                drawer.closeDrawer(GravityCompat.END);
                num.setText(String.valueOf(numPaginaActual));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPaginaActual = 3;
                cargaFragment(new BlankFragment3());
                drawer.closeDrawer(GravityCompat.END);
                num.setText(String.valueOf(numPaginaActual));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPaginaActual = 4;
                cargaFragment(new BlankFragment4());
                drawer.closeDrawer(GravityCompat.END);
                num.setText(String.valueOf(numPaginaActual));
            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.framePrincipal, new BlankFragment1()).commit();
    }

    public void botonDrawer(View view){
        drawer.openDrawer(GravityCompat.END);
    }

    public void buttonSiguiente(View view){

        if (numPaginaActual < 4) {
            //Aumento solo si es menor a 4
            numPaginaActual++;
        } else {
            numPaginaActual = 1;
        }
        //Actualizo la nueva pag
        num.setText(String.valueOf(numPaginaActual));

        switch (numPaginaActual){
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.framePrincipal,
                        new BlankFragment1()).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.framePrincipal,
                        new BlankFragment2()).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.framePrincipal,
                        new BlankFragment3()).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.framePrincipal,
                        new BlankFragment4()).commit();
                break;
        }

    }

    public void buttonAtras(View view) {
        //Hago lo mismo pero para el boton de atras
        if (numPaginaActual > 1) {
            //Decremento solo si es mayor que 1
            numPaginaActual--;
        } else {
            numPaginaActual = 4;
        }

        num.setText(Integer.toString(numPaginaActual));

        switch (numPaginaActual) {
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.framePrincipal,
                        new BlankFragment1()).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.framePrincipal,
                        new BlankFragment2()).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.framePrincipal,
                        new BlankFragment3()).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.framePrincipal,
                        new BlankFragment4()).commit();
                break;
        }
    }
    private void cargaFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.framePrincipal, fragment).commit();
    }

}
