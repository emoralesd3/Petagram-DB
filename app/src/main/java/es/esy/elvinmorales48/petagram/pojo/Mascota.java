package es.esy.elvinmorales48.petagram.pojo;

/**
 * Created by ELVIN on 28/05/2016.
 */
public class Mascota {

    private int id;
    private int foto;
    private String nombre;
    private int color;
    private int likes;

    public Mascota(int foto, String nombre, int color, int likes){
        this.foto = foto;
        this.nombre = nombre;
        this.color = color;
        this.likes = likes;
    }

    public Mascota(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
