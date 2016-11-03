package com.alvarocolunga.lista2;

/**
 * Created by acolunga on 9/26/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ListaViewHolder> {

    private List<Persona> personasList;
    private ItemClickListener clickListener;

    public class ListaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.nombreTextView) TextView nombre;
        @BindView(R.id.emailTextView) TextView email;
        @BindView(R.id.telefonoTextView) TextView telefono;
        @BindView(R.id.fotoImageView) ImageView foto;

        public ListaViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setTag(view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

    public ListaAdapter(List<Persona> personas)
    {
        this.personasList = personas;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_row, parent, false);

        return new ListaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {
        Persona persona = personasList.get(position);
        holder.nombre.setText(persona.getNombre());
        holder.email.setText(persona.getEmail());
        holder.telefono.setText(persona.getTelefono());
        holder.foto.setImageResource(persona.getFoto());
    }

    @Override
    public int getItemCount() {
        return personasList.size();
    }
}
