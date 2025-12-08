package ABC_de_Archivos;

public class Consulta {

    private int ci;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int idMed;
    private int dia;
    private String mes;
    private int anio;

    public Consulta() { }

    public Consulta(int ci, String nombrePaciente, String apellidoPaciente,
                    int idMed, int dia, String mes, int anio) {
        this.ci = ci;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.idMed = idMed;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getCi() { 
    	return ci; 
    }
    
    public void setCi(int ci) { 
    	this.ci = ci; 
    }

    public String getNombrePaciente() { 
    	return nombrePaciente; 
    }
    
    public void setNombrePaciente(String nombrePaciente) { 
    	this.nombrePaciente = nombrePaciente; 
    }

    public String getApellidoPaciente() { 
    	return apellidoPaciente; 
    }
    public void setApellidoPaciente(String apellidoPaciente) { 
    	this.apellidoPaciente = apellidoPaciente; 
    }

    public int getIdMed() { 
    	return idMed; 
    }
    public void setIdMed(int idMed) { 
    	this.idMed = idMed; 
    }

    public int getDia() { 
    	return dia; 
    }
    
    public void setDia(int dia) { 
    	this.dia = dia; 
    }

    public String getMes() { 
    	return mes; 
    }
    
    public void setMes(String mes) { 
    	this.mes = mes; 
    }

    public int getAnio() { 
    	return anio; 
    }
    
    public void setAnio(int anio) { 
    	this.anio = anio; 
    }

    public String toLineaArchivo() {
        return ci + ";" + nombrePaciente + ";" + apellidoPaciente + ";" +
               idMed + ";" + dia + ";" + mes + ";" + anio;
    }

    public static Consulta desdeLineaArchivo(String linea) {
        String[] p = linea.split(";");
        if (p.length != 7) {
            return null;
        }
        return new Consulta(
            Integer.parseInt(p[0]),
            p[1],
            p[2],
            Integer.parseInt(p[3]),
            Integer.parseInt(p[4]),
            p[5],
            Integer.parseInt(p[6])
        );
    }

}
