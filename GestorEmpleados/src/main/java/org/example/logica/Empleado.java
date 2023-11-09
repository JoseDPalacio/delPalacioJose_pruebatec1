package org.example.logica;

import org.example.exceptions.EmpleadoException;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;


    private String apellido;


    private String cargo;


    private int salario;

    private String fechaInicio;

    //Constructores
    public Empleado() {
    }

    //Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) throws EmpleadoException {
        if (id == 0) {
            throw new EmpleadoException("El id no puede ser 0");
        } else this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws EmpleadoException {
        if (nombre.isEmpty()){
            throw new EmpleadoException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws EmpleadoException {
        if (apellido.isEmpty()){
            throw new EmpleadoException("El apellido no puede estar vacio");
        }
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws EmpleadoException {
        if (cargo.isEmpty()){
            throw new EmpleadoException("El cargo no puede estar vacio");
        }
        this.cargo = cargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) throws EmpleadoException {
        if (salario==0){
            throw new EmpleadoException("El salario no puede ser 0");
        }
        this.salario = salario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) throws EmpleadoException {
        if (fechaInicio.isEmpty()){
            throw new EmpleadoException("La fecha no puede estar vacio");
        }
        this.fechaInicio = fechaInicio;
    }

    //metodo para mostrar por un print
    @Override
    public String toString() {
        return "Empleado" + " id: " + id + '\n' +
                "nombre: " + nombre + '\n' +
                "apellido: " + apellido + '\n' +
                "cargo: " + cargo + '\n' +
                "salario: " + salario + '\n' +
                "fechaInicio: " + fechaInicio;
    }
}
