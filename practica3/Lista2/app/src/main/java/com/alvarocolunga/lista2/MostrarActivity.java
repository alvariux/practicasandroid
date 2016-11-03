package com.alvarocolunga.lista2;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.content.pm.PackageManager;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

public class MostrarActivity extends AppCompatActivity {

    @BindView(R.id.mostrar_nom_textView_btn) TextView nom_txt;
    @BindView(R.id.mostrart_email_textView_btn) TextView email_txt;
    @BindView(R.id.mostrar_tel_textView_btn) TextView tel_txt;
    @BindView(R.id.mostrarimageView) ImageView foto;

    private Persona personaObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        ButterKnife.bind(this);

        this.personaObj = (Persona)getIntent().getSerializableExtra(MainActivity.PERSONA_SERIAL);

        this.nom_txt.setText(personaObj.getNombre());
        this.email_txt.setText(personaObj.getEmail());
        this.tel_txt.setText(personaObj.getTelefono());
        this.foto.setImageResource(personaObj.getFoto());

    }

    @OnClick(R.id.mostrart_email_textView_btn)
    public void click_email()
    {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"+personaObj.getEmail()));
        startActivity(emailIntent);
    }

    @OnClick(R.id.mostrar_tel_textView_btn)
    public void click_tel()
    {
        Intent callIntent;

        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (result == PackageManager.PERMISSION_GRANTED) {

            callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+personaObj.getTelefono()));
            startActivity(callIntent);
        }

    }
}
