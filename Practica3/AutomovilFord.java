
public class AutomovilFord {
	
	int velocidad;						// La velocidad a la que se desplaza el auto
	String color;						// El color del auto
	public String modelo;					// El modelo del auto
	Motor motor;						// El motor del auto
	public static final String marca = "Ford";	// La marca del auto
		
	
	public AutomovilFord(String modelo, String color){
		this.modelo = modelo;
		this.color = color;
		velocidad = 0;
		motor = new Motor();
	}
	
	
	public AutomovilFord(){
		this("EcoSport", "Azul");
	}
	
	
	public void encenderMotor() {
		motor.setEncendido(true);
		System.out.println("Motor encendido");
	}
	
	
	public void apagarMotor() {
		motor.setEncendido(false);
		System.out.println("Motor apagado");
	}
	
	
	public void acelerar() {
		if (motor.getEncendido()) {
			motor.revolucionar();		
			velocidad = (motor.getRevoluciones() / 100);
			System.out.println("Vamos a " + velocidad + " kph");			
		} else {
			System.out.println("El motor esta apagado!");
		}
	}
	
	
	public void frenar(int cantidad) {
		motor.setRevoluciones(cantidad);
		if(velocidad < 0) velocidad = 0;
		System.out.println("Vamos a " + velocidad + " kph");	
	}
	

	public int getVelocidad() {
		return velocidad;
	}
}