import java.util.ArrayList;

public class Bodega 
{
    private ArrayList<Producto> listaProductos;

    public Bodega() 
    {
        ArchivoProductos a = new ArchivoProductos();
        this.listaProductos = a.cargarProductos();
    }
    
    public ArrayList<Producto> getListaProductos()
    {
        ArchivoProductos a = new ArchivoProductos();
        this.listaProductos = a.cargarProductos();
        return this.listaProductos;
    }

    public void anadirProducto(Producto p) 
    {
        this.listaProductos.add(p);
        ArchivoProductos a = new ArchivoProductos();
        a.guardarProducto(p.toCSV());
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
    
    public ArrayList<Producto> buscarProductos(String criterio)
    {
        ArrayList<Producto> productosEncontrados = new ArrayList<Producto>();
        for (Producto p: this.listaProductos)
        {
            if (p.getNombre().equals(criterio) || p.getMarca().equals(criterio) || p.getPresentacion().equals(criterio) || (p.getId()+"").equals(criterio))
            {
                productosEncontrados.add(p);
            }
        }
        return productosEncontrados;
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
        this.actualizarListaEnArchivo();
    }

    public void disminuirProducto(int id, int cant) 
    {
        Producto prodDisminuir = this.getProducto(id);
        //System.out.println("En bodega: "+prodDisminuir.mostrarInfo());
        if (prodDisminuir != null)
        {
            int index = this.listaProductos.indexOf(prodDisminuir);
            if (prodDisminuir.getCantidad() >= cant)
            {
                this.listaProductos.get(index).setCantidad(prodDisminuir.getCantidad() - cant);    
                //System.out.println("En bodega disminuido: "+this.listaProductos.get(index).mostrarInfo());
            }
        }
    }
    
    public void actualizarListaEnArchivo()
    {
        ArchivoProductos a = new ArchivoProductos();
        a.actualizarLista(this.listaProductos);
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