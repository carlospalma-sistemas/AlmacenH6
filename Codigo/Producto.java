public class Producto 
{
    private int id;
    private String tipo;
    private String nombre;
    private String marca;
    private String presentacion;
    private int cantidad;
    private int precio;

    public Producto() 
    {
        this.id = 0;
        this.tipo = "";
        this.nombre = "";
        this.marca = "";
        this.presentacion = "";
        this.cantidad = 0;
        this.precio = 0;
    }

    public Producto(int id, String tipo, String nombre, String marca, String presentacion, int cantidad, int precio) 
    {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.marca = marca;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void setCantidad(int cantidad) 
    {
        this.cantidad = cantidad;
    }

    public int getCantidad() 
    {
        return this.cantidad;
    }

    public void setPrecio(int precio) 
    {
        this.precio = precio;
    }

    public int getPrecio() 
    {
        return this.precio;
    }

    public int getId() 
    {
        return this.id;
    }

    public String getTipo() 
    {
        return this.tipo;
    }

    public String getNombre() 
    {
        return this.nombre;
    }

    public String getMarca() 
    {
        return this.marca;
    }

    public String getPresentacion() 
    {
        return this.presentacion;
    }

    public String toString()
    {
        return "Cod:" +this.id+ " - Producto: "+this.nombre +" "+ this.marca + " - " +this.presentacion;
    }
    
    public String mostrarInfo()
    {
        return "Cod:" +this.id+ "\nProducto: "+this.nombre + this.marca + " - " +this.presentacion+"\nPrecio: "+this.precio+"\nStock: "+this.cantidad;
    }
    
    public String toCSV()
    {
        return this.id+ ";" +this.tipo+";"+this.nombre +";"+ this.marca + ";" +this.presentacion+";"+this.precio+";"+this.cantidad;
    }
}





