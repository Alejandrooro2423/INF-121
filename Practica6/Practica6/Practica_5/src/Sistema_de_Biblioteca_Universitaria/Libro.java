package Sistema_de_Biblioteca_Universitaria;

import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String isbn;
    private ArrayList<Pagina> paginas;
    
    // Constructor
    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
    }
    
    // Método 
    public void agregarPagina(Pagina pagina) {
        paginas.add(pagina);
    }
    
    // Método
    public void leer() {
        System.out.println("Leyendo libro: " + titulo + " (ISBN: " + isbn + ")");
        for (Pagina pagina : paginas) {
            pagina.mostrarInfo();
        }
    }
    
    // Método 
    public void mostrarInfo() {
        System.out.println("Libro: " + titulo + " - ISBN: " + isbn + " - Páginas: " + paginas.size());
    }
    
    // Getter
    public String getTitulo() {
        return titulo;
    }
}

