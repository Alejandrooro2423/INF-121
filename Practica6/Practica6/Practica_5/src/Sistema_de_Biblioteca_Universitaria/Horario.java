package Sistema_de_Biblioteca_Universitaria;

public class Horario {
    private String diasApertura;
    private String horaApertura;
    private String horaCierre;
    
    // Constructor
    public Horario(String diasApertura, String horaApertura, String horaCierre) {
        this.diasApertura = diasApertura;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }
    
    // Método 
    public void mostrarHorario() {
        System.out.println("Horario: " + diasApertura);
        System.out.println("Apertura: " + horaApertura + " - Cierre: " + horaCierre);
    }
}
