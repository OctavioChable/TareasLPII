
public class UsuarioAdmin extends Usuario{

    public UsuarioAdmin(String nombre, int NIP){
        super(nombre, NIP);
    }

    public void RevisarMovimientos(){
        System.out.println("administrador");
    }

    @Override
    public void Menu() {
        System.out.println("MENU");
        System.out.println("1. Consultar Movimientos");
        System.out.println("2. Colsultar billetes");
        System.out.println("3. Salir");
    }

    @Override
    public void RealizarOperaciones(int opcion) {
        switch (opcion) {
            case 1:
                ConsultarMovimiento();  
                break;
            case 2:
                ConsultarBilletes();
                break;
            case 3:
                System.out.println("esta saliendo del cajero...");
                System.out.println("Ha salido con exito");
                break;
            default:
                break;
        }
    }

    public void ConsultarMovimiento(){
        ArchivoTxt movimientos = new ArchivoTxt();
        movimientos.leer("logs.txt");
    }

    public void ConsultarBilletes(){
        ArchivoDat billetes = new ArchivoDat();
        billetes.leer("billetes.dat");
    }
}