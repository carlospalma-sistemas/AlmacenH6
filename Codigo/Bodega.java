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
        this.listaProductos.add(p);
    }

    public Producto getProducto(int id) 
    {
        for (Producto p: this.listaProductos)
        {
            if (p.getId() == id)
            {
                return p;
            }
        }
        return null;
    }
    
    public void eliminarProducto(int id)
    {
        Producto prodEliminar = this.getProducto(id);
        if (prodEliminar != null)
        {
            this.listaProductos.remove(prodEliminar);
        }
    }

    public void incrementarProducto(int id, int cant) 
    {
        Producto prodIncrementar = this.getProducto(id);
        if (prodIncrementar != null)
        {
            int index = this.listaProductos.indexOf(prodIncrementar);
            this.listaProductos.get(index).setCantidad(prodIncrementar.getCantidad() + cant);
        }
    }

    public void disminuirProducto(int id, int cant) 
    {
        Producto prodDisminuir = this.getProducto(id);
        if (prodDisminuir != null)
        {
            int index = this.listaProductos.indexOf(prodDisminuir);
            if (prodDisminuir.getCantidad() >= cant)
            {
                this.listaProductos.get(index).setCantidad(prodDisminuir.getCantidad() - cant);    
            }
        }
    }

    public void modificarPrecio(int id, int precio) 
    {
        Producto prodModificar = this.getProducto(id);
        if (prodModificar != null)
        {
            int index = this.listaProductos.indexOf(prodModificar);
            this.listaProductos.get(index).setPrecio(precio);
        }
    }
}