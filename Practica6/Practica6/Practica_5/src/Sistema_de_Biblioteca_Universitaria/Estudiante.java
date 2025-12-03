package Sistema_de_Biblioteca_Universitaria;

public class Estudiante {
    private String codigo;
    private String nombre;
    
    // Constructor
    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    // Método 
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " - Código: " + codigo);
    }
    
    // Getter
    public String getNombre() {
        return nombre;
    }
}


