package ABC_de_Archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Consultorio {

    private String archivoConsultas;
    private String archivoMedicos;

    public Consultorio(String archivoConsultas, String archivoMedicos) {
        this.archivoConsultas = archivoConsultas;
        this.archivoMedicos = archivoMedicos;
    }
    

    public void guardarMedico(Medico m, boolean append) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoMedicos, append))) {
            pw.println(m.toLineaArchivo());
        }
    }

    public List<Medico> leerMedicos() throws IOException {
        List<Medico> lista = new ArrayList<>();
        File f = new File(archivoMedicos);
        if (!f.exists()) return lista;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Medico.desdeLineaArchivo(linea));
            }
        }
        return lista;
    }


    public void guardarConsulta(Consulta c, boolean append) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoConsultas, append))) {
            pw.println(c.toLineaArchivo());
        }
    }

    public List<Consulta> leerConsultas() throws IOException {
        List<Consulta> lista = new ArrayList<>();
        File f = new File(archivoConsultas);
        if (!f.exists()) return lista;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Consulta c = Consulta.desdeLineaArchivo(linea);
                if (c != null) {          // solo agregas líneas correctas
                    lista.add(c);
                }
            }
        }
        return lista;
    }

    // b)

    public void bajaMedicoYConsultas(String nombre, String apellido) throws IOException {
        List<Medico> medicos = leerMedicos();
        Integer idABorrar = null;
        for (Medico m : medicos) {
            if (m.getNombreMed().equalsIgnoreCase(nombre)
                    && m.getApellidoMed().equalsIgnoreCase(apellido)) {
                idABorrar = m.getIdMed();
                break;
            }
        }
        if (idABorrar == null) {
            System.out.println("Medico no encontrado.");
            return;
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoMedicos, false))) {
            for (Medico m : medicos) {
                if (m.getIdMed() != idABorrar) {
                    pw.println(m.toLineaArchivo());
                }
            }
        }

        List<Consulta> consultas = leerConsultas();
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoConsultas, false))) {
            for (Consulta c : consultas) {
                if (c.getIdMed() != idABorrar) {
                    pw.println(c.toLineaArchivo());
                }
            }
        }
        System.out.println("Medico y sus consultas dados de baja.");
    }

    // c)

    public void cambiarDiaNavidadAnioNuevo(int nuevoDia) throws IOException {
        List<Consulta> consultas = leerConsultas();
        for (Consulta c : consultas) {
            boolean esNavidad =
                    c.getDia() == 25 && c.getMes().equalsIgnoreCase("diciembre");
            boolean esAnioNuevo =
                    c.getDia() == 1 && c.getMes().equalsIgnoreCase("enero");
            if (esNavidad || esAnioNuevo) {
                c.setDia(nuevoDia);
            }
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoConsultas, false))) {
            for (Consulta c : consultas) {
                pw.println(c.toLineaArchivo());
            }
        }
        System.out.println("Consultas de navidad/año nuevo actualizadas.");
    }
}
