package Sistema_de_Biblioteca_Universitaria;

public class Prestamo {
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;
    
    // Constructor
    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = "05/11/2025"; 
        this.fechaDevolucion = "12/11/2025"; 
    }
    
    public void mostrarInfo() {
        System.out.println("=== PRÉSTAMO ===");
        System.out.println("Fecha préstamo: " + fechaPrestamo);
        System.out.println("Fecha devolución: " + fechaDevolucion);
        estudiante.mostrarInfo();
        libro.mostrarInfo();
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

}
