package es.esy.elvinmorales48.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import es.esy.elvinmorales48.petagram.R;
import es.esy.elvinmorales48.petagram.db.ConstructorMascota;
import es.esy.elvinmorales48.petagram.pojo.Mascota;

/**
 * Created by ELVIN on 12/06/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<mascotaViewHolder>{

    private ArrayList<Mascota> item;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> item, Activity activity){
        this.item = item;
        this.activity = activity;
    }


    @Override
    public mascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        mascotaViewHolder mascota = new mascotaViewHolder(v);
        return mascota;
    }

    @Override
    public void onBindViewHolder(final mascotaViewHolder mascotaHolder, int position) {
        final Mascota mascota = item.get(position);
        mascotaHolder.nombre.setText(mascota.getNombre());
        mascotaHolder.foto.setImageResource(mascota.getFoto());
        mascotaHolder.foto.setBackgroundColor(mascota.getColor());
        mascotaHolder.likes.setText(String.valueOf(mascota.getLikes()));

        mascotaHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "Diste like a "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
                ConstructorMascota constructorMascota = new ConstructorMascota(activity);
                constructorMascota.darLikeMascota(mascota);
                mascotaHolder.likes.setText(String.valueOf(constructorMascota.obtenerLikesMascota(mascota)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.item.size();
    }
}
