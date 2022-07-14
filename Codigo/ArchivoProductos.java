import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.charset.Charset;

public class ArchivoProductos
{
    private File archivo;
    
    public ArchivoProductos()
    {
        this.archivo = new File("productos.csv");
    }
    
    public void guardarProducto(String texto)
    {
        this.guardar(texto, true);
    }
    
    public void actualizarLista(ArrayList<Producto> lista)
    {
        String texto = "";
        for (int i=0; i<lista.size(); i++)
        {
            if (i != 0) 
            {
                texto = texto + "\n";
            }
            texto = texto + lista.get(i).toCSV();
        }
        this.guardar(texto, false);
        
    }
    
    private void guardar(String texto, boolean agregar) //True es para añadir un producto al final, false es para reemplazar todo el archivo
    {
        try
        {
            FileWriter writer = new FileWriter(this.archivo, Charset.forName("UTF-8"), agregar);
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
