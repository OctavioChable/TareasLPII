import java.util.ArrayList;

public class Combinaciones{
    private int Resta, billete1000, billete500, billete200, billete100;
    private boolean posibilidad;
    private boolean excede;

    public boolean getExcede(){
        return excede;
    }

    public int getBillete100(){
        return billete100;
    }

    public int getBillete200(){
        return billete200;
    }

    public int getBillete500(){
        return billete500;
    }

    public int getBillete1000(){
        return billete1000;
    }
    
    public boolean ComprobarPosibilidad(){
        return posibilidad;
    }
    public void ModificarBilletes(int cantidad, ArrayList<CajaFuerte> cajaBilletes, int Saldo){
        billete1000=cajaBilletes.get(3).getCantidadBilletes();
        billete500=cajaBilletes.get(2).getCantidadBilletes();
        billete200=cajaBilletes.get(1).getCantidadBilletes();
        billete100=cajaBilletes.get(0).getCantidadBilletes();

        int cantidadTotalCaja = (billete100*100)+(billete200*200)+(billete500*500)+(billete1000*1000);
        if(cantidadTotalCaja >= cantidad && cantidad%100 == 0){
    
            if(cantidad/1000 >= 1 && cajaBilletes.get(3).getCantidadBilletes() >0 && Saldo > cantidad){

                Resta = (int)cantidad/1000;
                if(billete1000>=Resta){
                    billete1000-=Resta;
                    cantidad-= Resta*1000;
                }else if(billete1000<Resta){
                    cantidad -= billete1000*1000;
                    billete1000 = 0;
                }
        
            }   
    
            if(cantidad/500 >= 1 && cajaBilletes.get(2).getCantidadBilletes() >0 && Saldo > cantidad){
                Resta = (int)cantidad/500;
                if(billete500>=Resta){
                    billete500-=Resta;
                    cantidad-= Resta*500;
                }else if(billete500<Resta){
                    cantidad -= billete500*500;
                    billete500 = 0;
                }
        
            }

            if(cantidad/200 >= 1 && cajaBilletes.get(1).getCantidadBilletes() >0 && Saldo > cantidad){
                Resta = (int)cantidad/200;
                if(billete200>=Resta){
                    billete200-=Resta;
                    cantidad-= Resta*200;
                }else if(billete200<Resta){
                    cantidad -= billete200*200;
                    billete200 = 0;
                }
        
            }

            if(cantidad/100 >= 1 && cajaBilletes.get(0).getCantidadBilletes() >0 && Saldo > cantidad){
                Resta = (int)cantidad/100;
                if(billete100>=Resta){
                    billete100-=Resta;
                    cantidad-= Resta*100;
                }else if(billete100<Resta){
                    cantidad -= billete100*100;
                    billete100 = 0;
                }
            }

            if(cantidad == 0){
                cajaBilletes.get(3).setCantidadBilletes(billete1000);
                cajaBilletes.get(2).setCantidadBilletes(billete500);
                cajaBilletes.get(1).setCantidadBilletes(billete200);
                cajaBilletes.get(0).setCantidadBilletes(billete100);
                posibilidad = false;
            }else{
                posibilidad = true;
            }

            excede = false;
        }else{
            excede = true;
        }
    }
    }

