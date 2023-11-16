import java.util.InputMismatchException;
import java.util.Scanner;

public class Validacion{
    private int opcion;
    private boolean Aceptacion;
    private Scanner leer;

    public Validacion(){
        this.Aceptacion = true;
        leer = new Scanner(System.in);
    }

    public void validarOpcion(Usuario User){
        Aceptacion = true;

        do{
            try{
                do{
                    User.Menu();
                    System.out.println("Ingrese una opcion");
                    if(Aceptacion == false){
                        leer.nextLine();
                    }
                    opcion = leer.nextInt();
                    String OpcionCadena = String.valueOf(opcion);
                    if(OpcionCadena.length() == 1){
                    Aceptacion = true;
                    }else {
                    Aceptacion = false;
                    }

                }while(opcion >3 || opcion <1);
                break;
            }catch(InputMismatchException e){
                System.err.println("Opcion Invalida");
                Aceptacion = false;
            }
        }while(Aceptacion == false);
    }

    public boolean getAceptacion(){
        return Aceptacion;
    }

    public int getOpcion(){
        return opcion;
    }
    
    }
