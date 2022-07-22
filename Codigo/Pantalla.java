import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Pantalla extends JFrame
{
    JLabel labelCodigo, labelNombre, labelMarca, labelPresent, labelTipo, labelCant, labelPrecio;
    JTextField txtCodigo, txtNombre, txtMarca, txtPresent, txtCant, txtPrecio;
    JComboBox comboTipo;
    JButton btnAgregar, btnActualizar, btnLimpiar, btnEliminar;
    
    public Pantalla()
    {
        setBounds(100, 100, 800, 600);
        setTitle("Almacen H6 - V2.0");
        setLayout(null);
        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setBounds(0, 0, 400, 600);
        panelFormulario.setLayout(null);
        getContentPane().add(panelFormulario);
        
        JPanel panelTabla = new JPanel();
        panelTabla.setBounds(400, 0, 400, 600);
        panelTabla.setLayout(null);
        getContentPane().add(panelTabla);
        
        labelCodigo = new JLabel("Codigo");
        labelCodigo.setBounds(10, 20, 100, 30);
        panelFormulario.add(labelCodigo);
        
        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 20, 200, 30);
        panelFormulario.add(txtCodigo);
        
        labelNombre = new JLabel("Nombre");
        labelNombre.setBounds(10, 70, 100, 30);
        panelFormulario.add(labelNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 70, 200, 30);
        panelFormulario.add(txtNombre);
        
        labelMarca = new JLabel("Marca");
        labelMarca.setBounds(10, 120, 100, 30);
        panelFormulario.add(labelMarca);
        
        txtMarca = new JTextField();
        txtMarca.setBounds(150, 120, 200, 30);
        panelFormulario.add(txtMarca);
        
        labelPresent = new JLabel("Presentacion");
        labelPresent.setBounds(10, 170, 100, 30);
        panelFormulario.add(labelPresent);
        
        txtPresent = new JTextField();
        txtPresent.setBounds(150, 170, 200, 30);
        panelFormulario.add(txtPresent);
        
        labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(10, 220, 100, 30);
        panelFormulario.add(labelTipo);
        
        comboTipo = new JComboBox();
        comboTipo.addItem("");
        comboTipo.addItem("Aseo");
        comboTipo.addItem("Alimento");
        comboTipo.setBounds(150, 220, 200, 30);
        panelFormulario.add(comboTipo);
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(150, 270, 200, 30);
        panelFormulario.add(btnAgregar);
        
        setVisible(true);        
    }
}
