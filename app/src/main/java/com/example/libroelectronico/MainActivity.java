package com.example.libroelectronico;

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
    public void verObra(View view){
        Intent ver_obra = new Intent(this, MainActivity2.class);
        startActivity(ver_obra);
    }

}