package es.esy.elvinmorales48.petagram.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.esy.elvinmorales48.petagram.R;
import es.esy.elvinmorales48.petagram.adapter.PerfilAdaptador;
import es.esy.elvinmorales48.petagram.pojo.Perfil;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    public ArrayList<Perfil> datos;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        //ReciclerView
        datos = new ArrayList<Perfil>();
        datos.add(new Perfil(R.drawable.perro1,2));
        datos.add(new Perfil(R.drawable.perro1,7));
        datos.add(new Perfil(R.drawable.perro1,5));
        datos.add(new Perfil(R.drawable.perro1,1));
        datos.add(new Perfil(R.drawable.perro1,8));
        datos.add(new Perfil(R.drawable.perro1,3));
        datos.add(new Perfil(R.drawable.perro1,12));
        datos.add(new Perfil(R.drawable.perro1,20));
        datos.add(new Perfil(R.drawable.perro1,14));
        datos.add(new Perfil(R.drawable.perro1, 8));
        datos.add(new Perfil(R.drawable.perro1, 3));
        datos.add(new Perfil(R.drawable.perro1, 12));
        datos.add(new Perfil(R.drawable.perro1,7));
        datos.add(new Perfil(R.drawable.perro1,5));
        datos.add(new Perfil(R.drawable.perro1,1));

        RecyclerView reciclador = (RecyclerView) v.findViewById(R.id.RecyclerView_gridPerfil);
        GridLayoutManager gridPerfil = new GridLayoutManager(getActivity(), 3);
        gridPerfil.setOrientation(GridLayoutManager.VERTICAL);
        reciclador.setLayoutManager(gridPerfil);
        PerfilAdaptador recyclerAdapter = new PerfilAdaptador(datos);
        reciclador.setAdapter(recyclerAdapter);

        return v;
    }
}