package com.example.luis.pruebaas1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView image;
    Button boton,boton2;
    EditText text;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleActivity();
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound);
        //mediaPlayer.start();
        //Igualacion de objeto Java con Objeto Xml
        image = (ImageView) findViewById(R.id.imageView);
        boton = (Button) findViewById(R.id.button);
        boton2 = (Button) findViewById(R.id.button2);
        text = (EditText) findViewById(R.id.editText);

        //Esperan el click
        boton.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        switch (v.getId()) {

            //El id del boton seleccionado es v.getId
            case R.id.button:

                //Se manda a llamar la SecondAct
                Intent intent = new Intent(MainActivity.this,SecondAct.class);
                startActivity(intent);

                //Esto es una mamamda
                if(image.isShown()){
                    image.setVisibility(View.INVISIBLE);
                }
                else
                    image.setVisibility(View.VISIBLE);
                break;

            //Esto también
            case R.id.button2:
               // Toast.makeText(getApplicationContext(),R.string.Pao,Toast.LENGTH_SHORT).show();
                Intent settings = new Intent(MainActivity.this,Configuracion.class);
                startActivity(settings);
                break;
        }
    }
    private  void titleActivity(){
        this.setTitle(getResources().getString(R.string.app_name));
    }
}
