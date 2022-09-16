package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empleado;
import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.entities.Profile;
import com.example.StructureSFYN.repositories.EmpleadoRepository;
import com.example.StructureSFYN.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    private ProfileRepository profileRepository;

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
    public Empleado getEmpleado(Integer id){
        return this.empleadoRepository.findById(id).get();
    }

    //@Override
    /*public Empleado crearEmpleado(Empleado nuevoEmpleado){
        return this.empleadoRepository.save(nuevoEmpleado);
    }*/
    public boolean saveOrUpdateEmpleado(Empleado empleado) {
        Empleado emple = empleadoRepository.save(empleado);
        if (empleadoRepository.findById(emple.getId()) != null) {
            return true;
        }
        return false;

    }

    //@Override
    public Empleado editarEmpleado(Empleado empleado, int id){

        Empleado empleadoBD = empleadoRepository.findById(id).get();

        /*if (Objects.nonNull(
                empleado.getProfileEmpleado())
                && !"".equalsIgnoreCase(
                empleado.getProfileEmpleado().toString())) {
            empleadoBD.setProfileEmpleado(
                    empleado.getProfileEmpleado());
        }*/

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
                empleado.getRolEmpleado())
                && !"".equalsIgnoreCase(
                empleado.getRolEmpleado().toString())) {
            empleadoBD.setRolEmpleado(
                    empleado.getRolEmpleado());
        }
        if (Objects.nonNull(
                empleado.getUpDatedAt())
                && !"".equalsIgnoreCase(
                empleado.getUpDatedAt().toString())) {
            empleadoBD.setUpDatedAt(
                    empleado.getUpDatedAt());
        }
        if (Objects.nonNull(
                empleado.getCreatedAt())
                && !"".equalsIgnoreCase(
                empleado.getCreatedAt().toString())) {
            empleadoBD.setCreatedAt(
                    empleado.getCreatedAt());
        }
        if (Objects.nonNull(
                empleado.getTransaccion())
                && !"".equalsIgnoreCase(
                empleado.getTransaccion().toString())) {
            empleadoBD.setTransaccion(
                    empleado.getTransaccion());
        }

        if (Objects.nonNull(
                empleado.getNombreEmpleado())
                && !"".equalsIgnoreCase(
                empleado.getNombreEmpleado())) {
            empleadoBD.setNombreEmpleado(
                    empleado.getNombreEmpleado());
        }

        if (Objects.nonNull(
                empleado.getTelefonoEmpleado())
                && !"".equalsIgnoreCase(
                empleado.getTelefonoEmpleado().toString())) {
            empleadoBD.setTelefonoEmpleado(
                    empleado.getTelefonoEmpleado());
        }

        return this.empleadoRepository.save(empleadoBD);

    }

    //@Override
    public void eliminarEmpleado(int id) {
        this.empleadoRepository.deleteById(id);
    }
    

}
