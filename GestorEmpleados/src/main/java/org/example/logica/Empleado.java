package org.example.logica;

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

    //Uso para crear empleado para el insert
    public Empleado(String nombre, String apellido, String cargo, int salario, String fechaInicio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    //Uso para crear un empleado para el update
    public Empleado(int id, String nombre, String apellido, String cargo, int salario, String fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }


    //Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
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
