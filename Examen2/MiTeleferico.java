package Ejercicio2;
//Alejandro Ignacio Orozco Aguilar
import java.util.ArrayList;
import java.util.List;

class MiTeleferico {
    List<Linea> lineas;

    public MiTeleferico() {
        this.lineas = new ArrayList<>();
    }

    public void agregaPersonasFila(Persona P, String linea) {
        for (Linea l : lineas) {
            if (l.color.equals(linea)) {
                l.agregarPersona(P);
                break;
            }
        }
    }

    public void agregaCabinas(String linea, int nroCab) {
        for (Linea l : lineas) {
            if (l.color.equals(linea)) {
                l.agregarCabina(nroCab);
                break;
            }
        }
    }

    // b)
    public boolean verificarReglasAbordo() {
        for (Linea l : lineas) {
            if (!l.verificarCabinas()) return false;
        }
        return true;
    }

    // c) 
    public double calcularIngresoTotal() {
        double total = 0;
        for (Linea l : lineas) {
            total += l.calcularIngresoTotal();
        }
        return total;
    }

    // d) 
    public Linea mostrarLineaMasIngresoRegular() {
        Linea maxLinea = null;
        double maxIngreso = -1;
        for (Linea l : lineas) {
            double ingreso = l.calcularIngresoRegular();
            if (ingreso > maxIngreso) {
                maxIngreso = ingreso;
                maxLinea = l;
            }
        }
        return maxLinea;
    }
}

