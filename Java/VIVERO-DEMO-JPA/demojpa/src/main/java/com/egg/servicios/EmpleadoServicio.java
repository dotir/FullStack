package com.egg.servicios;

import com.egg.entidades.Empleado;
import com.egg.entidades.Oficina;
import com.egg.persistencia.EmpleadoDAO;

public class EmpleadoServicio {
    private final EmpleadoDAO daoEmpleado;

    public EmpleadoServicio() {
        this.daoEmpleado = new EmpleadoDAO();
    }

    public void agregarEmpleado(String apellido, int codigoEmpleado, String email, String extension, 
                                Empleado jefe, String nombre, String puesto, Oficina oficina) {
        try {
            Empleado empleadoNuevo = new Empleado();
            empleadoNuevo.setApellido(apellido);
            empleadoNuevo.setCodigo_empleado(codigoEmpleado);
            empleadoNuevo.setEmail(email);
            empleadoNuevo.setExtension(extension);
            empleadoNuevo.setJefe(jefe);
            empleadoNuevo.setNombre(nombre);
            empleadoNuevo.setPuesto(puesto);
            empleadoNuevo.setOficina(oficina);

            daoEmpleado.agregarEmpleado(empleadoNuevo);
        } catch (Exception e) {
            System.out.println(e.toString() + " No se pudo agregar el empleado.");
        }
    }

    public void modificarEmpleado(int idEmpleado, String apellido, int codigoEmpleado, String email, String extension, 
                                  Empleado jefe, String nombre, String puesto, Oficina oficina) {
        try {
            Empleado empleado = daoEmpleado.buscarEmpleadoPorId(idEmpleado);
            if (empleado != null) {
                empleado.setApellido(apellido);
                empleado.setCodigo_empleado(codigoEmpleado);
                empleado.setEmail(email);
                empleado.setExtension(extension);
                empleado.setJefe(jefe);
                empleado.setNombre(nombre);
                empleado.setPuesto(puesto);
                empleado.setOficina(oficina);

                daoEmpleado.modificarEmpleado(empleado);
            } else {
                System.out.println("Empleado no encontrado.");
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " No se pudo modificar el empleado.");
        }
    }

    public Empleado buscarEmpleadoPorId(int idEmpleado) {
        return daoEmpleado.buscarEmpleadoPorId(idEmpleado);
    }

    public void removerEmpleado(int idEmpleado) {
        try {
            daoEmpleado.removerEmpleado(idEmpleado);
        } catch (Exception e) {
            System.out.println(e.toString() + " No se pudo remover el empleado.");
        }
    }
}
