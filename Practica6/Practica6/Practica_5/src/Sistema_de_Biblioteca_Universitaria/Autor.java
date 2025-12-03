package Sistema_de_Biblioteca_Universitaria;

public class Autor {
    private String nombre;
    private String nacionalidad; 
    // Constructor
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }   
    // Método 
    public void mostrarInfo() {
        System.out.println("Autor: " + nombre + " - Nacionalidad: " + nacionalidad);
    }
    // Getter
    public String getNombre() {
        return nombre;
    }
}



