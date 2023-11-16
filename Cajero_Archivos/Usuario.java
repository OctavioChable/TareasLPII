public abstract class Usuario{
    private String UserName;
    private int NIP;

    public Usuario(String UserName, int NIP){
        this.UserName = UserName;
        this.NIP = NIP;
    }

    public String getUserName(){
        return UserName;
    }
    
    public abstract void Menu();

    public abstract void RealizarOperaciones(int opcion);
}