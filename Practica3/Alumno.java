public class Alumno{

	String Nombre;
	int matricula;
	int grado;
	char grupo;
	Tutor tutor = new Tutor("Gonzalo Hernandez", 39);
	
	public Alumno(String Nombre, int matricula, int grado, char grupo){
		this.Nombre = Nombre;
		this.matricula = matricula;
		this.grado = grado;
		this.grupo = grupo;
	}
	
	public Tutor getTutor(){
		return tutor;
	}
	
}