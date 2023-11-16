import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoTxt {
  public void crear(String nombre) {
    File file = new File(nombre);
    try {
      file.createNewFile();
    } catch (IOException e) {
      System.out.println("Error al crear el archivo: " + e.getMessage());
    }
  }

  public void escribir(String nombre, String contenido, boolean concatener) {
    File file = new File(nombre);
    
    if (!file.exists()) {
      System.out.println("El archivo no existe");
      return;
    }

    try {
      FileWriter writer = new FileWriter(file, concatener);
      writer.write(contenido + "\n");
      writer.close();
    } catch (IOException e) {
      System.out.println("Error al escribir en el archivo: " + e.getMessage());
    }
  }

  public void leer(String nombre) {
    File file = new File(nombre);
    
    if (!file.exists()) {
      System.out.println("El archivo no existe");
      return;
    } else {
      try {
        FileReader reader = new FileReader(file);
        int c;
        while ((c = reader.read()) != -1) {
          System.out.print((char) c);
        }
        reader.close();
      } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
      }
    }
  }

  public void borrarContenido(String nombre) {
    File file = new File(nombre);
    if (!file.exists()) {
      System.out.println("El archivo no existe");
      return;
    }

    try {
      FileWriter writer = new FileWriter(file);
      writer.write("");
      writer.close();
    } catch (IOException e) {
      System.out.println("Error al borrar el contenido del archivo: " + e.getMessage());
    }
  }
}
