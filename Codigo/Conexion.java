import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion
{
    private String conectorInstalado = "jdbc:sqlite:";
    private String baseDatos = "..\\BaseDatos\\basedatos.db";
    private Connection conexion;
    private Statement ejecutor;
    
    public void crearConexion()
    {
        try
        {
            conexion = DriverManager.getConnection(conectorInstalado+baseDatos);
            ejecutor = conexion.createStatement();
            ejecutor.setQueryTimeout(30);  // set timeout to 30 sec.
            System.out.println("conexión creada: "+conexion);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void cerrarConexion()
    {
        try {
            conexion.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    
    public ResultSet ejecutarQuery(String sql)
    {
        ResultSet rs = null;
        try
        {
            rs = ejecutor.executeQuery(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    
    
    public ResultSet ejecutarUpdate(String sql)
    {
        ResultSet rs = null;
        try
        {
            int cant = ejecutor.executeUpdate(sql);
            if (cant > 0) {
                rs = ejecutor.getGeneratedKeys();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
}