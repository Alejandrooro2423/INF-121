package Ejercicio2;
//Alejandro Ignacio Orozco Aguilar
import java.util.ArrayList;
import java.util.List;

class Linea {
    String color;
    List<Persona> filaPersonas = new ArrayList<>();
    List<Cabina> cabinas = new ArrayList<>();
    int cantidadCabinas;

    public Linea(String color) {
        this.color = color;
        this.cabinas = new ArrayList<>();
        this.filaPersonas = new ArrayList<>();
    }

    public void agregarPersona(Persona P) {
        filaPersonas.add(P);
    }

    public void agregarCabina(int nroCab) {
        cabinas.add(new Cabina(nroCab));
        cantidadCabinas++;
    }

    // b) 
    public boolean verificarCabinas() {
        for (Cabina cab : cabinas) {
            if (!cab.reglaAbordoCabina()) return false;
        }
        return true;
    }

    // c) (preferencial y regular)
    public double calcularIngresoTotal() {
        double ingreso = 0;
        for (Cabina cab : cabinas) {
            for (Persona p : cab.personasAbordo) {
                if (p.edad < 25 || p.edad > 60) ingreso += 1.5; 
                else ingreso += 3; 
            }
        }
        return ingreso;
    }

    // c) 
    public double calcularIngresoRegular() {
        double ingreso = 0;
        for (Cabina cab : cabinas) {
            for (Persona p : cab.personasAbordo) {
                if (p.edad >= 25 && p.edad <= 60) ingreso += 3;
            }
        }
        return ingreso;
    }
}
