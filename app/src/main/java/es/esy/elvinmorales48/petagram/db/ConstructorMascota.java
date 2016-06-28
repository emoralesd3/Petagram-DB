package es.esy.elvinmorales48.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import es.esy.elvinmorales48.petagram.R;
import es.esy.elvinmorales48.petagram.pojo.Mascota;

/**
 * Created by ELVIN on 22/06/2016.
 */
public class ConstructorMascota {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascota(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> datos = new ArrayList<>();
        datos.add(new Mascota(R.drawable.perro1, "Pirulais",  0xFF00FF00, 5));
        datos.add(new Mascota(R.drawable.perro2, "Terry",     0xFFa8285c, 4));
        datos.add(new Mascota(R.drawable.perro3, "Rambo",     0xFF10D94C, 3));
        datos.add(new Mascota(R.drawable.perro4, "Princesa",  0xFF45694C, 1));
        datos.add(new Mascota(R.drawable.perro5, "Niño",      0xFF426989, 4));
        datos.add(new Mascota(R.drawable.perro6, "Toby",      0xFF7a355b, 6));
        datos.add(new Mascota(R.drawable.perro7, "Wiro",      0xFFd1c1fc, 6));
        datos.add(new Mascota(R.drawable.perro8, "Rocky",     0xFF962489, 2));*/

        BaseDatos db = new BaseDatos(context);
        if(db.estaVacio()){
            insertarMascotas(db);
        }
        return db.obtenerTodasLasMascotas();
    }



    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Pirulais");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Rambo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Terry");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Princesa");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Rocky");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro5);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Niño");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro6);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Sultan");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro7);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Justicia");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro8);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PETS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
