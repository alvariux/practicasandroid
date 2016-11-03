package com.alvarocolunga.lista2;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    @BindView(R.id.mainLista) RecyclerView mRecyclerView;
    private ListaAdapter adapter;
    private List<Persona> personas = new ArrayList<>();

    public  final static String PERSONA_SERIAL = "com.alvarocolunga.lista2.ser";

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

    private void prepareData() {

        Persona p = new Persona("Pedro Ramirez","pramirez@hotmail.com","76352451",R.mipmap.boy);
        personas.add(p);

        p = new Persona("Rosa Gonzalez","rgonzalez@yahoo.com","7219780",R.mipmap.girl);
        personas.add(p);

        p = new Persona("Felipe Rodriguez","frodriguez@gmail.com","51725243",R.mipmap.boy);
        personas.add(p);

        p = new Persona("Maria Sanchez","msanchez@outlook.com","925261823",R.mipmap.girl);
        personas.add(p);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view, int position) {
        final Persona p = personas.get(position);

        Intent intent = new Intent(this,MostrarActivity.class);
        Bundle datosBundle = new Bundle();
        datosBundle.putSerializable(PERSONA_SERIAL,p);
        intent.putExtras(datosBundle);

        startActivity(intent);
    }
}
