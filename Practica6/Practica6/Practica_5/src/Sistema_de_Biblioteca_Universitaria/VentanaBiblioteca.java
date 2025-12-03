package Sistema_de_Biblioteca_Universitaria;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class VentanaBiblioteca extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Biblioteca biblioteca = new Biblioteca("Biblioteca Central UMSA");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaBiblioteca frame = new VentanaBiblioteca();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaBiblioteca() {
        setBackground(new Color(25, 25, 112));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 809, 687);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(25, 25, 112));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // BOTÓN HORARIO  
        JButton btnMostrarEstado = new JButton("BIBLIOTECA");
        btnMostrarEstado.setForeground(new Color(255, 255, 255));
        btnMostrarEstado.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnMostrarEstado.setBackground(Color.BLACK);
        btnMostrarEstado.setBounds(59, 238, 212, 66);
        btnMostrarEstado.setOpaque(true);
        contentPane.add(btnMostrarEstado);

        // Acción 
        btnMostrarEstado.addActionListener(e -> {
            VentanaMostrar vm = new VentanaMostrar(biblioteca);
            vm.setVisible(true);
        });

        // TÍTULO
        JLabel lblTitulo = new JLabel("\"Biblioteca Central UMSA\"");
        lblTitulo.setOpaque(true);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(10, 11, 773, 74);
        lblTitulo.setBackground(new Color(30, 144, 255));
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 55));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo);

        // IMAGEN
        JLabel lblLogo = new JLabel("");
        lblLogo.setBackground(Color.WHITE);
        lblLogo.setOpaque(true);
        lblLogo.setBounds(571, 99, 212, 538);
        contentPane.add(lblLogo);

        ImageIcon icon = new ImageIcon(
                VentanaBiblioteca.class.getResource("/Imagenes/logo.png"));
        Image img = icon.getImage().getScaledInstance(
                lblLogo.getWidth(),
                lblLogo.getHeight(),
                Image.SCALE_SMOOTH
        );
        lblLogo.setIcon(new ImageIcon(img));
        
        //s
        JLabel lblNewLabel = new JLabel("ELIGE UNA OPCION");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Serif", Font.BOLD, 30));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(30, 144, 255));
        lblNewLabel.setBounds(59, 133, 464, 66);
        contentPane.add(lblNewLabel);

        JButton btnPrestamo = new JButton("PRESTAMO");
        btnPrestamo.setForeground(new Color(255, 255, 255));
        btnPrestamo.setBackground(Color.BLACK);
        btnPrestamo.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnPrestamo.setBounds(312, 238, 211, 66);
        contentPane.add(btnPrestamo);
   
        JButton btnAutor = new JButton("AUTOR");
        btnAutor.setForeground(new Color(255, 255, 255));
        btnAutor.setBackground(Color.BLACK);
        btnAutor.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnAutor.setBounds(312, 465, 211, 66);
        contentPane.add(btnAutor);

        JButton btnLibro = new JButton("LIBRO");
        btnLibro.setForeground(new Color(255, 255, 255));
        btnLibro.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnLibro.setBackground(Color.BLACK);
        btnLibro.setBounds(60, 351, 211, 66);
        contentPane.add(btnLibro);
        
        JButton btnLeer = new JButton("LEER LIBRO");
        btnLeer.setForeground(new Color(255, 255, 255));
        btnLeer.setBackground(new Color(0, 0, 0));
        btnLeer.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnLeer.setBounds(59, 465, 211, 66);
        contentPane.add(btnLeer);
        btnLeer.addActionListener(e -> {
            String titulo = javax.swing.JOptionPane.showInputDialog(
                    this, "Título del libro a leer:");
            if (titulo == null || titulo.trim().isEmpty()) return;

            Libro libroEncontrado = null;
            for (Libro l : biblioteca.getLibros()) {
                if (l.getTitulo().equalsIgnoreCase(titulo.trim())) {
                    libroEncontrado = l;
                    break;
                }
            }

            if (libroEncontrado != null) {
                libroEncontrado.leer();  
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                        this, "No se encontró ese libro.");
            }
        });

        
        JButton btnPaginas = new JButton("PÁGINA");
        btnPaginas.setForeground(new Color(255, 255, 255));
        btnPaginas.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnPaginas.setBackground(new Color(0, 0, 0));
        btnPaginas.setBounds(312, 351, 211, 66);
        contentPane.add(btnPaginas);

        btnPaginas.addActionListener(e -> {
            VentanaPagina vp = new VentanaPagina(biblioteca);
            vp.setVisible(true);
        });
        
        JButton btnCerrarBiblio = new JButton("CERRAR BIBLIOTECA");
        btnCerrarBiblio.setFont(new Font("MV Boli", Font.BOLD, 30));
        btnCerrarBiblio.setForeground(new Color(255, 255, 255));
        btnCerrarBiblio.setBackground(new Color(0, 0, 0));
        btnCerrarBiblio.setBounds(59, 568, 464, 40);
        contentPane.add(btnCerrarBiblio);

        btnCerrarBiblio.addActionListener(e -> {
            biblioteca.cerrarBiblioteca();
            javax.swing.JOptionPane.showMessageDialog(
                    this, "La biblioteca ha cerrado. Los préstamos activos se borraron.");
        });

        
        //
        btnPrestamo.addActionListener(e -> {
            VentanaPrestamo vp = new VentanaPrestamo(biblioteca);
            vp.setVisible(true);
        });

        btnAutor.addActionListener(e -> {
            VentanaAutor va = new VentanaAutor(biblioteca);
            va.setVisible(true);
        });

        btnLibro.addActionListener(e -> {
            VentanaLibro vl = new VentanaLibro(biblioteca);
            vl.setVisible(true);
        });


    }
}

