package com.example.tecnologico.listasqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    @BindView(R.id.main_recyclerViewLista) RecyclerView mRecyclerView;
    private ListaAdapter adapter;
    private List<Persona> personas = new ArrayList<>();

    public  final static String PERSONA_SERIAL = "com.alvarocolunga.listasqlite.ser";
    static final int AGREGAR_CONTACTO = 1;
    static final int MOSTRAR_CONTACTO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new ListaAdapter(personas);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        prepareData();
    }

    private void prepareData()
    {
        PersonaDB persona_db = new PersonaDB(this);

        personas.clear();
        personas.addAll(persona_db.lista());

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View view, int position) {

        final Persona p = personas.get(position);

        Intent intent = new Intent(this,MostrarContacto.class);

        Bundle datosBundle = new Bundle();
        datosBundle.putSerializable(PERSONA_SERIAL,p);
        intent.putExtras(datosBundle);

        startActivityForResult(intent,MOSTRAR_CONTACTO);
    }

    @OnClick(R.id.mainFloatingButton)
    public void clickAgregar()
    {
        Intent intent = new Intent(this,AgregarContacto.class);

        startActivityForResult(intent,AGREGAR_CONTACTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == AGREGAR_CONTACTO) {
            if(resultCode == RESULT_OK)
            {
                prepareData();
            }

            if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this,"CANCELAR",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
