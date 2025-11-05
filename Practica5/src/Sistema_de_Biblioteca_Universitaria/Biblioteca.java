package Sistema_de_Biblioteca_Universitaria;
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Autor> autores;
    private ArrayList<Prestamo> prestamos;
    private Horario horario;
    
    // Constructor
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        // Composición: el horario se crea dentro de la biblioteca
        this.horario = new Horario("Lunes a Viernes", "8:00 AM", "6:00 PM");
    }
    
    // Método 
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }
    
    // Método 
    public void agregarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor registrado: " + autor.getNombre());
    }
    
    // Método 
    public void prestarLibro(Estudiante estudiante, Libro libro) {
        Prestamo nuevoPrestamo = new Prestamo(estudiante, libro);
        prestamos.add(nuevoPrestamo);
        System.out.println("Préstamo creado exitosamente.");
    }
    
    // Método 
    public void mostrarEstado() {
        System.out.println("\n=====================================================================");
        System.out.println("		BIBLIOTECA: " + nombre);
        System.out.println("=====================================================================");
        System.out.println("\n-------------------HORARIO------------------");
        horario.mostrarHorario();
        System.out.println("--------------------------------------------");
        
        System.out.println("\n				||||||||LIBROS DISPONIBLES||||||||				");
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }
        
        System.out.println("\n--- AUTORES REGISTRADOS ---");
        for (Autor autor : autores) {
            autor.mostrarInfo();
        }
        
        System.out.println("\n--- PRÉSTAMOS ACTIVOS ---");
        for (Prestamo prestamo : prestamos) {
            prestamo.mostrarInfo();
        }
    }
    
    // Método 
    public void cerrarBiblioteca() {
        System.out.println("\n*** La biblioteca " + nombre + " ha cerrado. ***");
        System.out.println("Los préstamos activos dejan de existir.");
        prestamos.clear();
    }
}
