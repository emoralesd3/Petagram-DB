package es.esy.elvinmorales48.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import es.esy.elvinmorales48.petagram.adapter.MascotaAdaptador;
import es.esy.elvinmorales48.petagram.db.ConstructorMascota;
import es.esy.elvinmorales48.petagram.fragment.IRecyclerViewFragmentView;
import es.esy.elvinmorales48.petagram.pojo.Mascota;

/**
 * Created by ELVIN on 22/06/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascota = new ConstructorMascota(context);
        mascotas = constructorMascota.obtenerDatos();
        mostrarMascotasRecyclerView();
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptadorRecyclerView(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
