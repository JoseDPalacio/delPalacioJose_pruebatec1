package org.example;

import org.example.exceptions.EmpleadoException;
import org.example.exceptions.NonexistentEntityException;
import org.example.logica.Empleado;
import org.example.persistencia.ControladoraPersistencia;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestorEmpleados {
    //Instancian controladora de persistencia
    static ControladoraPersistencia cp = new ControladoraPersistencia();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //Variables
        int opcion;
        String cargo;

        System.out.println("Bienbenido al sistema de gestion de empleados");
        do {
            try {
                System.out.println("""
                        ¿Que desea hacer? Pulse el numero de la opcion que desaea hacer
                        1 - para Listar todos los empleados
                        2 - para Buscar empleados por su cargo
                        3 - para Añadir un nuevo empleado
                        4 - para Acutalizar la informacion de un empleado
                        5 - para Borrar a un empleado
                        0 - para Salir y finalizar el programa""");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Seleccionado: Listar todos los empleados");
                        mostrarEmpleados(listar());
                    }
                    case 2 -> {
                        System.out.println("Seleccionado: Buscar empleados por su cargo" + '\n'
                                + "Por favor escriba el cargo");
                        sc.nextLine();
                        cargo = sc.nextLine();
                        while (cargo.isEmpty()) {
                            System.out.println("No ha escrito el cargo que desea buscar" +
                                    ", por favor escribalo");
                            cargo = sc.nextLine();
                        }
                        mostrarEmpleados(listarPorCargo(cargo));
                    }
                    case 3 -> {
                        System.out.println("Seleccionado: Añadir un nuevo empleado");
                        try {
                            aniadir(crear(0));
                        } catch (EmpleadoException ex) {
                            System.err.println("Error!! " + ex.getMessage());
                            sc.nextLine();
                        }

                    }
                    case 4 -> {
                        System.out.println("Seleccionado: Acutalizar la informacion de un empleado");
                        try {
                            acutalizar(crear(1));
                            System.out.println("Empleado actualizado");
                        } catch (EmpleadoException ex) {
                            System.err.println("Error!! " + ex.getMessage());
                            sc.nextLine();
                        }
                    }
                    case 5 -> {
                        System.out.println("Selecionado: borrar a un empleado" + '\n' +
                                "Por favor escriba el id del empleado que desea borrar");
                        borrar(sc.nextInt());
                        System.out.println("Empleado borrado con exito");
                    }
                    case 0 -> System.out.println("Seleccionado: Salir y finalizar el programa");
                    default -> System.out.println("Opcion no valida, por favor escoga una opcion valida");
                }
            } catch (InputMismatchException ime) {
                System.err.println("Error de tipo de dato ingresado");
                sc.nextLine();
                opcion = -1;
            }

        } while (opcion != 0);

        System.out.println("Programa finalizado, que tenga un buen dia");
    }

    //metodos
    public static void mostrarEmpleados(List<Empleado> empleados) {
        System.out.println("---------------------------------------");
        //Comprobador de si existen empleados en la BBDD
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en la BBDD" + '\n' +
                    "------------------------------------------");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println(empleado + "\n" +
                        "------------------------------------------");
            }
        }
    }

    public static List<Empleado> listar() {
        return cp.listarEmpleados();
    }

    public static List<Empleado> listarPorCargo(String cargo) {
        List<Empleado> empleados = cp.listarEmpleados();
        //Nueva lista de empleados donde solo existen los empleados que tienen el cargo buscado
        List<Empleado> empleadosCargo = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getCargo().equals(cargo)) {
                empleadosCargo.add(empleado);
            }
        }

        return empleadosCargo;
    }

    public static void aniadir(Empleado empleado) {
        cp.crearEmpleado(empleado);
    }

    public static void acutalizar(Empleado empleado) throws Exception {
        cp.actualizarEmpleado(empleado);
    }

    public static void borrar(int id) throws NonexistentEntityException {
        cp.borrarEmpleado(id);
    }

    public static Empleado crear(int tipoLlamada) throws Exception {
        Empleado empleado = new Empleado();

        if (tipoLlamada == 1) {
            System.out.println("Id del empleado que desea actualizar");
            empleado.setId(sc.nextInt());
        }

        System.out.println("Nombre del empleado");
        sc.nextLine();
        empleado.setNombre(sc.nextLine());

        System.out.println("Apellido del empleado");
        empleado.setApellido(sc.nextLine());

        System.out.println("Cargo del empleado");
        empleado.setCargo(sc.nextLine());

        System.out.println("Salario del empleado");
        empleado.setSalario(sc.nextInt());

        System.out.println("Fecha de inicio del empleado(DD/MM/YYYY)");
        sc.nextLine();
        empleado.setFechaInicio(sc.nextLine());

        return empleado;
    }
}
