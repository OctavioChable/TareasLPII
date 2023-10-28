package pokemon;
public class Bulbasaur extends Pokemon implements EfectoMovimiento{
    
    private Tipo tipoUno, tipoDos;
    
    public Bulbasaur(int nivel){
        super("Bulbasaur",nivel,105,48,63,48,63,45);
                
        ListaMovimientos listaMovimientos = new ListaMovimientos();
                
        setMovimiento(0, listaMovimientos.buscarMovimientosPorNombre("Bomba germen"));
        setMovimiento(1, listaMovimientos.buscarMovimientosPorNombre("Rayo solar"));
        setMovimiento(2, listaMovimientos.buscarMovimientosPorNombre("Hoja afilada"));
        setMovimiento(3, listaMovimientos.buscarMovimientosPorNombre("Placaje"));
        
        this.tipoUno = Tipo.PLANTA;
        this.tipoDos = Tipo.VENENO;
        
	}

    @Override
    public double obtenerEfectividad(Movimiento movimiento) {
        double efectividadUno = 1.0;
        double efectividadDos = 1.0;
        double efectividad;
        //efectividad TipoUno
        if(movimiento.getTipo() == Tipo.AGUA) efectividadUno = 0.5;
        if(movimiento.getTipo() == Tipo.BICHO ) efectividadUno = 2.0;
        if(movimiento.getTipo() == Tipo.ELECTRICO) efectividadUno = 0.5;
        if(movimiento.getTipo() == Tipo.FUEGO) efectividadUno = 2.0;
        if(movimiento.getTipo() == Tipo.HIELO) efectividadUno = 2.0;
        if(movimiento.getTipo() == Tipo.PLANTA) efectividadUno = 0.5;
        if(movimiento.getTipo() == Tipo.TIERRA) efectividadUno = 0.5;
        if(movimiento.getTipo() == Tipo.VENENO) efectividadUno = 2.0;
        if(movimiento.getTipo() == Tipo.VOLADOR) efectividadUno = 2.0;
        
        //efectividad TipoDos
        if(movimiento.getTipo() == Tipo.BICHO) efectividadDos = 0.5;
        if(movimiento.getTipo() == Tipo.HADA) efectividadDos = 0.5;
        if(movimiento.getTipo() == Tipo.LUCHA) efectividadDos = 0.5;
        if(movimiento.getTipo() == Tipo.PLANTA) efectividadDos = 0.5;
        if(movimiento.getTipo() == Tipo.PSIQUICO) efectividadDos = 2.0;
        if(movimiento.getTipo() == Tipo.TIERRA) efectividadDos = 2.0;
        if(movimiento.getTipo() == Tipo.VENENO) efectividadDos = 0.5;
        
        efectividad = efectividadUno*efectividadDos;
        
        return efectividad;
    }

    @Override
    public double calcularBonificacion(Pokemon pokemon, int pos) {
       double bonificacion = 1.0;
        if(pokemon.getMovimiento(pos).getTipo() == this.tipoDos){
            bonificacion = 1.5;
        }else if(pokemon.getMovimiento(pos).getTipo()== this.tipoUno){
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
        if(movimiento.getClaseMovimiento()== ClaseMovimiento.FISICO){
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