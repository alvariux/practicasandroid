package com.example.lista;

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

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    @BindView(R.id.main_recyclerViewLista) RecyclerView mRecyclerView;
    private ListaAdapter adapter;
    private List<Persona> personas = new ArrayList<>();

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

        Persona p = new Persona("Pedro Ramirez","pramirez@hotmail.com","76352451");
        personas.add(p);

        p = new Persona("Miguel Gonzalez","mgonzalez@yahoo.com","7219780");
        personas.add(p);

        p = new Persona("Felipe Rodriguez","frodriguez@gmail.com","51725243");
        personas.add(p);

        p = new Persona("Jaime Sanchez","jsanchez@outlook.com","925261823");
        personas.add(p);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view, int position) {
        final Persona p = personas.get(position);

        Toast.makeText(this,p.getNombre(),Toast.LENGTH_SHORT).show();

    }
}
