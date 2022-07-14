import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

public class Presentacion
{
    private String [] menuPrincipal;
    private String menuProductos;
    private Bodega bodega;
    
    public Presentacion()
    {
        this.bodega = new Bodega();
        
        String [] opciones = { "Gestionar productos", "Realizar venta", "Salir" };
        this.menuPrincipal = opciones;
        
        this.menuProductos = "PRODUCTOS \n"+
                             "1. Ingresar producto \n" +
                             "2. Mostrar productos \n" +
                             "3. Buscar productos \n" +
                             "4. Surtir producto \n" +
                             "0. Volver al menu principal";
    }
    
    
    public void presentarMenuPrincipal() 
    {
        int opcion = 0;
        do
        {
            Object o = JOptionPane.showInputDialog(null, "Seleccione una opción", "PROGRAMA DEL VECINO", JOptionPane.QUESTION_MESSAGE, null, this.menuPrincipal, this.menuPrincipal[0]);
            opcion = Arrays.asList(this.menuPrincipal).indexOf(o);
            switch (opcion) {
                case 0:
                    this.presentarMenuProductos();
                    break;
                case 1:
                    
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Muchas gracias", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opcion != 2);
    }
    
    
    
    public void presentarMenuProductos() 
    {
        int opcion = 0;
        do
        {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, this.menuProductos));
            switch (opcion)
            {
                case 1:
                    ingresarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3: 
                    buscarProductos();
                    break;
                case 4:
                    surtirProducto();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opcion != 0);
    }
    
    public void ingresarProducto()
    {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese código de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        String [] tipos = {"Aseo", "Alimento"};
        int tipo = JOptionPane.showOptionDialog(null, "Ingrese tipo de producto", "Nuevo producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String marca = JOptionPane.showInputDialog(null, "Ingrese marca de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String presentacion = JOptionPane.showInputDialog(null, "Ingrese presentación de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        int precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese precio de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        
        Producto p = new Producto(id, tipos[tipo], nombre, marca, presentacion, cantidad, precio);
        this.bodega.anadirProducto(p);
        JOptionPane.showMessageDialog(null, "Producto creado y añadido a la lista", "Producto creado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarProductos()
    {
        ArrayList<Producto> lista = this.bodega.getListaProductos();
        String datosProductos = "";
        for (Producto p: lista)
        {
            datosProductos = datosProductos + p.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, datosProductos, "Productos en la bodega", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void buscarProductos()
    {
        String buscar = JOptionPane.showInputDialog(null, "Ingrese texto para buscar producto (nombre, tipo, presentación, codigo)", "Buscar producto", JOptionPane.QUESTION_MESSAGE);
        ArrayList<Producto> lista = this.bodega.buscarProductos(buscar);
        String datosProductos = "";
        for (Producto p: lista)
        {
            datosProductos = datosProductos + p.toString() + "\n";
        }
        if (datosProductos.equals(""))
        {
            JOptionPane.showMessageDialog(null, "No se encontraron productos con ese criterio", "Productos No encontrados", JOptionPane.WARNING_MESSAGE);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, datosProductos, "Productos encontrados", JOptionPane.INFORMATION_MESSAGE);    
        }
    }
    
    public void surtirProducto()
    {
        this.buscarProductos();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite código del producto para surtido", "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad del producto para surtido", "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        this.bodega.incrementarProducto(codigo, cantidad);
        Producto p = this.bodega.getProducto(codigo);
        JOptionPane.showMessageDialog(null, p.mostrarInfo(), "Producto surtido", JOptionPane.INFORMATION_MESSAGE);
    }
    
}








