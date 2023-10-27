package pokemon;


public abstract class Pokemon{
    
    private int HP, nivel;
    private String nombre;
    private Tipo tipo;
    private Movimiento[] movimiento;
	
    public Pokemon(String nombre, Tipo tipo, int nivel){
        
	this.nombre = nombre;
	this.tipo = tipo;
	this.nivel = nivel;
	this.HP = 250;
        this.movimiento = new Movimiento[4];
        
    }

    public String getNombre(){
	return nombre;
    }
    public Tipo getTipo(){
	return tipo;
    }
    public int getNivel(){
	return nivel;
    }
    public int getHp(){
	return HP;
    }

    private void calculaDanio(int danio, double efectividad){
        
        double puntosRestados = danio * efectividad;
        this.HP -= puntosRestados;
	System.out.printf("%s recibe %.2f puntos de danio \n", this.getNombre(), puntosRestados);
        
    }

    public void recibirAtaque(Movimiento movimiento, double efectividad){
        
	System.out.printf("%s recibe ATK %s\n", this.getNombre(),movimiento.getNombre());
	calculaDanio(movimiento.getPuntosDeAtaque(),efectividad);
        
    }

    protected boolean seHaConcretadoAtaque (Movimiento movimiento, Pokemon pokemon){
        
        System.out.printf("%s ataca a %s con %s\n",this.getNombre(),pokemon.getNombre(),movimiento.getNombre());
        double efectividad = obtenerEfectividad(pokemon);
        if(movimiento.getPp()>0){
            pokemon.recibirAtaque(movimiento,efectividad);
            return true;
        }else {
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        }
        
    }

    public void atacar(int m, Pokemon pokemon){
        
        Movimiento movimien = getMovimiento(m);
        boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimien, pokemon);
        if (seHaConcretadoAtaque){
           pokemon.getMovimiento(m).setPp(movimien.getPp()-1);
        }
        
    }   

    public abstract double obtenerEfectividad(Pokemon pokemon);	

    public void setMovimiento(int pos, Movimiento movimiento){
        this.movimiento[pos] = movimiento;
    }

    public Movimiento getMovimiento(int pos){
        return movimiento[pos];
    }

}