import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Pantalla extends JFrame
{
    JTextField txtCodigo, txtNombre, txtMarca, txtPresent, txtCant, txtPrecio, txtBuscar;
    JComboBox comboTipo;
    JButton btnAgregar, btnActualizar, btnLimpiar, btnEliminar, btnFiltrar, btnQuitarFiltro;
    JTable tablaProductos;
    
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
        JLabel labelTitulo = new JLabel("Sistema de Inventario y POS");
        labelTitulo.setBounds(20, 20, 500, 60);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        labelTitulo.setForeground(Color.WHITE);
        panelBanner.add(labelTitulo);
        
        Image imagen = new ImageIcon("imgs\\logo_shop.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel labelLogo = new JLabel(new ImageIcon(imagen));
        labelLogo.setBounds(1050, 10, 84, 80);
        panelBanner.add(labelLogo);
        
        //Componentes del panel del formulario
        JLabel labelCodigo = new JLabel("Codigo");
        labelCodigo.setBounds(10, 20, 100, 30);
        panelFormulario.add(labelCodigo);
        
        txtCodigo = new JTextField();
        txtCodigo.setBounds(140, 20, 300, 30);
        panelFormulario.add(txtCodigo);
        
        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setBounds(10, 60, 100, 30);
        panelFormulario.add(labelNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(140, 60, 300, 30);
        panelFormulario.add(txtNombre);
        
        JLabel labelMarca = new JLabel("Marca");
        labelMarca.setBounds(10, 100, 100, 30);
        panelFormulario.add(labelMarca);
        
        txtMarca = new JTextField();
        txtMarca.setBounds(140, 100, 300, 30);
        panelFormulario.add(txtMarca);
        
        JLabel labelPresent = new JLabel("Presentacion");
        labelPresent.setBounds(10, 140, 100, 30);
        panelFormulario.add(labelPresent);
        
        txtPresent = new JTextField();
        txtPresent.setBounds(140, 140, 300, 30);
        panelFormulario.add(txtPresent);
        
        JLabel labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(10, 180, 100, 30);
        panelFormulario.add(labelTipo);
        
        comboTipo = new JComboBox();
        comboTipo.addItem("");
        comboTipo.addItem("Aseo");
        comboTipo.addItem("Alimento");
        comboTipo.setBounds(140, 180, 300, 30);
        panelFormulario.add(comboTipo);
        
        JLabel labelCant = new JLabel("Cantidad");
        labelCant.setBounds(10, 220, 100, 30);
        panelFormulario.add(labelCant);
        
        txtCant = new JTextField();
        txtCant.setBounds(140, 220, 300, 30);
        panelFormulario.add(txtCant);

        JLabel labelPrecio = new JLabel("Precio");
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
        Object[][] datos = null;
        String[] columnas = {"Codigo", "Nombre", "Marca", "Presentación", "Tipo", "Cant", "Precio"};     
        DefaultTableModel dtm= new DefaultTableModel(datos, columnas);
        
        tablaProductos = new JTable(dtm);
        tablaProductos.setPreferredScrollableViewportSize(new Dimension(715, 290));
        tablaProductos.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(tablaProductos);
        
        JPanel contenidoTabla = new JPanel();
        contenidoTabla.setBounds(0, 0, 715, 290);
        contenidoTabla.setLayout(new GridLayout(1,0));
        contenidoTabla.add(scroll);
        panelTabla.add(contenidoTabla);
        
        JLabel labelBuscar = new JLabel("Buscar por: ");
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
