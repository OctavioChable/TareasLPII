public class Tutor{
	
	String nombre;
	int edad;
	Telefono tel = new Telefono("+52","981","1312704");
	
	public Tutor(String nombre, int edad){
	this.nombre = nombre;
	this.edad = edad;
	}
	public Telefono getTelefono(){
		return tel;
	}
}