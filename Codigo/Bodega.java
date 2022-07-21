import java.util.ArrayList;

public class Bodega 
{
    private ArrayList<Producto> listaProductos;

    public Bodega() 
    {
        this.listaProductos = new ArrayList<Producto>();
    }
    
    public ArrayList<Producto> getListaProductos()
    {
        return this.listaProductos;
    }

    public void anadirProducto(Producto p) 
    {
        
    }

    public Producto getProducto(int id) 
    {
        return null;
    }
    
    public ArrayList<Producto> buscarProductos(String criterio)
    {
        return null;
    }
    
    public void eliminarProducto(int id)
    {
        
    }

    public void incrementarProducto(int id, int cant) 
    {
        
    }

    public void disminuirProducto(int id, int cant) 
    {
        
    }
    
    public void actualizarListaEnArchivo()
    {
        
    }

    public void modificarPrecio(int id, int precio) 
    {
        
    }
}