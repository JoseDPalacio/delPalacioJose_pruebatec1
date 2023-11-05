package org.example;

import org.example.exceptions.NonexistentEntityException;
import org.example.logica.Empleado;
import org.example.persistencia.ControladoraPersistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorEmpleados {

    public static void main(String[] args) throws Exception {
        //Instancian controladora de persistencia
        ControladoraPersistencia cp = new ControladoraPersistencia();

        //Variables
        int opcion = 0;
        String nombre, apellido, cargo, fechaInicio;
        int id, salario;
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienbenido al sistema de gestion de empleados");
        do {
            System.out.println("¿Que desea hacer? Pulse el numero de la pocion que desaea hacer" + '\n'
                    + "1 - para Listar todos los empleados" + '\n'
                    + "2 - para Buscar empleados por su cargo" + '\n'
                    + "3 - para añadir un nuevo empleado" + '\n'
                    + "4 - para acutalizar la informacion de un empleado" + '\n'
                    + "5 - para borrar a un empleado" + '\n'
                    + "0 - para salir y finalizar el programa");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 ->  {
                    System.out.println("Seleccionado listar todos los empleados");
                    mostrarEmpleados(listar(cp));
                }
                case 2 ->  {
                    System.out.println("Seleccionado buscar empleados por su cargo"+ '\n'
                            + "Por favor escriba el cargo");
                    cargo = sc.next();
                    mostrarEmpleados(listarPorCargo(cp, cargo));
                }
                case 3 ->  {
                    System.out.println("Seleccionado añadir un nuevo empleado");
                    aniadir(cp, crear(sc,0));

                    //System.out.println(crear(sc));

                }
                case 4 ->  {
                    System.out.println("Seleccionado acutalizar la informacion de un empleado");
                    acutalizar(cp , crear(sc,1));
                    System.out.println("Empleado actualizado");
                }
                case 5 ->  {
                    System.out.println("Selecionado borrar a un empleado"+'\n' +
                            "Por favor escriba el id del empleado que desea borrar");
                    borrar(cp, sc.nextInt());
                    System.out.println("Empleado borrado con exito");
                }
                case 0 ->  {
                    System.out.println("Seleccionado salir y finalizar el programa");
                }
                default -> System.out.println("Opcion no valida, por favor escoga una opcion valida");
            }

        } while (opcion != 0);

        System.out.println("Programa finalizado, que tenga un buen dia");
    }

    //metodos
    public static void mostrarEmpleados(List<Empleado> empleados) {
        System.out.println("---------------------------------------");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
            System.out.println("---------------------------------------");
        }
    }

    public static List<Empleado> listar(ControladoraPersistencia cp) {
        List<Empleado> empleados = cp.listarEmpleados();
        return empleados;
    }

    public static List<Empleado> listarPorCargo(ControladoraPersistencia cp, String cargo) {
        List<Empleado> empleados = cp.listarEmpleados();
        List<Empleado> empleadosCargo = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getCargo().equals(cargo)) {
                empleadosCargo.add(empleado);
            }
        }
        return empleadosCargo;
    }

    public static void aniadir(ControladoraPersistencia cp, Empleado empleado) {
        cp.crearEmpleado(empleado);
    }

    public static void acutalizar(ControladoraPersistencia cp, Empleado empleado) throws Exception {
        cp.actualizarEmpleado(empleado);
    }

    public static void borrar(ControladoraPersistencia cp, int id) throws NonexistentEntityException {
        cp.borrarEmpleado(id);
    }

    public static Empleado crear(Scanner sc, int tipoLlamada){
        Empleado empleado = new Empleado();

        if (tipoLlamada==1){
            System.out.println("Id del empleado que desea actualizar");
            empleado.setId(sc.nextInt());
        }

        System.out.println("Nombre del empleado");
        empleado.setNombre(sc.next());

        System.out.println("Apellido del empleado");
        empleado.setApellido(sc.next());

        System.out.println("Cargo del empleado");
        empleado.setCargo(sc.next());

        System.out.println("Salario del empleado");
        empleado.setSalario(sc.nextInt());

        System.out.println("Fecha de inicio del empleado");
        empleado.setFechaInicio(sc.next());
        return empleado;
    }
}
