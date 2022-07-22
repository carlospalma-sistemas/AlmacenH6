import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Pantalla extends JFrame
{
    JLabel labelTitulo, labelCodigo, labelNombre, labelMarca, labelPresent, labelTipo, labelCant, labelPrecio, labelBuscar;
    JTextField txtCodigo, txtNombre, txtMarca, txtPresent, txtCant, txtPrecio, txtBuscar;
    JComboBox comboTipo;
    JButton btnAgregar, btnActualizar, btnLimpiar, btnEliminar, btnFiltrar, btnQuitarFiltro;
    
    public Pantalla()
    {
        setBounds(100, 100, 1200, 550);
        setTitle("Almacen H6 - V2.0");
        setLayout(null);
        
        //Creación de páneles
        JPanel panelBanner = new JPanel();
        panelBanner.setBounds(0, 0, 1200, 100);
        panelBanner.setBackground(new Color(64, 0, 196));   
        panelBanner.setLayout(null);
        getContentPane().add(panelBanner);
        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setBounds(5, 105, 455, 402);
        panelFormulario.setBorder(BorderFactory.createEtchedBorder());
        panelFormulario.setLayout(null);
        getContentPane().add(panelFormulario);
        
        JPanel panelTabla = new JPanel();
        panelTabla.setBounds(465, 105, 715, 402);
        panelTabla.setBorder(BorderFactory.createEtchedBorder());
        panelTabla.setLayout(null);
        getContentPane().add(panelTabla);
        
        //Componentes del panel del banner
        labelTitulo = new JLabel("Sistema de Inventario y POS");
        labelTitulo.setBounds(20, 20, 500, 60);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        labelTitulo.setForeground(Color.WHITE);
        panelBanner.add(labelTitulo);
        
        //Componentes del panel del formulario
        labelCodigo = new JLabel("Codigo");
        labelCodigo.setBounds(10, 20, 100, 30);
        panelFormulario.add(labelCodigo);
        
        txtCodigo = new JTextField();
        txtCodigo.setBounds(140, 20, 300, 30);
        panelFormulario.add(txtCodigo);
        
        labelNombre = new JLabel("Nombre");
        labelNombre.setBounds(10, 60, 100, 30);
        panelFormulario.add(labelNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(140, 60, 300, 30);
        panelFormulario.add(txtNombre);
        
        labelMarca = new JLabel("Marca");
        labelMarca.setBounds(10, 100, 100, 30);
        panelFormulario.add(labelMarca);
        
        txtMarca = new JTextField();
        txtMarca.setBounds(140, 100, 300, 30);
        panelFormulario.add(txtMarca);
        
        labelPresent = new JLabel("Presentacion");
        labelPresent.setBounds(10, 140, 100, 30);
        panelFormulario.add(labelPresent);
        
        txtPresent = new JTextField();
        txtPresent.setBounds(140, 140, 300, 30);
        panelFormulario.add(txtPresent);
        
        labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(10, 180, 100, 30);
        panelFormulario.add(labelTipo);
        
        comboTipo = new JComboBox();
        comboTipo.addItem("");
        comboTipo.addItem("Aseo");
        comboTipo.addItem("Alimento");
        comboTipo.setBounds(140, 180, 300, 30);
        panelFormulario.add(comboTipo);
        
        labelCant = new JLabel("Cantidad");
        labelCant.setBounds(10, 220, 100, 30);
        panelFormulario.add(labelCant);
        
        txtCant = new JTextField();
        txtCant.setBounds(140, 220, 300, 30);
        panelFormulario.add(txtCant);

        labelPrecio = new JLabel("Precio");
        labelPrecio.setBounds(10, 260, 100, 30);
        panelFormulario.add(labelPrecio);
        
        txtPrecio = new JTextField();
        txtPrecio.setBounds(140, 260, 300, 30);
        panelFormulario.add(txtPrecio);
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(10, 350, 100, 30);
        panelFormulario.add(btnAgregar);
        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(120, 350, 100, 30);
        panelFormulario.add(btnActualizar);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(230, 350, 100, 30);
        panelFormulario.add(btnLimpiar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(340, 350, 100, 30);
        panelFormulario.add(btnEliminar);
        
        //Componentes del panel de la tabla
        Object[][] data = null;
        String[] columnNames = {"Codigo", "Nombre", "Marca", "Presentación", "Tipo", "Cant", "Precio"};     
        DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
        
        JTable tabla = new JTable(dtm);
        tabla.setPreferredScrollableViewportSize(new Dimension(715, 290));
        tabla.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(tabla);
        
        JPanel contenidoTabla = new JPanel();
        contenidoTabla.setBounds(0, 0, 715, 290);
        contenidoTabla.setLayout(new GridLayout(1,0));
        contenidoTabla.add(scroll);
        panelTabla.add(contenidoTabla);
        
        labelBuscar = new JLabel("Buscar por: ");
        labelBuscar.setBounds(10, 350, 100, 30);
        panelTabla.add(labelBuscar);
        
        txtBuscar = new JTextField();
        txtBuscar.setBounds(140, 350, 300, 30);
        panelTabla.add(txtBuscar);
        
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBounds(460, 350, 100, 30);
        panelTabla.add(btnFiltrar);
        
        btnQuitarFiltro = new JButton("Quitar filtro");
        btnQuitarFiltro.setBounds(570, 350, 120, 30);
        panelTabla.add(btnQuitarFiltro);
        
        setVisible(true);
    }
}
