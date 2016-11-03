package com.example.tecnologico.listasqlite;

import java.util.List;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

/**
 * Created by tecnologico on 17/10/2016.
 */
public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ListaViewHolder> {

    private List<Persona> personasList;
    private ItemClickListener clickListener;

    public class ListaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.renglon_nombre_textView) TextView nombre;
        @BindView(R.id.renglon_email_textView) TextView email;
        @BindView(R.id.renglon_telefono_textView) TextView telefono;
        int id;

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
                .inflate(R.layout.lista_renglon, parent, false);

        return new ListaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {
        Persona persona = personasList.get(position);
        holder.nombre.setText(persona.getNombre());
        holder.email.setText(persona.getEmail());
        holder.telefono.setText(persona.getTelefono());
        holder.id = persona.getId();
    }

    @Override
    public int getItemCount() {
        return personasList.size();
    }
}
