/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;
import java.util.ArrayList;
/**
 *
 * @author octav
 */
public class ListaMovimientos {
    
    private ArrayList<Movimiento> movimientos  = new ArrayList<>();
    
    public ListaMovimientos(){
        
        //movimientos tipo normal
        movimientos.add(new Movimiento("Destructor",40,Tipo.NORMAL,35));
        movimientos.add(new Movimiento("Ataque rapido",40,Tipo.NORMAL,30));
        movimientos.add(new Movimiento("Placaje",40,Tipo.NORMAL,35));
        movimientos.add(new Movimiento("Cabezazo",130,Tipo.NORMAL,10));
        movimientos.add(new Movimiento("Giro rapido",50,Tipo.NORMAL,40));
        
        //movimientos tipo siniestro
        movimientos.add(new Movimiento("Buena baza",60,Tipo.SINIESTRO,10));
        movimientos.add(new Movimiento("Mordisco",60,Tipo.SINIESTRO,25));
        
        //movimientos tipo planta
        movimientos.add(new Movimiento("Follaje",40,Tipo.PLANTA,40));
        
}


    public Movimiento buscarMovimientosPorNombre(String nombre){
        for(Movimiento movimiento : movimientos){
            if(movimiento.getNombre().equals(nombre)){
                return movimiento;
            }
        }
        return null;
    }
    
}
