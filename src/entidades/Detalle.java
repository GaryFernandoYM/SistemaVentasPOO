package entidades;

public class Detalle {
    private int id;
    private String cod_pro;
    private int cantidad;
    private double precio;
    private int id_ventas;

    public Detalle() {
    }

    public Detalle(int id, String cod_pro, int cantidad, double precio, int id_ventas) {
        this.id = id;
        this.cod_pro = cod_pro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_ventas = id_ventas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }
    
            
    
}