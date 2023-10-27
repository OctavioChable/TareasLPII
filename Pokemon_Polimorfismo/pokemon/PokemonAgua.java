package pokemon;

public class PokemonAgua extends Pokemon{
    public PokemonAgua(String nombre, int nivel){
        
	super(nombre, Tipo.AGUA,nivel);
        ListaMovimientos listaMovimientos = new ListaMovimientos();
                
        setMovimiento(0, listaMovimientos.buscarMovimientosPorNombre("Placaje"));
        setMovimiento(1, listaMovimientos.buscarMovimientosPorNombre("Mordisco"));
        setMovimiento(2, listaMovimientos.buscarMovimientosPorNombre("Cabezazo"));
        setMovimiento(3, listaMovimientos.buscarMovimientosPorNombre("Giro rapido"));
                             
    }

@Override 
    public double obtenerEfectividad(Pokemon pokemon){
        
        double efectividad = 1.0;
        if(pokemon.getTipo() == Tipo.PLANTA) efectividad = 0.0;
        if(pokemon.getTipo() == Tipo.TIERRA) efectividad = 2.0;
        return efectividad;
        
    }
    
}