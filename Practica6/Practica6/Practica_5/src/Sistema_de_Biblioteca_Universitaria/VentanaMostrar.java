package Sistema_de_Biblioteca_Universitaria;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaMostrar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Biblioteca biblioteca;    
    private JTextArea txtArea;        

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Biblioteca b = new Biblioteca("Biblioteca Central UMSA");
                    VentanaMostrar frame = new VentanaMostrar(b);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //
    public VentanaMostrar(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Estado de la Biblioteca");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 520);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 25, 112));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        //
        JLabel lblLogo = new JLabel();
        lblLogo.setBounds(390, 72, 284, 360);   
        contentPane.add(lblLogo);

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/Imagenes/imagenlibro.png"));
        Image img = icon.getImage().getScaledInstance(280, 350, Image.SCALE_SMOOTH
        );
        lblLogo.setIcon(new ImageIcon(img));

        //
        JLabel lblTitulo = new JLabel("Estado detallado de la biblioteca");
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(30, 144, 255));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("MV Boli", Font.BOLD, 30));
        lblTitulo.setBounds(10, 11, 664, 50);
        contentPane.add(lblTitulo);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 72, 370, 360);
        contentPane.add(scrollPane);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        scrollPane.setViewportView(txtArea);

        //
        JButton btnVolver = new JButton("VOLVER\r\n");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBackground(Color.BLACK);
        btnVolver.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnVolver.setBounds(414, 443, 151, 30);
        contentPane.add(btnVolver);
        btnVolver.addActionListener(e -> dispose());

        //
        JButton btnMensajes = new JButton("DETALLES\r\n");
        btnMensajes.setForeground(Color.WHITE);
        btnMensajes.setBackground(Color.BLACK);
        btnMensajes.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnMensajes.setBounds(134, 443, 151, 30);
        contentPane.add(btnMensajes);

        //
        btnMensajes.addActionListener(e -> {
            if (biblioteca.getAutores().isEmpty()
                    && biblioteca.getLibros().isEmpty()
                    && biblioteca.getPrestamos().isEmpty()) {
                txtArea.setText("Todavía no hay autores, libros ni préstamos registrados.");
            } else {
                txtArea.setText("Ya existen registros en la biblioteca.\n\n" + txtArea.getText());
                txtArea.setCaretPosition(0);
                
            }
        });
        mostrarEstadoDetallado();
    }
    
    private void mostrarEstadoDetallado() {
        StringBuilder sb = new StringBuilder();

        sb.append("	BIBLIOTECA: ").append(biblioteca.getNombre()).append("\n");
        sb.append("=============================================\n\n");

        sb.append("	--- AUTORES REGISTRADOS ---\n");
        for (Autor a : biblioteca.getAutores()) {
            sb.append("Autor: ").append(a.getNombre()).append("\n");
        }
        sb.append("\n");

        sb.append("	--- LIBROS DISPONIBLES ---\n");
        for (Libro l : biblioteca.getLibros()) {
            sb.append("Libro: ").append(l.getTitulo()).append("\n");
        }
        sb.append("\n");

        sb.append("	--- PRESTAMOS ACTIVOS ---\n");
        for (Prestamo p : biblioteca.getPrestamos()) {
            sb.append("Préstamo de: ")
              .append(p.getEstudiante().getNombre())
              .append(" -> ")
              .append(p.getLibro().getTitulo())
              .append("\n");
        }

        txtArea.setText(sb.toString());
        txtArea.setCaretPosition(0);
    }
}
