import java.util.List;
import java.util.ArrayList;

public class Venta
{
    private List<Producto> carritoCompra;

    public Venta()
    {
        this.carritoCompra = new ArrayList<Producto>();
    }

    public void agregarProductoAlCarrito(Producto p, int cant)
    {
        p.setCantidad(cant);
        this.carritoCompra.add(p);
    }
    
    public int calcularTotalVenta()
    {
        int valorTotal = 0;
        for (Producto p: this.carritoCompra)
        {
            valorTotal = valorTotal + (p.getCantidad() * p.getPrecio());
        }
        return valorTotal;
    }
    
    public void finalizarVenta()
    {
        Bodega b = new Bodega();
        for (Producto p: this.carritoCompra)
        {
            //System.out.println("En venta: "+p.mostrarInfo());
            b.disminuirProducto(p.getId(), p.getCantidad()); 
        }
    }
}
