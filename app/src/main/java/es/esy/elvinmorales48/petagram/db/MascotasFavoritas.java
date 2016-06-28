package es.esy.elvinmorales48.petagram.db;

import android.content.Context;

import java.util.ArrayList;

import es.esy.elvinmorales48.petagram.pojo.Mascota;

/**
 * Created by ELVIN on 26/06/2016.
 */
public class MascotasFavoritas {

    private Context context;

    public MascotasFavoritas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);

        return db.obtenerLasMascotasFavoritas();
    }
}
