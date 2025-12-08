package ABC_de_Archivos;

public class Medico {

    private int idMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;

    public Medico() { }

    public Medico(int idMed, String nombreMed,
                  String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    public int getIdMed() { 
    	return idMed; 
    }
    
    public void setIdMed(int idMed) { 
    	this.idMed = idMed; 
    }

    public String getNombreMed() { 
    	return nombreMed; 
    }
    
    public void setNombreMed(String nombreMed) { 
    	this.nombreMed = nombreMed; 
    }

    public String getApellidoMed() { 
    	return apellidoMed; 
    }
    public void setApellidoMed(String apellidoMed) { 
    	this.apellidoMed = apellidoMed; 
    }

    public int getAniosExperiencia() { 
    	return aniosExperiencia; 
    }
    
    public void setAniosExperiencia(int aniosExperiencia) { 
    	this.aniosExperiencia = aniosExperiencia; 
    }

    public String toLineaArchivo() {
        return idMed + ";" + nombreMed + ";" + apellidoMed + ";" + aniosExperiencia;
    }

    public static Medico desdeLineaArchivo(String linea) {
        String[] p = linea.split(";");
        return new Medico(
                Integer.parseInt(p[0]),
                p[1],
                p[2],
                Integer.parseInt(p[3])
        );
    }
}
