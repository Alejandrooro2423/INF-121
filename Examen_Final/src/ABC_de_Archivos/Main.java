package ABC_de_Archivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Consultorio consultorio =
                new Consultorio("consultas.txt", "medicos.txt");

        int opcion;
        do {
            System.out.println("---------- MENU Principal ----------");
            System.out.println("1. insiso a)");
            System.out.println("2. insiso b)");
            System.out.println("3. insiso c)");
            System.out.println("4. Listar medicos");
            System.out.println("5. Listar consultas");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        altaMasiva(consultorio);
                        break;
                    case 2:
                        bajaMedicoMenu(sc, consultorio);
                        break;
                    case 3:
                        cambiarDiaMenu(sc, consultorio);
                        break;
                    case 4:
                        listarMedicos(consultorio);
                        break;
                    case 5:
                        listarConsultas(consultorio);
                        break;
                    case 0:
                        System.out.println("Fin del programa.");
                        break;
                    default:
                        System.out.println("Opcion incorrecta.");
                }
            } catch (IOException e) {
                System.out.println("Error archivos: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }

    //a)
    private static void altaMasiva(Consultorio c) throws IOException {

        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico(1, "Alejandro",  "Pepe",    5));
        medicos.add(new Medico(2, "Hause",   "Mamani",   10));
        medicos.add(new Medico(3, "Venito",  "Camelo",  3));

        for (Medico m : medicos) {
            c.guardarMedico(m, true);
        }

        
        List<Consulta> consultas = new ArrayList<>();
        consultas.add(new Consulta(100, "Alejandro", "Orozco", 1, 10, "noviembre", 2025));
        consultas.add(new Consulta(101, "Felicia",  "Guti", 1, 25, "diciembre", 2025)); // navidad
        consultas.add(new Consulta(102, "Albertano", "Penelope",   1, 1,  "enero",     2026)); // año nuevo

        consultas.add(new Consulta(103, "Karen",  "Vega",   2, 5,  "octubre",   2025));
        consultas.add(new Consulta(104, "Elvin",  "Mora",   2, 25, "diciembre", 2025)); // navidad
        consultas.add(new Consulta(105, "Angel",  "Paz",    2, 15, "enero",     2026));

        consultas.add(new Consulta(106, "Evo", "Morales",   3, 1,  "enero",     2026)); // año nuevo
        consultas.add(new Consulta(107, "Lidia",  "Patzy",  3, 20, "diciembre", 2025));
        consultas.add(new Consulta(108, "Fernando", "Camacho", 3, 30, "noviembre", 2025));

        for (Consulta con : consultas) {
            c.guardarConsulta(con, true);
        }

        System.out.println("Se dieron de alta 3 medicos y 9 consultas. Insico esta completo que tenga buen dia Auxi ☺");
    }

    // b) 
    private static void bajaMedicoMenu(Scanner sc, Consultorio c) throws IOException {
        System.out.print("Nombre del medico: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido del medico: ");
        String apellido = sc.nextLine();
        c.bajaMedicoYConsultas(nombre, apellido);
    }

    // c) 
    private static void cambiarDiaMenu(Scanner sc, Consultorio c) throws IOException {
        System.out.print("Nuevo dia para navidad/año nuevo: ");
        int nuevoDia = sc.nextInt();
        sc.nextLine();
        c.cambiarDiaNavidadAnioNuevo(nuevoDia);
    }

    private static void listarMedicos(Consultorio c) throws IOException {
        for (Medico m : c.leerMedicos()) {
            System.out.println(m.getIdMed() + " - " +
                    m.getNombreMed() + " " + m.getApellidoMed() +
                    " (" + m.getAniosExperiencia() + " años)");
        }
    }

    private static void listarConsultas(Consultorio c) throws IOException {
        for (Consulta con : c.leerConsultas()) {
            System.out.println(con.getCi() + " - " +
                    con.getNombrePaciente() + " " + con.getApellidoPaciente() +
                    " / Medico: " + con.getIdMed() +
                    " / Fecha: " + con.getDia() + "-" +
                    con.getMes() + "-" + con.getAnio());
        }
    }
}
