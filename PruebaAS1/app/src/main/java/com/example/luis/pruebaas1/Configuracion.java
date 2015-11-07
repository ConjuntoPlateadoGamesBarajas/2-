package com.example.luis.pruebaas1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;


/**
 * Created by Carlos on 01/10/2015.
 */
public class Configuracion extends Activity{
    private SeekBar seekBar;
    private TextView textView;
    AudioManager audioManager;
    MediaPlayer mediaPlayer;
    Spinner spinnerctrl;
    Button btn;
    CheckBox mute;
    boolean m;
    Locale myLocale;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initializeVariable();
        // Inicializa funciones de audio
        mediaPlayer = MediaPlayer.create(Configuracion.this,R.raw.sound);
        mediaPlayer.start();

        Volumen();
        lenguajes();
        chekBoxVolume();
       /* super.onCreate(savedInstanceState);
        Button back=(Button) findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Configuracion.this, MainActivity.class);
                startActivity(intent);
                onBackPressed();
            }
        });*/

    }

    private void Volumen() {

        try {
            seekBar = (SeekBar)findViewById(R.id.seekBar1);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

            //textView.setText("Covered: " + seekBar.getProgress() + "/" + seekBar.getMax());
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                int progress = 0;
                @Override
                public void onStopTrackingTouch(SeekBar arg0) {
                    //textView.setText("Covered: " + progress + "/" + seekBar.getMax());
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progresValue, boolean arg2) {
                    progress = progresValue;
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
        // Un metodo privado para ayudar a inicializar las variable
    private void initializeVariable(){

        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        textView =(TextView) findViewById(R.id.textView1);
    }

    public  void lenguajes(){
        spinnerctrl = (Spinner) findViewById(R.id.spinner1);
        spinnerctrl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                if (pos == 2) {
                    setLocale("");
                } else if (pos == 3) {
                    setLocale("fr");
                } else if (pos == 4) {
                    setLocale("en");
                }

            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });

    }
    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, Configuracion.class);
        startActivity(refresh);

    }
    public void chekBoxVolume(){

        final SharedPreferences prefs = this.getSharedPreferences("mute", Context.MODE_PRIVATE);
        m = prefs.getBoolean("mute", false);
        mute= (CheckBox) findViewById(R.id.checkBox);
        mute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked() == true) {
                    m = true;
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("mute", true);
                    editor.commit();
                }
                if (buttonView.isChecked() == false) {
                    m = false;
                    System.out.println("unmute");
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("mute", false);
                    editor.commit();
                }

            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent a = new Intent(this,MainActivity.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(a);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

