package com.example.tecnologico.listasqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AgregarContacto extends AppCompatActivity {

    @BindView(R.id.agregar_txt_nombre) EditText txt_nombre;
    @BindView(R.id.agregar_txt_telefono) EditText txt_telefono;
    @BindView(R.id.agregar_txt_email) EditText txt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrergar_contacto);

        ButterKnife.bind(this);

        this.txt_nombre.setText("");
        this.txt_telefono.setText("");
        this.txt_email.setText("");
    }

    @OnClick(R.id.agregar_button_aceptar)
    public void Aceptar()
    {
        PersonaDB persona_db = new PersonaDB(this);

        persona_db.agregar(new Persona(0,txt_nombre.getText().toString(),txt_email.getText().toString(),txt_telefono.getText().toString()));

        setResult(RESULT_OK);
        finish();
    }

    @OnClick(R.id.agregar_button_cancelar)
    public void Cancelar()
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}
