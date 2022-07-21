import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion
{
    private String conectorInstalado = "jdbc:sqlite:";
    private String baseDatos = "..\\Basedatos\\basedatos.db";
    private Connection conexion;  //CONEXION CON LA BD
    private Statement ejecutorSQL;   //SENTENCIAS SQL
    private ResultSet rs;
    
    public boolean crearConexion()
    {
        try
        {
            conexion = DriverManager.getConnection(conectorInstalado + baseDatos);
            ejecutorSQL = conexion.createStatement();
            ejecutorSQL.setQueryTimeout(30);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public boolean cerrarConexion()
    {
        try
        {
            conexion.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    public void insertar(String sql)
    {
        try
        {
            int cant = ejecutorSQL.executeUpdate(sql);
        }
        catch (Exception e)
        {
            
        }
    }
    
    public boolean actualizar(String sql)
    {
        try
        {
            int cant = ejecutorSQL.executeUpdate(sql);
            if (cant > 0)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    public ResultSet consultar(String sql)
    {
        try
        {
            rs = ejecutorSQL.executeQuery(sql);
            return rs;
        }
        catch (Exception e)
        {
            return null;
        }
    }
    
    public boolean borrar(String sql)
    {
        try
        {
            int cant = ejecutorSQL.executeUpdate(sql);
            if (cant > 0)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    
}