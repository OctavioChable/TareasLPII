import pokemon.PokemonAgua;
import pokemon.PokemonPlanta;

public class BatallaPokemon{

    public static void main(String args[]){
        
        PokemonAgua Squartle = new PokemonAgua("Squartle",10); 
        PokemonPlanta Treecko = new PokemonPlanta("Treecko",10);
	
        Squartle.atacar(3,Treecko);
        System.out.println("");
        Treecko.atacar(3,Squartle);
       
    }	

}