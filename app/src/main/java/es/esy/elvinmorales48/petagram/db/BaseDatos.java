package es.esy.elvinmorales48.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import es.esy.elvinmorales48.petagram.pojo.Mascota;

/**
 * Created by ELVIN on 22/06/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS + "(" +
                                        ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_PETS_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_PETS_FOTO + " INTEGER" +
                                        ")";

        String queryCrearTablaLikesPets = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_PETS + "(" +
                                            ConstantesBaseDatos.TABLE_LIKES_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            ConstantesBaseDatos.TABLE_LIKES_PETS_ID_MASCOTA + " INTEGER, " +
                                            ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES + " INTEGER, " +
                                            "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_PETS_ID_MASCOTA + ") " +
                                            "REFERENCES "+ ConstantesBaseDatos.TABLE_PETS + "(" +ConstantesBaseDatos.TABLE_PETS_ID+ ")" +
                                            ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesPets);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_PETS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_PETS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES+") as likes "+
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_PETS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PETS_ID_MASCOTA + "=" + mascotaActual.getId() ;

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerLasMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM mascota, mascota_likes WHERE numero_likes < 100 LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES+") as likes "+
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_PETS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PETS_ID_MASCOTA + "=" + mascotaActual.getId() ;

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public boolean estaVacio() {
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        boolean vacio = true;
        if (registros.getCount() > 0) vacio = false;
        db.close();

        return vacio;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_PETS, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES+")"+
                " FROM "+ ConstantesBaseDatos.TABLE_LIKES_PETS+
                " WHERE "+ ConstantesBaseDatos.TABLE_LIKES_PETS_ID_MASCOTA + "="+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
           likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
