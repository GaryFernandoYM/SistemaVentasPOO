package entidades;

public class login {
    private int id;
    private String nombre;
    private String correo;
    private String pass;
    private String cuenta;
 

    public login() {
    }

    public login(int id, String nombre, String correo, String pass, String cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.cuenta = cuenta;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }


    
    
}
