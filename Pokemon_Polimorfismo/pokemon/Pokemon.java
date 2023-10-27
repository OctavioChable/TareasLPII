package pokemon;


public abstract class Pokemon{
    
    private int SP, nivel, ataque, ataqueEspecial, defensa, defensaEspecial, velocidad;
    private String nombre;
    private Movimiento[] movimiento;
	
    public Pokemon(String nombre, int nivel, int SP, int ataque, int ataqueEspecial, int defensa, int defensaEspecial, int velocidad){
        
	this.nombre = nombre;
	this.nivel = nivel;
	this.SP = SP;
        this.movimiento = new Movimiento[4];
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        this.defensa = defensa;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        
    }

    public int getSP() {
        return SP;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    
    public String getNombre(){
	return nombre;
    }
    public int getNivel(){
	return nivel;
    }

    private void calculaDanio(double bonificacion, double efectividad, int nivel, Movimiento movimiento){
        int variacion = ((int)Math.floor(Math.random()*100+85));
        double danio = (0.2*nivel)+1;
        danio *=(calcularTipoAtaque(movimiento)*movimiento.getPuntosDeAtaque());
        danio /=(25*calcularTipoDefensa(movimiento));
        danio += 2;
        danio *= (0.01*bonificacion*efectividad*variacion);
        double puntosRestados = danio;
        this.SP -= puntosRestados;
	System.out.printf("%s recibe %.2f puntos de danio \n", this.getNombre(), puntosRestados);
        
    }

    public void recibirAtaque(Movimiento movimiento, double bonificacion){
        double efectividad = this.obtenerEfectividad(movimiento);
	System.out.printf("%s recibe ATK %s\n", this.getNombre(),movimiento.getNombre());
	calculaDanio(bonificacion, efectividad, this.nivel, movimiento);
        
    }

    protected boolean seHaConcretadoAtaque (Movimiento movimiento, Pokemon pokemon, int m){
        
        System.out.printf("%s ataca a %s con %s\n",this.getNombre(),pokemon.getNombre(),movimiento.getNombre());
        double bonificacion = calcularBonificacion(pokemon, m);
        if(movimiento.getPp()>0){
            pokemon.recibirAtaque(movimiento,bonificacion);
            return true;
        }else {
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        }
        
    }

    public void atacar(int m, Pokemon pokemon){
        
        Movimiento movimien = getMovimiento(m);
        boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimien, pokemon, m);
        if (seHaConcretadoAtaque){
           pokemon.getMovimiento(m).setPp(movimien.getPp()-1);
        }
        
    }   

    public abstract double obtenerEfectividad(Movimiento movimiento);	
    
    public abstract double calcularBonificacion(Pokemon pokemon, int pos);
    
    public abstract int calcularTipoAtaque(Movimiento movimiento);
    
    public abstract int calcularTipoDefensa(Movimiento movimiento);

    public void setMovimiento(int pos, Movimiento movimiento){
        this.movimiento[pos] = movimiento;
    }

    public Movimiento getMovimiento(int pos){
        return movimiento[pos];
    }

}