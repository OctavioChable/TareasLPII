package pokemon;
public class PokemonPlanta extends Pokemon{
    public PokemonPlanta(String nombre, int nivel){
        super(nombre,Tipo.PLANTA,nivel);
                
        ListaMovimientos listaMovimientos = new ListaMovimientos();
                
        setMovimiento(0, listaMovimientos.buscarMovimientosPorNombre("Destructor"));
        setMovimiento(1, listaMovimientos.buscarMovimientosPorNombre("Ataque rapido"));
        setMovimiento(2, listaMovimientos.buscarMovimientosPorNombre("Follaje"));
        setMovimiento(3, listaMovimientos.buscarMovimientosPorNombre("Buena baza"));
        
	}
        
        
@Override 
    public double obtenerEfectividad(Pokemon pokemon){
        
        double efectividad = 1.0;
        if(pokemon.getTipo() == Tipo.BICHO) efectividad = 0.0;
        if(pokemon.getTipo() == Tipo.AGUA) efectividad = 2.0;
        return efectividad;
        
    }

}