package es.esy.elvinmorales48.petagram.pojo;

/**
 * Created by ELVIN on 20/06/2016.
 */
public class Perfil {
    private int foto;
    private int meGusta;

    public Perfil(int foto, int meGusta){
        this.foto = foto;
        this.meGusta = meGusta;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }
}
