import java.util.ArrayList;
import java.sql.ResultSet;

public class Bodega 
{
    private ArrayList<Producto> listaProductos;

    public Bodega() 
    {
        this.listaProductos = new ArrayList<Producto>();
    }
    
    public ArrayList<Producto> getListaProductos()
    {
        this.listaProductos.clear();
        Conexion con = new Conexion();
        if (con.crearConexion() == false) 
        {
            System.out.println("Conexión no generada");
            return null;
        }
        String sql = "SELECT id, codigobarras, tipo, nombre, marca, presentacion, precio, cantidad "+
                     "FROM TProductos ";
        ResultSet rs = con.consultar(sql);
        try
        {
            while(rs.next())
            {
                int id = rs.getInt(1);
                int codigobarras = rs.getInt(2);
                String tipo = rs.getString(3);
                String nombre = rs.getString(4);
                String marca = rs.getString(5);
                String presentacion = rs.getString(6);
                int precio = rs.getInt(7);
                int cantidad = rs.getInt(8);
                Producto p = new Producto(id, codigobarras, tipo, nombre, marca, presentacion, cantidad, precio);
                this.listaProductos.add(p);
            } 
        }
        catch(Exception e)
        {
            return null;
        }
        con.cerrarConexion();
        return this.listaProductos;
    }

    public void anadirProducto(Producto p) 
    {
        Conexion con = new Conexion();
        con.crearConexion();
        String sql = "INSERT INTO TProductos(codigobarras, tipo, nombre, marca, presentacion, precio, cantidad) "+
                     "VALUES ("+p.getCodigoBarras()+", \""+p.getTipo()+"\",  \""+p.getNombre()+"\",  \""+p.getMarca()+"\", \""+p.getPresentacion()+"\", "+p.getPrecio()+", "+p.getCantidad()+")" ;
        con.insertar(sql);                 
        //OPERACIONES
        con.cerrarConexion();
    }

    public Producto getProducto(int codigo) 
    {
        Producto p = null;
        Conexion con = new Conexion();
        con.crearConexion();
        String sql = "SELECT id, codigobarras, tipo, nombre, marca, presentacion, precio, cantidad "+
                     "FROM TProductos "+
                     "WHERE codigobarras = " + codigo;
        ResultSet rs = con.consultar(sql);
        try
        {
            while(rs.next())
            {
                int id = rs.getInt(1);
                int codigobarras = rs.getInt(2);
                String tipo = rs.getString(3);
                String nombre = rs.getString(4);
                String marca = rs.getString(5);
                String presentacion = rs.getString(6);
                int precio = rs.getInt(7);
                int cantidad = rs.getInt(8);
                p = new Producto(id, codigobarras, tipo, nombre, marca, presentacion, cantidad, precio);
            } 
        }
        catch(Exception e)
        {
            return null;
        }
        con.cerrarConexion();
        return p;
    }
    
    public ArrayList<Producto> buscarProductos(String criterio)
    {
        this.listaProductos.clear();
        Conexion con = new Conexion();
        con.crearConexion();
        String sql = "SELECT id, codigobarras, tipo, nombre, marca, presentacion, precio, cantidad "+
                     "FROM TProductos " +
                     "WHERE tipo LIKE \"%"+criterio+"%\" " + 
                     "OR nombre LIKE \"%"+criterio+"%\" " + 
                     "OR presentacion LIKE \"%"+criterio+"%\" " + 
                     "OR marca LIKE \"%"+criterio+"%\" ";
        ResultSet rs = con.consultar(sql);
        try
        {
            while(rs.next())
            {
                int id = rs.getInt(1);
                int codigobarras = rs.getInt(2);
                String tipo = rs.getString(3);
                String nombre = rs.getString(4);
                String marca = rs.getString(5);
                String presentacion = rs.getString(6);
                int precio = rs.getInt(7);
                int cantidad = rs.getInt(8);
                Producto p = new Producto(id, codigobarras, tipo, nombre, marca, presentacion, cantidad, precio);
                this.listaProductos.add(p);
            } 
        }
        catch(Exception e)
        {
            return null;
        }
        con.cerrarConexion();
        return this.listaProductos;
    }
    
    public void eliminarProducto(int codigo)
    {
        Conexion con = new Conexion();
        con.crearConexion();
        String sql = "DELETE FROM TProductos "+
                     "WHERE codigobarras = "+codigo;
        con.borrar(sql);
        con.cerrarConexion();
    }

    public void incrementarProducto(int codigo, int cant, int precio) 
    {
        Conexion con = new Conexion();
        con.crearConexion();
        String sql = "UPDATE TProductos "+
                     "SET cantidad = "+ cant +", precio = "+ precio +" "+
                     "WHERE codigobarras = "+codigo;
        con.actualizar(sql);
        con.cerrarConexion();
    }

    public void disminuirProducto(int codigo, int cant) 
    {
        Conexion con = new Conexion();
        con.crearConexion();
        String sql = "UPDATE TProductos "+
                     "SET cantidad = cantidad - "+ cant +" "+
                     "WHERE codigobarras = "+codigo;
        con.actualizar(sql);
        con.cerrarConexion();
    }
    
}