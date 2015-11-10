package com.example.luis.pruebaas1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Carlos on 10/11/2015.
 */
public class Niveles extends AppCompatActivity implements View.OnClickListener{
    Button facil,medio,dificil,back;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);
        titleActivity();
        facil = (Button) findViewById(R.id.buttonFacil);
        medio = (Button) findViewById(R.id.buttonMedio);
        dificil = (Button) findViewById(R.id.buttonDificil);
        back = (Button) findViewById(R.id.buttonBack);
        facil.setOnClickListener(this);
        medio.setOnClickListener(this);
        dificil.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buttonFacil:
                Intent facil = new Intent(Niveles.this,SecondAct.class);
                startActivity(facil);
                break;
            case R.id.buttonMedio:
                break;
            case R.id.buttonDificil:
                break;
            case R.id.buttonBack:
                finish();
                break;
        }
    }
    private  void titleActivity(){
        this.setTitle(getResources().getString(R.string.nivel));
    }
}
