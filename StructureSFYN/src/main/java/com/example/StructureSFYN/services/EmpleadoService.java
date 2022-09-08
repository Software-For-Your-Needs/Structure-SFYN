package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empleado;
import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    //Método Constructor
    public EmpleadoService (EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    //Métodos Lógicos
    //@Override
    public List <Empleado> getListaEmpleados(){
        return this.empleadoRepository.findAll();
    }

    //@Override
    public Optional<Empleado> getEmpleado(int id){
        return this.empleadoRepository.findById(id);
    }

    //@Override
    public Empleado crearEmpleado(Empleado nuevoEmpleado){
        return this.empleadoRepository.save(nuevoEmpleado);
    }

    //@Override
    public Empleado editarEmpleado(Empleado empleado, int id){

        Empleado empleadoBD = empleadoRepository.findById(id).get();

        if (Objects.nonNull(
                empleado.getNombreEmpleado())
                && !"".equalsIgnoreCase(
                empleado.getNombreEmpleado())) {
            empleadoBD.setNombreEmpleado(
                    empleado.getNombreEmpleado());
        }

        if (Objects.nonNull(
                empleado.getCorreoEmpleado())
                && !"".equalsIgnoreCase(
                empleado.getCorreoEmpleado())) {
            empleadoBD.setCorreoEmpleado(
                    empleado.getCorreoEmpleado());
        }

        if (Objects.nonNull(
                empleado.getId())
                && !"".equalsIgnoreCase(
                empleado.getId().toString())) {
            empleadoBD.setId(
                    empleado.getId());
        }

        if (Objects.nonNull(
                empleado.getEmpresaEmpleado())
                && !"".equalsIgnoreCase(
                empleado.getEmpresaEmpleado().toString())) {
            empleadoBD.setEmpresaEmpleado(
                    empleado.getEmpresaEmpleado());
        }

        if (Objects.nonNull(
                empleado.getProfile())
                && !"".equalsIgnoreCase(
                empleado.getProfile().toString())) {
            empleadoBD.setProfile(
                    empleado.getProfile());
        }

        if (Objects.nonNull(
                empleado.getRol())
                && !"".equalsIgnoreCase(
                empleado.getRol().toString())) {
            empleadoBD.setRol(
                    empleado.getRol());
        }

        if (Objects.nonNull(
                empleado.getTransacciones())
                && !"".equalsIgnoreCase(
                empleado.getTransacciones().toString())) {
            empleadoBD.setTransacciones(
                    empleado.getTransacciones());
        }

        if (Objects.nonNull(
                empleado.getUpdatedAt())
                && !"".equalsIgnoreCase(
                empleado.getUpdatedAt().toString())) {
            empleadoBD.setUpdatedAt(
                    empleado.getUpdatedAt());
        }

        if (Objects.nonNull(
                empleado.getCreatedAt())
                && !"".equalsIgnoreCase(
                empleado.getCreatedAt().toString())) {
            empleadoBD.setCreatedAt(
                    empleado.getCreatedAt());
        }

        return this.empleadoRepository.save(empleadoBD);

    }

    //@Override
    public void eliminarEmpleado(int id) {
        this.empleadoRepository.deleteById(id);
    }
    

}
