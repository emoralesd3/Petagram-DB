package es.esy.elvinmorales48.petagram;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import es.esy.elvinmorales48.petagram.adapter.MascotaAdaptador;
import es.esy.elvinmorales48.petagram.fragment.IRecyclerViewFragmentView;
import es.esy.elvinmorales48.petagram.pojo.Mascota;
import es.esy.elvinmorales48.petagram.presentador.IRecyclerViewFragmentPresenter;
import es.esy.elvinmorales48.petagram.presentador.RecyclerViewFavoritosPresenter;
import es.esy.elvinmorales48.petagram.presentador.RecyclerViewFragmentPresenter;

public class FavoritosActivity extends AppCompatActivity implements IRecyclerViewFragmentView {

    private RecyclerView recicladorFav;
    private RecyclerView.LayoutManager layoutManagerFav;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSub);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FavoritosActivity.this, "Regresando", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        recicladorFav = (RecyclerView) findViewById(R.id.ReciclerView_RecicladorFavorito);
        presenter = new RecyclerViewFavoritosPresenter(this, this);

    }

    @Override
    public void generarLinearLayoutVertical() {
        layoutManagerFav = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recicladorFav.setLayoutManager(layoutManagerFav);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador) {
        recicladorFav.setAdapter(adaptador);
    }
}
