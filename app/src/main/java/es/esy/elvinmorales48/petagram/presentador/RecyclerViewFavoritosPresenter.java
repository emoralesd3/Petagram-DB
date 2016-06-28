package es.esy.elvinmorales48.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import es.esy.elvinmorales48.petagram.db.ConstructorMascota;
import es.esy.elvinmorales48.petagram.db.MascotasFavoritas;
import es.esy.elvinmorales48.petagram.fragment.IRecyclerViewFragmentView;
import es.esy.elvinmorales48.petagram.pojo.Mascota;

/**
 * Created by ELVIN on 26/06/2016.
 */
public class RecyclerViewFavoritosPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private MascotasFavoritas mascotasFavoritas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFavoritosPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        mascotasFavoritas = new MascotasFavoritas(context);
        mascotas = mascotasFavoritas.obtenerDatos();
        mostrarMascotasRecyclerView();
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptadorRecyclerView(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
