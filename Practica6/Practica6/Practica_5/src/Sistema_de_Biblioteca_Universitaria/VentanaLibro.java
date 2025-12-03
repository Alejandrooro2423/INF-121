package Sistema_de_Biblioteca_Universitaria;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaLibro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Biblioteca biblioteca;
    private JTextField txtTitulo;
    private JTextField txtIsbn;

    public VentanaLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Agregar libro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 420, 260);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 25, 112));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTituloVentana = new JLabel("Nuevo libro");
        lblTituloVentana.setForeground(Color.WHITE);
        lblTituloVentana.setFont(new Font("MV Boli", Font.BOLD, 22));
        lblTituloVentana.setBounds(140, 10, 150, 30);
        contentPane.add(lblTituloVentana);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(40, 60, 80, 20);
        contentPane.add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(120, 60, 240, 22);
        contentPane.add(txtTitulo);

        JLabel lblIsbn = new JLabel("ISBN:");
        lblIsbn.setForeground(Color.WHITE);
        lblIsbn.setBounds(40, 100, 80, 20);
        contentPane.add(lblIsbn);

        txtIsbn = new JTextField();
        txtIsbn.setBounds(120, 100, 240, 22);
        contentPane.add(txtIsbn);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 11));
        btnGuardar.setBounds(80, 160, 110, 30);
        contentPane.add(btnGuardar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 11));
        btnCerrar.setBounds(220, 160, 110, 30);
        contentPane.add(btnCerrar);

        btnGuardar.addActionListener(e -> {
            String titulo = txtTitulo.getText().trim();
            String isbn = txtIsbn.getText().trim();

            if (!titulo.isEmpty() && !isbn.isEmpty()) {
                Libro libro = new Libro(titulo, isbn);
                biblioteca.agregarLibro(libro);
                dispose();
            }
        });

        btnCerrar.addActionListener(e -> dispose());
    }
}
