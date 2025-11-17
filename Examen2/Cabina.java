package Ejercicio2;
//Alejandro Ignacio Orozco Aguilar
import java.util.ArrayList;
import java.util.List;

class Cabina {
    int nroCabina;
    List<Persona> personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new ArrayList<>();
    }

    // a) 
    public boolean agregaPersonas(Persona p) {
        if (personasAbordo.size() == 0 && p.pesoPersona <= 850) {
            personasAbordo.add(p);
            return true;
        } else if (personasAbordo.size() < 10) {
            double pesoTotal = p.pesoPersona;
            for (Persona px : personasAbordo) pesoTotal += px.pesoPersona;
            if (pesoTotal <= 850) {
                personasAbordo.add(p);
                return true;
            }
        }
        return false;
    }

    // b) 
    public boolean reglaAbordoCabina() {
        if (personasAbordo.size() > 10) return false;
        double pesoTotal = 0;
        for (Persona p : personasAbordo) pesoTotal += p.pesoPersona;
        return pesoTotal <= 850;
    }
}


