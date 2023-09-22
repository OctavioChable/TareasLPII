public class Telefono{

	String pais;
	String lada;
	String numero; 
	String numTel;
	
	public Telefono(String pais, String lada, String numero){
		this.pais = pais;
		this.lada = lada;
		this.numero = numero;
	}
	
	public String toString(){
	numTel = pais.concat(" ").concat(lada).concat(numero);
	return numTel;
	}
	
}