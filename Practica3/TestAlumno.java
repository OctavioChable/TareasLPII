public class TestAlumno{

	public static void main(String args[]){
	Alumno alumno1 = new Alumno("Juan Hernandez",70192,3,'B');
	
	Telefono telefono = alumno1.getTutor().getTelefono();
	System.out.println("numero del tutor:  " + telefono.toString());
	}
}