package com.egg.servicios;

import com.egg.entidades.Empleado;
import com.egg.entidades.Oficina;
import com.egg.persistencia.EmpleadoDAO;

import java.util.List;

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

    public void listarEmpleados() throws Exception {
        List<Empleado> todosEmpleados = daoEmpleado.listarTodos();
        imprimirLista(todosEmpleados);
    }

    private void imprimirLista(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getId_empleado() + " - " + empleado.getNombre() + " " + empleado.getApellido());
        }
    }

    public void listarEmpleadosPorOficina(int id_oficina) throws Exception {
        List<Empleado> empleadosOficina = daoEmpleado.listarEmpleadosPorOficina(id_oficina);
        System.out.println("Empleados de la oficina con ID " + id_oficina + ":");
        imprimirLista(empleadosOficina);
    }

    public void listarEmpleadosPorOficinaCodigoONombre(String codigoONombre) throws Exception {
        List<Empleado> empleadosOficina = daoEmpleado.listarEmpleadosPorOficinaCodigoONombre(codigoONombre);
        System.out.println("Empleados de la oficina con código o nombre '" + codigoONombre + "':");
        imprimirLista(empleadosOficina);
    }

    public void listarEmpleadosJefes() throws Exception {
        List<Empleado> empleadosJefes = daoEmpleado.listarEmpleadosJefes();
        System.out.println("Empleados que son jefes:");
        imprimirLista(empleadosJefes);
    }
    
    
}