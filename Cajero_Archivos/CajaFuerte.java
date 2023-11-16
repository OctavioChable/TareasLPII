import java.io.Serializable;

public class CajaFuerte implements Serializable{
    private String Nominacion;
    private int CantidadBilletes;

    public CajaFuerte(String Nominacion, int CantidadBilletes){
        this.Nominacion = Nominacion;
        this.CantidadBilletes = CantidadBilletes;
    }

    public int getCantidadBilletes(){
        return CantidadBilletes;
    }

    public String getNominacion(){
        return Nominacion;
    }

    public void setCantidadBilletes(int CantidadBilletes){
        this.CantidadBilletes = CantidadBilletes;
    }

    @Override
    public String toString(){
        return ("billetes de "+Nominacion+" : "+CantidadBilletes);
    }


}