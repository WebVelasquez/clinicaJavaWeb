package controlador;

import conexion.Conexion;
import dao.PacienteDao;
import java.util.List;
import java.util.Scanner;
import modelo.Paciente;


public class PacienteController {   
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        Conexion conn = new Conexion();
        Paciente user = new Paciente(0);
        PacienteDao userd = new PacienteDao(conn);
        
        
        System.out.println("******INGRESE LOS DATOS DEL PACIENTE******");
        System.out.println("nombres -- ");
        user.setNombres(entrada.next());
        System.out.println("apellidos -- ");
        user.setApellidos(entrada.next());
        System.out.println("diagnostico del paciente -- ");
        user.setDiagnostico(entrada.next());
        System.out.println("fecha que fue ingresado -- ");
        user.setIngresado(entrada.next());
        
        boolean respuesta = userd.insert(user);
        
        if (respuesta) {
            System.out.println("PACIENTE INGRESADO");
        }else{
            System.out.println("ERROR");
        }
        
        List<Paciente> list = userd.consultarAll();
        for (Paciente user1: list) {
            System.out.println("ID del paciente:  " +user1.getIdpaciente());
            System.out.println("Paciente:  " +user1.getNombres()+ "  " +user1.getApellidos()); 
            System.out.println("Diagnostico del paciente:  " +user1.getDiagnostico());
            System.out.println("Fecha de ingreso del paciente:  " +user1.getIngresado());
        }
                
    }
}
