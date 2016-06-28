package es.esy.elvinmorales48.petagram.fragment;

import java.util.ArrayList;

import es.esy.elvinmorales48.petagram.adapter.MascotaAdaptador;
import es.esy.elvinmorales48.petagram.pojo.Mascota;

/**
 * Created by ELVIN on 22/06/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador);
}
