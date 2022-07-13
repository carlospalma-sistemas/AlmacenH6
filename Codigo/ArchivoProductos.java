import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArchivoProductos
{
    private File archivo;
    
    public ArchivoProductos()
    {
        this.archivo = new File("productos.csv");
    }
    
    public void guardarProducto(String texto)
    {
        try
        {
            FileWriter writer = new FileWriter(this.archivo, true);
            PrintWriter cursor = new PrintWriter(writer);
            cursor.println(texto);
            cursor.flush();
            cursor.close();
            writer.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
    public ArrayList<Producto> cargarProductos()
    {
        ArrayList<Producto> listaCargada = new ArrayList<Producto>();
        try
        {
            FileReader reader = new FileReader(this.archivo); 
            BufferedReader cursor = new BufferedReader(reader);
            while(cursor.ready())
            {
                String linea = cursor.readLine();
                String [] datoProducto = linea.split(";");
                int id = Integer.parseInt(datoProducto[0]);
                String tipo = datoProducto[1];
                String nombre = datoProducto[2];
                String marca = datoProducto[3];
                String presentacion = datoProducto[4];
                int precio = Integer.parseInt(datoProducto[5]);
                int cantidad = Integer.parseInt(datoProducto[6]);
                
                Producto p = new Producto(id, tipo, nombre, marca, presentacion, cantidad, precio);
                listaCargada.add(p);
            }
        }
        catch(Exception e)
        {
            
        }
        return listaCargada;
    }
}
