package com.example.luis.pruebaas1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class SecondAct extends ActionBarActivity implements View.OnClickListener {

    Boolean Unavez = true;

    Random random = new Random();
    TextView Pregunta,Score;
    Button Resp1,Resp2,Resp3;
    int rand1, rand2, rand3, realResp,score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        titleActivity();
        //Igualacion de objeto Java con Objeto Xml
        Pregunta = (TextView) findViewById(R.id.Pregunta);
        Score = (TextView) findViewById(R.id.Score);

        Resp1 = (Button) findViewById(R.id.Resp1);
        Resp2 = (Button) findViewById(R.id.Resp2);
        Resp3 = (Button) findViewById(R.id.Resp3);

        //Esperan el click
        Resp1.setOnClickListener(this);
        Resp2.setOnClickListener(this);
        Resp3.setOnClickListener(this);

        //Sí funcionó, puto
        if(Unavez){
            GeneracionRandom();
            Unavez = false;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Cuando se de click a un boton:
    public void onClick(View v){

        //El id del boton seleccionado es v.getId
        switch (v.getId()){

            case R.id.Resp1:
                //Presionó el  boton 1
                if(rand3==1) {
                    //La respuesta era correcta
                    Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT).show();
                    score++;
                    Score.setText(""+score);
                }
                //La respuesta era incorrecta
                else {
                    Toast.makeText(getApplicationContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
                GeneracionRandom();
                break;

            case R.id.Resp2:
                //Presionó el  boton 2
                if(rand3==2) {
                    //La respuesta era correcta
                    Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT).show();
                    score++;
                    Score.setText(""+score);
                }
                //La respuesta era incorrecta
                else {
                    Toast.makeText(getApplicationContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
                GeneracionRandom();
                break;

            case R.id.Resp3:
                //Presionó el  boton 3
                if(rand3==3) {
                    //La respuesta era correcta
                    Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT).show();
                    score++;
                    Score.setText(""+score);
                }
                //La respuesta era incorrecta
                else {
                    Toast.makeText(getApplicationContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                }
                GeneracionRandom();
                break;
        }
    }

    public void GeneracionRandom(){

        rand1 = (int) (random.nextDouble()*10)+1;//Primer valor randonm A
        rand2 = (int) (random.nextDouble()*10)+1;//Segundo varlor random B
        rand3 = (int) (random.nextDouble()*3)+1;//Valor random

        realResp = rand1 + rand2;// A+B = Respuesta

        Pregunta.setText(rand1 + "+" + rand2); // Objeto Pregunta(TextView) = " A + B "

        //Tercer valor aleatorio elije en que boton se ecuentra la respuesta
        switch (rand3){

            case 1:
                //Imprecion de respuestas en los botones.
                Resp1.setText(""+realResp);
                Resp2.setText(""+(realResp+rand3));
                Resp3.setText("" + (realResp + (rand3 * 2)));
                break;

            case 2:
                Resp1.setText(""+(realResp+rand3));
                Resp2.setText(""+realResp);
                Resp3.setText("" + (realResp + (rand3 * 2)));
                break;

            case 3:
                Resp1.setText(""+(realResp+(rand3*2)));
                Resp2.setText(""+(realResp+rand3));
                Resp3.setText("" + realResp);
                break;
        }
    }

    private  void titleActivity(){
        this.setTitle(getResources().getString(R.string.title_activity_second));
    }
}
//Fin :3