import java.util.Scanner;
import java.util.InputMismatchException;

public class CajeroAutomaticoMain{

    public static void main (String [] args){

        Scanner leer = new Scanner(System.in);
        String nombre, NIPCadena;
        boolean Aceptacion = true;
        int NIP;
        Validacion validacionOpcion = new Validacion();
        Usuario Usuario;

        do{
            try{
                System.out.println("Ingrese nombre de usuario: ");
                if(Aceptacion == false){
                    leer.nextLine();
                }
                nombre = leer.nextLine();
                System.out.println("Ingrese su NIP");
                NIP = leer.nextInt();
                Aceptacion = true;
                NIPCadena = String.valueOf(NIP);

                if(nombre.equals("admin") && NIP == 3243){
                    Usuario = new UsuarioAdmin(nombre, NIP);
                    do{
                        validacionOpcion.validarOpcion(Usuario);
                        Usuario.RealizarOperaciones(validacionOpcion.getOpcion());
                    }while(validacionOpcion.getOpcion() != 3);
                }else if(NIPCadena.length() == 4){
                    Usuario = new UsuarioConvensional(nombre, NIP);
                    do{
                        validacionOpcion.validarOpcion(Usuario);
                        Usuario.RealizarOperaciones(validacionOpcion.getOpcion());
                    }while(validacionOpcion.getOpcion() != 3);
                }else{
                    Aceptacion = false;
                }
            }catch(InputMismatchException e){
                System.err.println("NIP Invalido");
                Aceptacion = false;
            }
        }while(Aceptacion == false);
        
        }
}