package Sistema_de_Biblioteca_Universitaria;

public class Pagina {
    private int numeroPagina;
    private String contenido;
    
    // Constructor
    public Pagina(int numeroPagina, String contenido) {
        this.numeroPagina = numeroPagina;
        this.contenido = contenido;
    }
    
    // Método ?
    public void mostrarInfo() {
        System.out.println("Página " + numeroPagina + ": " + contenido);
    }
}
