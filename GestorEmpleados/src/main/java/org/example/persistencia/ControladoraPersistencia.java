package org.example.persistencia;

import org.example.exceptions.NonexistentEntityException;
import org.example.logica.Empleado;

import java.util.List;

public class ControladoraPersistencia {
    EmpleadoJpaController empleadoJpaController = new EmpleadoJpaController();

    //metodo para insertar
    public void crearEmpleado(Empleado empleado){
        empleadoJpaController.create(empleado);
    }

    //metodo para borrarr
    public void borrarEmpleado(int id) throws NonexistentEntityException {
        empleadoJpaController.destroy(id);
    }

    //metodo para actualizar
    public void actualizarEmpleado(Empleado empleado) throws Exception{
        empleadoJpaController.edit(empleado);
    }

    //metodo para buscar empleado
    public List<Empleado> listarEmpleados(){
        return empleadoJpaController.findEmpleadoEntities();
    }
}
