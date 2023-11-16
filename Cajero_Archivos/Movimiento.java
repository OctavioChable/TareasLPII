import java.io.Serializable;

public class Movimiento implements Serializable {
  private String accion, accionExitosa;
  private String nombreUsuario;
  private int cantidad;
  private boolean accionRealizada;

  public Movimiento(String accion, String nombreUsuario, int cantidad, boolean accionRealizada) {
    this.accion = accion;
    this.nombreUsuario = nombreUsuario;
    this.cantidad = cantidad;
    this.accionRealizada = accionRealizada;
  }

  public String getAccion() {
    return accion;
  }

  public void setAccion(String accion) {
    this.accion = accion;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public boolean isAccionRealizada() {
    return accionRealizada;
  }

  public void setAccionRealizada(boolean accionRealizada) {
    this.accionRealizada = accionRealizada;
  }

  public void CadenaAceptacion(){
    if(accionRealizada){
      accionExitosa = "SI";
    }else if( accionRealizada == false){
      accionExitosa = "NO";
    }
  }

  @Override
  public String toString() {
    return "Movimiento [accion=" + accion + ", nombreUsuario=" + nombreUsuario + ", cantidad=" + cantidad
        + ", accionRealizada=" + accionExitosa + "]";
  }
}
