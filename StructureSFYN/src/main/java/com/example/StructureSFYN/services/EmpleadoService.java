package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empleado;
import com.example.StructureSFYN.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

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
    public Empleado getEmpleado(int id){
        if(!this.empleadoRepository.findById(id).isEmpty()){
            return this.empleadoRepository.findById(id).get();
        }else{return null;}
    }

    //@Override
    public Empleado crearEmpleado(Empleado nuevoEmpleado){
        return this.empleadoRepository.save(nuevoEmpleado);
    }

    //@Override
    public Empleado editarEmpleado(Empleado empleado, int id){

        Empleado empleadoBD = empleadoRepository.findById(id).get();

        if (Objects.nonNull(empleado.getProfile())) {
            empleadoBD.setProfile(empleado.getProfile());
            empleadoBD.setCorreoEmpleado(empleado.getCorreoEmpleado());
            empleadoBD.setId(empleado.getId());
            empleadoBD.setRolEmpleado(empleado.getRolEmpleado());
            empleadoBD.setUpDatedAt(empleado.getUpDatedAt());
            empleadoBD.setCreatedAt(empleado.getCreatedAt());
            empleadoBD.setMovimientoDinero(empleado.getMovimientoDinero());
        }

        return this.empleadoRepository.save(empleadoBD);

    }

    //@Override
    public void eliminarEmpleado(int id) {
        this.empleadoRepository.deleteById(id);
    }
    

}
