package es.esy.elvinmorales48.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import es.esy.elvinmorales48.petagram.R;

/**
 * Created by ELVIN on 12/06/2016.
 */
public class mascotaViewHolder extends RecyclerView.ViewHolder {

    TextView nombre;
    ImageView foto;
    TextView likes;
    ImageButton btnLike;

    public mascotaViewHolder(View itemView) {
        super(itemView);
        nombre = (TextView) itemView.findViewById(R.id.TextView_Nombre);
        foto = (ImageView) itemView.findViewById(R.id.ImageViewMascota);
        likes = (TextView) itemView.findViewById(R.id.TextView_likes);
        btnLike = (ImageButton) itemView.findViewById(R.id.ImageButton_likeHuesoBlanco);
    }
}
