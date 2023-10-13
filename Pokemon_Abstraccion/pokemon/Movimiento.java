/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author octav
 */
public class Movimiento {
    
    private String nombre;
    private int puntosDeAtaque,pp;
    private Tipo tipo;
    
    public Movimiento( String nombre, int puntosDeAtaque, Tipo tipo, int pp){
        
        this.nombre = nombre;
        this.pp = pp;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public int getPp() {
        return pp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
    
}
