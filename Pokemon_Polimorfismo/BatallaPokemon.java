import pokemon.Pikachu;
import pokemon.Bulbasaur;
import pokemon.Pokemon;

public class BatallaPokemon{

    public static void main(String args[]){
        
        Pokemon Pikachu = new Pikachu(50); 
        Pokemon Bulbasaur = new Bulbasaur(50);
	
        Pikachu.atacar(3,Bulbasaur);
        System.out.println("");
        Bulbasaur.atacar(3,Pikachu);
       
    }	

}