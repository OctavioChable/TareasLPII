import java.util.InputMismatchException;
import java.util.Scanner;
public class UsuarioConvensional extends Usuario{

    private int Saldo;
    private Scanner leer;
    private ArchivoTxt logs;
    private ArchivoDat billetes;
    private Movimiento movimiento;
    private int retiro;

    public UsuarioConvensional(String nombre,int NIP){
        super(nombre,NIP);
        Saldo = (int)(Math.random()*(50000-5000+1)+5000);
        leer = new Scanner(System.in);
        logs = new ArchivoTxt();
        billetes = new ArchivoDat();
    }
        
    @Override
    public void Menu(){
        System.out.println("MENU");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar efectivo");
        System.out.println("3. Salir");
    }

    @Override
    public void RealizarOperaciones(int opcion){
        switch (opcion) {
            case 1:

                ConsultarSaldo();
                movimiento = new Movimiento("consultar saldo", getUserName(), Saldo, true);
                movimiento.CadenaAceptacion();
                logs.escribir("logs.txt", movimiento.toString(), true);
                System.out.println("La Operacion se realizo con exito");

                break;
            case 2:
                int numCiclos=0;
                do{
                    if(numCiclos>0){
                        System.out.println("¿Desea continuar con la operacion?");
                        System.out.println("presione 0 como cantidad a retirar para cancelar Operacion");
                    }
                    billetes.ComprobarContenido("billetes.dat");
                    System.out.println(billetes.CantidadMinimaString("billetes.dat"));
                    RetirarEfectivo();
                    if(retiro==0){
                        break;
                    }
                    billetes.leerYComprobar("billetes.dat", retiro, Saldo);
                    if(retiro%100 != 0){
                        movimiento = new Movimiento("Retirar efectivo", getUserName(), retiro, false);
                        movimiento.CadenaAceptacion();
                        logs.escribir("logs.txt", movimiento.toString(), true);
                    }
                    numCiclos++;
                }while(billetes.getExcede()||billetes.getComprobarBilletes() || retiro > Saldo || retiro%100 != 0);

                movimiento = new Movimiento("Retirar efectivo", getUserName(),retiro,true);
                movimiento.CadenaAceptacion();
                logs.escribir("logs.txt", movimiento.toString(), true);
                billetes.RecuperarDatos("billetes.dat", retiro,Saldo);
                this.Saldo -= retiro;
                System.out.println("La Operacion se realizo con exito");

                break;
            case 3:

            Salir();

                break;
            default:

                break;

        }
    }

    public void ConsultarSaldo(){
        System.out.println("este es su saldo actual "+this.Saldo+ " MXN");
    }

    public void RetirarEfectivo(){
        boolean ciclo = false;
        do{
            try{
                System.out.println("Cuanto desea retirar");
                if(ciclo == true){
                    leer.nextLine();
                }
                retiro = leer.nextInt();
                ciclo = false;
            }catch(InputMismatchException e){
                System.out.println("Cantidad erronea");
                ciclo = true;
            }
        }while(ciclo);
    }

    public void Salir(){
        System.out.println("Saliendo...");
        System.out.println("Ha salido con exito");
    }
}