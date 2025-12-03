package Sistema_de_Biblioteca_Universitaria;

public class Main {   
	public static void main(String[] args) {  
		// 1. COMPOSICIÓN: Biblioteca - Horario
		System.out.println("┌─────────────────────────────────────────────────────────┐");
		System.out.println("│ COMPOSICIÓN #1: Biblioteca - Horario                    │");
		System.out.println("│ El horario NO existe sin la biblioteca                  │");
		System.out.println("└─────────────────────────────────────────────────────────┘");
	        
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central UMSA");
		System.out.println("Biblioteca creada con horario interno automático");
		System.out.println("El horario se creó DENTRO del constructor de Biblioteca\n");
	         
	    // 1. COMPOSICIÓN: Libro - Página
	    System.out.println("┌─────────────────────────────────────────────────────────┐");
        System.out.println("│ COMPOSICIÓN #2: Libro - Página                          │");
        System.out.println("│ Las páginas NO existen sin el libro                     │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        
        Libro libro1 = new Libro("Raza de Bronce", "978-0307474728");
        libro1.agregarPagina(new Pagina(1, "Libro Primero: EL VALLE"));
        libro1.agregarPagina(new Pagina(2, "DE WUATA WUARA A RAZA DE BRONCE"));
        
        System.out.println("Libro creado: " + libro1.getTitulo());
        System.out.println("Páginas creadas dentro del libro (no existen solas)");
        System.out.println("Si el libro se destruye, las páginas también\n");
	        
        Libro libro2 = new Libro("La Casa de los Espíritus", "978-1501117015");
        libro2.agregarPagina(new Pagina(1, "Barrabás llegó a la familia..."));
        System.out.println("Segundo libro creado con sus página por dentro\n");
	                
        // 2. AGREGACIÓN: Biblioteca - Autor
        System.out.println("┌─────────────────────────────────────────────────────────┐");
        System.out.println("│ AGREGACIÓN #1: Biblioteca - Autor                       │");
        System.out.println("│ Los autores PUEDEN existir sin la biblioteca            │");
        System.out.println("└─────────────────────────────────────────────────────────┘"); 
        
        // Los autores se crean FUERA de la biblioteca
        Autor autor1 = new Autor("Alcides Arguedas", "Boliviano");
        Autor autor2 = new Autor("Isabel Allende", "Chilena");
        System.out.println("Autores creados fuera de la biblioteca");
        System.out.println("Los autores existen independientemente");   
        
        // Luego se registran en la biblioteca
        biblioteca.agregarAutor(autor1);
        biblioteca.agregarAutor(autor2);
        System.out.println("Autores registrados en la biblioteca");
        System.out.println("Si la biblioteca se elimina, los autores siguen existiendo\n");
	        
        // 2. AGREGACIÓN: Biblioteca - Libro
        System.out.println("┌─────────────────────────────────────────────────────────┐");
        System.out.println("│ AGREGACIÓN #2: Biblioteca - Libro                       │");
        System.out.println("│ Los libros pueden existir sin la biblioteca             │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
	        
        // (fueron creados antes)
        System.out.println("Libros creados FUERA de la biblioteca");
	        
        // Ahora se agregan a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        System.out.println("Libros agregados a la biblioteca");
        System.out.println("Los libros pueden existir sin la biblioteca\n");
	        	        
        // 3. ASOCIACIÓN: Prestamo - Estudiante - Libro

        System.out.println("┌─────────────────────────────────────────────────────────┐");
        System.out.println("│ ASOCIACIÓN: Prestamo - Estudiante - Libro               │");
        System.out.println("│ El préstamo asocia objetos que existen independiente    │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
	        
        // Fuera
        Estudiante est1 = new Estudiante("E00-1", "Alejandro Ignacio Orozco Aguilar");
        Estudiante est2 = new Estudiante("E00-2", "Geraldine Daniela Callisaya Jimenez");
        System.out.println("Estudiantes creados independientemente");
	        
        //(ambos ya existen)
        biblioteca.prestarLibro(est1, libro1);
        biblioteca.prestarLibro(est2, libro2);
        System.out.println("Préstamos creados asociando estudiantes y libros");
        System.out.println("Estudiante y libro siguen existiendo después del préstamo\n");
	            
	    }
}





