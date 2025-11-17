package Ejercicio2;
//Alejandro Ignacio Orozco Aguilar
class Persona {
    String nombre;
    int edad;
    double pesoPersona;

    public Persona(String nombre, int edad, double pesoPersona) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoPersona = pesoPersona;
    }

	@Override
	public  String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", pesoPersona=" + pesoPersona + "]";
	}
    
}






