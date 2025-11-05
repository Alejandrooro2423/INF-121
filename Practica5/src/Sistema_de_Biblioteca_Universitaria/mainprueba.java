package Sistema_de_Biblioteca_Universitaria;

public class mainprueba {
public static void main(String[] args) {
    	
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UMSA");
        
        Autor autor1 = new Autor("Alcides Arguedas", "Boliviano");
        Autor autor2 = new Autor("Isabel Allende", "Chilena");
        
        System.out.println("----------AUTORES----------");
        biblioteca.agregarAutor(autor1);
        biblioteca.agregarAutor(autor2);
        
        System.out.println("----------LIBROS----------");
        Libro libro1 = new Libro("Raza de Bronce", "978-0307474728");
        Libro libro2 = new Libro("La Casa de los Espíritus", "978-1501117015");
        

        libro1.agregarPagina(new Pagina(1, "Libro Primero: EL VALLE"));
        libro1.agregarPagina(new Pagina(2, "DE WUATA WUARA A RAZA DE BRONCE"));
        
        libro2.agregarPagina(new Pagina(1, "Barrabás llegó a la familia..."));
        
        // Agregar 
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        
        // Crear 
        Estudiante est1 = new Estudiante("E-001", "Alejandro Ignacio Orozco Aguilar");
        Estudiante est2 = new Estudiante("E-002", "Geraldine Daniela Callisaya Jimenez");
        
        // Realizar 
        biblioteca.prestarLibro(est1, libro1);
        biblioteca.prestarLibro(est2, libro2);
        
        // Mostrar 
        biblioteca.mostrarEstado();
        
        // Probar método 
        System.out.println("\n--- LEYENDO UN LIBRO ---");
        libro1.leer();
        
        // Cerrar 
        biblioteca.cerrarBiblioteca();
        
        // Mostrar 
        biblioteca.mostrarEstado();
	}
}