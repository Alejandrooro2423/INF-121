package Sistema_de_Biblioteca_Universitaria;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPrestamo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Biblioteca biblioteca;

    private JTextField txtCodigoEst;
    private JTextField txtNombreEst;
    private JTextField txtTituloLibro;

    public VentanaPrestamo(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Nuevo préstamo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 480, 300);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 25, 112));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTituloVentana = new JLabel("Registrar préstamo");
        lblTituloVentana.setForeground(Color.WHITE);
        lblTituloVentana.setFont(new Font("MV Boli", Font.BOLD, 22));
        lblTituloVentana.setBounds(140, 10, 220, 30);
        contentPane.add(lblTituloVentana);

        JLabel lblCod = new JLabel("Código estudiante:");
        lblCod.setForeground(Color.WHITE);
        lblCod.setBounds(40, 60, 120, 20);
        contentPane.add(lblCod);

        txtCodigoEst = new JTextField();
        txtCodigoEst.setBounds(180, 60, 250, 22);
        contentPane.add(txtCodigoEst);

        JLabel lblNom = new JLabel("Nombre estudiante:");
        lblNom.setForeground(Color.WHITE);
        lblNom.setBounds(40, 100, 130, 20);
        contentPane.add(lblNom);

        txtNombreEst = new JTextField();
        txtNombreEst.setBounds(180, 100, 250, 22);
        contentPane.add(txtNombreEst);

        JLabel lblLibro = new JLabel("Título del libro:");
        lblLibro.setForeground(Color.WHITE);
        lblLibro.setBounds(40, 140, 130, 20);
        contentPane.add(lblLibro);

        txtTituloLibro = new JTextField();
        txtTituloLibro.setBounds(180, 140, 250, 22);
        contentPane.add(txtTituloLibro);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
        btnGuardar.setBounds(120, 200, 110, 30);
        contentPane.add(btnGuardar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
        btnCerrar.setBounds(260, 200, 110, 30);
        contentPane.add(btnCerrar);

        btnGuardar.addActionListener(e -> {
            String cod = txtCodigoEst.getText().trim();
            String nom = txtNombreEst.getText().trim();
            String tituloLibro = txtTituloLibro.getText().trim();

            if (!cod.isEmpty() && !nom.isEmpty() && !tituloLibro.isEmpty()) {
                // 
                Estudiante est = new Estudiante(cod, nom);

                // 
                Libro libroEncontrado = null;
                for (Libro l : biblioteca.getLibros()) {
                    if (l.getTitulo().equalsIgnoreCase(tituloLibro)) {
                        libroEncontrado = l;
                        break;
                    }
                }

                if (libroEncontrado != null) {
                    biblioteca.prestarLibro(est, libroEncontrado);
                    dispose();
                } else {
                    // 
                    System.out.println("No se encontró un libro con ese título.");
                }
            }
        });

        btnCerrar.addActionListener(e -> dispose());
    }
}
