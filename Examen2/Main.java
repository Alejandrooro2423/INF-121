package Ejercicio2;

public class Main {
    public static void main(String[] args) {
    	System.out.println("----------Bienvenido a Mi Teleferico----------");
        MiTeleferico sistema = new MiTeleferico();

        //SOLO AMARILLO,ROJO,VERDE
        Linea lAmarillo = new Linea("Amarillo");
        Linea lRojo = new Linea("Rojo");
        Linea lVerde = new Linea("Verde");

        sistema.lineas.add(lAmarillo);
        sistema.lineas.add(lRojo);
        sistema.lineas.add(lVerde);

        sistema.agregaCabinas("Amarillo", 1);
        sistema.agregaCabinas("Rojo", 1);
        sistema.agregaCabinas("Verde", 1);

        Persona p1 = new Persona("Alejandro", 22, 60);
        Persona p2 = new Persona("Elisandro", 35, 80);
        Persona p3 = new Persona("Juan", 61, 65);
        Persona p4 = new Persona("Geraldine", 28, 70);
        Persona p5 = new Persona("Arom", 17, 75);

        sistema.agregaPersonasFila(p1, "Amarillo");
        sistema.agregaPersonasFila(p2, "Rojo");
        sistema.agregaPersonasFila(p3, "Verde");
        sistema.agregaPersonasFila(p4, "Amarillo");
        sistema.agregaPersonasFila(p5, "Rojo");

        lAmarillo.cabinas.get(0).agregaPersonas(p1);
        lAmarillo.cabinas.get(0).agregaPersonas(p4);
        lRojo.cabinas.get(0).agregaPersonas(p2);
        lRojo.cabinas.get(0).agregaPersonas(p5);
        lVerde.cabinas.get(0).agregaPersonas(p3);

        // b)
        System.out.println("¿Todas las cabinas cumplen las reglas? " + sistema.verificarReglasAbordo());

        // c)(preferencial + regular)
        System.out.println("Ingreso total de todas las líneas: " + sistema.calcularIngresoTotal() + " bs");

        // d) SOLO regular
        Linea maxLinea = sistema.mostrarLineaMasIngresoRegular();
        if (maxLinea != null)
            System.out.println("Línea con más ingreso regular: " + maxLinea.color + " (" + maxLinea.calcularIngresoRegular() + " bs)");
        else
            System.out.println("No hay ingresos regulares.");
    }
}
