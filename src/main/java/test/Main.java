package test;

import controller.FuncionarioController;
import domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void obtenerFuncionarios(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay datos");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("id: " + funcionario.getId());
                    System.out.println("Tipo Id: " + funcionario.getTipoid());
                    System.out.println("Numero Id: " + funcionario.getNumeroid());
                    System.out.println("Nombres: " + funcionario.getNombres());
                    System.out.println("Apellidos : " + funcionario.getApellidos());
                    System.out.println("Estado Civil : " + funcionario.getEstadocivil());
                    System.out.println("Sexo : " + funcionario.getSexo());
                    System.out.println("Direccion : " + funcionario.getDireccion());
                    System.out.println("Telefono : " + funcionario.getTelefono());
                    System.out.println("Fecha de nacimiento : " + funcionario.getFechanacimiento());
                    System.out.println("--------------");
                    System.out.println("--------------");

                });

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void crear(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite la tipo de documento: ");
            String tipoid = sc.nextLine();
            System.out.println("El tipo de documento es: " + tipoid);
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("Digite la numero de documento: ");
            String numeroid = sc.nextLine();
            System.out.println("El numero de documento es: " + numeroid);
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("Digite sus nombres: ");
            String nombres = sc.nextLine();
            System.out.println("Sus nombres son: " + nombres);
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("Digite sus apellidos: ");
            String apellidos = sc.nextLine();
            System.out.println("Sus apellidos son: " + apellidos);
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("Digite su estado civil: ");
            String estadocivil = sc.nextLine();
            System.out.println("Su estado civil es: " + estadocivil);
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("Digite su sexo: ");
            String sexo = sc.nextLine();
            System.out.println("Su sexo es: " + sexo);
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("Digite su direccion: ");
            String direccion = sc.nextLine();
            System.out.println("Su direccion es: " + direccion);
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("Digite su telefono: ");
            String telefono = sc.nextLine();
            System.out.println("Su telefono es: " + telefono);
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("--------------");

            System.out.println("Digite su fecha de nacimiento(AAAA-MM-DD): ");
            String fechanacimiento = sc.nextLine();
            System.out.println("Su fecha de nacimiento es: " + fechanacimiento);
            System.out.println("--------------");
            System.out.println("--------------");

            Funcionario funcionario = new Funcionario();
            funcionario.setTipoid(tipoid);
            funcionario.setNumeroid(numeroid);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setEstadocivil(estadocivil);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechanacimiento(fechanacimiento);
            funcionarioController.crear(funcionario);
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.println("Funcionario creado con exito ");
            System.out.println("--------------");
            System.out.println("--------------");
            obtenerFuncionarios(funcionarioController);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public static void eliminarFuncionario(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el ID del funcionario: =");
            int id = sc.nextInt();
            System.out.println("El ID del funcionario es: " + id);
            
            Funcionario funcionarioExit = funcionarioController.obtenerFuncionario(id);
            if (funcionarioExit == null){
                System.out.println("No existe este funcionario ");
                return;
            }
            
            funcionarioController.eliminarFuncionario(id);
            System.out.println("Funcionario eliminado con exito! ");
            obtenerFuncionarios(funcionarioController);
          

            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        var opcion = -1;
        var scanner = new Scanner(System.in);
        FuncionarioController funcionarioController = new FuncionarioController();
        while(opcion != 0) {
            System.out.println("--------------");
            System.out.println("ELIGE ALGUNA OPCION");
            System.out.println("--------------");
            
            System.out.println("1. LISTAR FUNCIONARIOS");
            System.out.println("2. CREAR FUNCIONARIOS");
            System.out.println("3. ELIMINAR FUNCIONARIOS");
         //   System.out.println("4. LISTAR FUNCIONARIO POR ID");
          //  System.out.println("5. ACTUALIZAR FUNCIONARIO");

            System.out.println("--------------");
            
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 0:
                    System.out.println("Ha salido de la APP ");
                    break;
                    
                case 1:
                    obtenerFuncionarios(funcionarioController);
                    break;
                    
                case 2:
                    crear(funcionarioController);
                    break;
                    
                case 3: 
                    eliminarFuncionario(funcionarioController);
                    break;
                    
                default:
                    System.out.println("Opcion invalida ");
                    
                            
            }
        }
        
    }
}
