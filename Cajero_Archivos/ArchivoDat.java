import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoDat {

  private boolean ComprobarBilletes, excede;

  public boolean getComprobarBilletes(){
    return ComprobarBilletes;
  }

  public boolean getExcede(){
      return excede;
  }

  public ArrayList InicializarBilletes(){
    ArrayList<CajaFuerte> cajaInicio = new ArrayList<CajaFuerte>();
    CajaFuerte caja1000 = new CajaFuerte("1000", 10);
    CajaFuerte caja500 = new CajaFuerte("500", 20);
    CajaFuerte caja200 = new CajaFuerte("200", 100);
    CajaFuerte caja100 = new CajaFuerte("100", 100);
    cajaInicio.add(caja100);
    cajaInicio.add(caja200);
    cajaInicio.add(caja500);
    cajaInicio.add(caja1000);

    return cajaInicio;
  }

  public int CantidadMinimaInt(String nombre){
    int retorno = 0;
    int i = 0;
    try {
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre));
      try {
        while (true) {
          ArrayList<CajaFuerte> caja = (ArrayList<CajaFuerte>) inputStream.readObject();
          for (CajaFuerte m: caja) {
            if(caja.get(i).getCantidadBilletes()>=1){ 
              retorno = caja.get(i).getCantidadBilletes();
              break;
            }
            i++;
          }
        }
      } catch (EOFException e) {
        // Fin del archivo
      }

      inputStream.close();
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    }
    return retorno;
  }

  public String CantidadMinimaString(String nombre){
    String retorno = "";
    int i = 0;
    try {
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre));
      try {
        while (true) {
          ArrayList<CajaFuerte> caja = (ArrayList<CajaFuerte>) inputStream.readObject();
          for (CajaFuerte m: caja) {
            if(caja.get(i).getCantidadBilletes()>=1){ 
              retorno = "cantidad minima a retirar:  "+caja.get(i).getNominacion()+" MXN";
              break;
            }
            i++;
          }
        }
      } catch (EOFException e) {
        // Fin del archivo
      }

      inputStream.close();
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    }
    return retorno;
  }

  public void ComprobarContenido(String nombre) {
    File file = new File("billetes.dat");
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      if(br.readLine()==null){
        ArrayList<CajaFuerte> caja = new ArrayList<CajaFuerte>();
        caja = InicializarBilletes();
        escribir("billetes.dat",caja);
      }
    } catch (IOException e) {
      System.err.println("No se puede verificar el archivo: "+ e.getMessage());
    }
  }

  public void escribir(String nombre, ArrayList<CajaFuerte> cajaBilletes) {
    try {
      ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nombre));
      outputStream.writeObject(cajaBilletes);
      outputStream.close();
    } catch (IOException e) {
      System.err.println("Error al escribir en el archivo: " + e.getMessage());
    }
  }

    public void leerYComprobar(String nombre, int cantidad, int Saldo) {
    try {
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre));

      try {
        while (true) {
          ArrayList<CajaFuerte> caja = (ArrayList<CajaFuerte>) inputStream.readObject();
          Combinaciones combinaciones = new Combinaciones();
          combinaciones.ModificarBilletes(cantidad, caja, Saldo);
          ComprobarBilletes = combinaciones.ComprobarPosibilidad();
          excede= combinaciones.getExcede();
        }
      } catch (EOFException e) {
        // Fin del archivo
      }

      inputStream.close();
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    }
  }

  public void leer(String nombre) {
    try {
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre));
      try {
        while (true) {
          ArrayList<CajaFuerte> caja = (ArrayList<CajaFuerte>) inputStream.readObject();

          for (CajaFuerte m: caja) {
            System.out.println('1');
            System.out.println(m);
          }
        }
      } catch (EOFException e) {
        // Fin del archivo
      }

      inputStream.close();
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    }
  }

  public void RecuperarDatos(String nombre, int cantidad, int Saldo) {
    try {
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombre));

      try {
        while (true) {
          ArrayList<CajaFuerte> caja = (ArrayList<CajaFuerte>) inputStream.readObject();
          Combinaciones combinaciones = new Combinaciones();
          combinaciones.ModificarBilletes(cantidad, caja, Saldo);
          ComprobarBilletes = combinaciones.ComprobarPosibilidad();
          escribir(nombre, caja);
        }
      } catch (EOFException e) {
        // Fin del archivo
      }

      inputStream.close();
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    }
  }
}
