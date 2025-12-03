package Sistema_de_Biblioteca_Universitaria;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaAutor extends JFrame {

    private Biblioteca biblioteca;
    private JTextField txtNombre;
    private JTextField txtNacionalidad;

    public VentanaAutor(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Agregar autor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 427, 241);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 25, 112));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(new Color(255, 255, 255));
        lblNombre.setBounds(30, 55, 80, 20);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 55, 220, 20);
        contentPane.add(txtNombre);

        JLabel lblNac = new JLabel("Nacionalidad:");
        lblNac.setForeground(new Color(255, 255, 255));
        lblNac.setBounds(30, 98, 80, 20);
        contentPane.add(lblNac);

        txtNacionalidad = new JTextField();
        txtNacionalidad.setBounds(120, 98, 220, 20);
        contentPane.add(txtNacionalidad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 11));
        btnGuardar.setBounds(80, 140, 100, 30);
        contentPane.add(btnGuardar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 11));
        btnCerrar.setBounds(210, 140, 100, 30);
        contentPane.add(btnCerrar);
        
        JLabel lblNewLabel = new JLabel("Agregar Autor");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        lblNewLabel.setBounds(80, 11, 264, 30);
        contentPane.add(lblNewLabel);

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String nac = txtNacionalidad.getText().trim();
            if (!nombre.isEmpty() && !nac.isEmpty()) {
                Autor a = new Autor(nombre, nac);
                biblioteca.agregarAutor(a);   
                dispose();                    
            }
        });

        btnCerrar.addActionListener(e -> dispose());
    }
}
