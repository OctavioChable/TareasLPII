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
        
        //movimientos tipo Electrico
        movimientos.add(new Movimiento("Trueno",110,Tipo.ELECTRICO,10,ClaseMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Rayo",40,Tipo.ELECTRICO,30,ClaseMovimiento.FISICO));
        //movimientos tipo Normal
        movimientos.add(new Movimiento("Ataque rapido",40,Tipo.NORMAL,30,ClaseMovimiento.FISICO));
        //movimientos tipo Planta
        movimientos.add(new Movimiento("Bomba germen",80,Tipo.PLANTA,15,ClaseMovimiento.FISICO));
        movimientos.add(new Movimiento("Hoja afilada",55,Tipo.PLANTA,25,ClaseMovimiento.FISICO));
        movimientos.add(new Movimiento("Rayo solar",120,Tipo.PLANTA,10,ClaseMovimiento.FISICO));
        //movimientos tipo siniestro
        movimientos.add(new Movimiento("Buena baza",60,Tipo.SINIESTRO,10,ClaseMovimiento.FISICO));
        movimientos.add(new Movimiento("Mordisco",60,Tipo.SINIESTRO,25,ClaseMovimiento.FISICO));
        
        //movimientos tipo planta
        movimientos.add(new Movimiento("Follaje",40,Tipo.PLANTA,40,ClaseMovimiento.FISICO));
        
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
