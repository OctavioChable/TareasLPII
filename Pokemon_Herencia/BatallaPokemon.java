public class BatallaPokemon{

public static void main(String args[]){
	PokemonAgua Squartle = new PokemonAgua("Squartle",10); 
	PokemonPlanta Treecko = new PokemonPlanta("Treecko",10);
	
	Squartle.atacar("pistola agua",Treecko);
	Treecko.atacar("Ataque rapido",Squartle);
}	

}