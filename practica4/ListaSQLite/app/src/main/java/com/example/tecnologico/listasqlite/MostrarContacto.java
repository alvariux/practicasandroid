package com.example.tecnologico.listasqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.widget.EditText;

public class MostrarContacto extends AppCompatActivity {

    @BindView(R.id.mostrar_txt_nombre) EditText txt_nombre;
    @BindView(R.id.mostrar_txt_telefono) EditText txt_telefono;
    @BindView(R.id.mostrar_txt_email) EditText txt_email;

    private Persona personaObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_contacto);

        ButterKnife.bind(this);

        this.personaObj = (Persona)getIntent().getSerializableExtra(MainActivity.PERSONA_SERIAL);

        this.txt_nombre.setText(personaObj.getNombre());
        this.txt_telefono.setText(personaObj.getTelefono());
        this.txt_email.setText(personaObj.getEmail());
    }
}
