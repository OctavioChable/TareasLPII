package pokemon;

public class Pikachu extends Pokemon implements EfectoMovimiento{
    
    private Tipo tipoUno;
            
    public Pikachu( int nivel){
        
	super("Pikachu",nivel,95,54,49,40,49,90);
        ListaMovimientos listaMovimientos = new ListaMovimientos();
                
        setMovimiento(0, listaMovimientos.buscarMovimientosPorNombre("Trueno"));
        setMovimiento(1, listaMovimientos.buscarMovimientosPorNombre("Rayo"));
        setMovimiento(2, listaMovimientos.buscarMovimientosPorNombre("Ataque rapido"));
        setMovimiento(3, listaMovimientos.buscarMovimientosPorNombre("Ataque rapido"));
        this.tipoUno = Tipo.ELECTRICO;
    }

   
    @Override
    public double obtenerEfectividad(Movimiento movimiento) {
        double efectividad = 1.0;
        if(movimiento.getTipo() == Tipo.ACERO) efectividad = 0.5;
        if(movimiento.getTipo() == Tipo.ELECTRICO) efectividad = 0.5;
        if(movimiento.getTipo() == Tipo.TIERRA) efectividad = 2.0;
        if(movimiento.getTipo() == Tipo.VOLADOR) efectividad = 0.5;
        return efectividad;
    }

    @Override
    public double calcularBonificacion(Pokemon pokemon, int pos) {    
        double bonificacion = 1.0;
    
        if(pokemon.getMovimiento(pos).getTipo() == tipoUno){
            bonificacion = 1.5;
        }
        return bonificacion;
    }

    @Override
    public int calcularTipoAtaque(Movimiento movimiento) {
        int ataque = 0;
        if(movimiento.getClaseMovimiento()== ClaseMovimiento.FISICO){
            ataque = this.getAtaque();
        }else if(movimiento.getClaseMovimiento() == ClaseMovimiento.ESPECIAL){
            ataque = this.getAtaqueEspecial();
        }
        return ataque;
    }

    @Override
    public int calcularTipoDefensa(Movimiento movimiento) {
        int defensa = 0;
        if(movimiento.getClaseMovimiento() == ClaseMovimiento.FISICO){
            defensa = getDefensa();
        }else if(movimiento.getClaseMovimiento() == ClaseMovimiento.ESPECIAL){
            defensa = getDefensaEspecial();
        }
        return defensa;
    }

    @Override
    public void EfectoAlAdversario() {
       //por el momento no se usara, ya que no se tomo en cuenta los movimientos de clase ESTADO
       //Los movimientos de clase ESTADO, pueden modificar el ataque o la defensa del enemigo o del operador
    }

    @Override
    public void EfectoUsuario() {
        //por el momento no se usara, ya que no se tomo en cuenta los movimientos de clase ESTADO
        //Los movimientos de clase ESTADO, pueden modificar el ataque o la defensa del enemigo o del operador
    }
    
}