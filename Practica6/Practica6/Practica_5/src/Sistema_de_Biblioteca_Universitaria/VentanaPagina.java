package Sistema_de_Biblioteca_Universitaria;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPagina extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Biblioteca biblioteca;

    private JTextField txtTituloLibro;
    private JTextField txtNumero;
    private JTextArea txtContenido;

    public VentanaPagina(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Agregar página");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 520, 420);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 25, 112));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTituloVentana = new JLabel("Nueva página de libro");
        lblTituloVentana.setForeground(Color.WHITE);
        lblTituloVentana.setFont(new Font("MV Boli", Font.BOLD, 22));
        lblTituloVentana.setBounds(140, 10, 260, 30);
        contentPane.add(lblTituloVentana);

        JLabel lblLibro = new JLabel("Título del libro:");
        lblLibro.setForeground(Color.WHITE);
        lblLibro.setBounds(30, 60, 110, 20);
        contentPane.add(lblLibro);

        txtTituloLibro = new JTextField();
        txtTituloLibro.setBounds(150, 60, 330, 22);
        contentPane.add(txtTituloLibro);

        JLabel lblNumero = new JLabel("N° página:");
        lblNumero.setForeground(Color.WHITE);
        lblNumero.setBounds(30, 95, 110, 20);
        contentPane.add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(150, 95, 80, 22);
        contentPane.add(txtNumero);

        JLabel lblContenido = new JLabel("Contenido:");
        lblContenido.setForeground(Color.WHITE);
        lblContenido.setBounds(30, 130, 110, 20);
        contentPane.add(lblContenido);

        txtContenido = new JTextArea();
        txtContenido.setLineWrap(true);
        txtContenido.setWrapStyleWord(true);
        txtContenido.setBounds(30, 155, 450, 160);
        contentPane.add(txtContenido);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 12));
        btnGuardar.setBounds(130, 330, 110, 30);
        contentPane.add(btnGuardar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 12));
        btnCerrar.setBounds(270, 330, 110, 30);
        contentPane.add(btnCerrar);

        btnGuardar.addActionListener(e -> guardarPagina());
        btnCerrar.addActionListener(e -> dispose());
    }

    private void guardarPagina() {
        String tituloLibro = txtTituloLibro.getText().trim();
        String numeroStr = txtNumero.getText().trim();
        String contenido = txtContenido.getText().trim();

        if (tituloLibro.isEmpty() || numeroStr.isEmpty() || contenido.isEmpty()) {
            System.out.println("Completa todos los campos.");
            return;
        }

        int numero;
        try {
            numero = Integer.parseInt(numeroStr);
        } catch (NumberFormatException ex) {
            System.out.println("El número de página debe ser un entero.");
            return;
        }

        // Buscar libro en la biblioteca
        Libro libroEncontrado = null;
        for (Libro l : biblioteca.getLibros()) {
            if (l.getTitulo().equalsIgnoreCase(tituloLibro)) {
                libroEncontrado = l;
                break;
            }
        }

        if (libroEncontrado == null) {
            System.out.println("No se encontró un libro con ese título.");
            return;
        }

        Pagina p = new Pagina(numero, contenido);
        libroEncontrado.agregarPagina(p);
        dispose();
    }
}
