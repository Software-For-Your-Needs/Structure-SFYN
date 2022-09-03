package com.example.StructureSFYN.controller;


import com.example.StructureSFYN.entities.Empleado;
import com.example.StructureSFYN.repository.EmpleadoRepository;
import com.example.StructureSFYN.services.EmpleadoServicio;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/sfyn")
public class EmpleadoControlador {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    EmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> getEmpleado(){
        return this.empleadoServicio.getListaEmpleado();
    }
    @GetMapping("/empleado/{id}")
    public Optional<Empleado> getEmpleado(@PathVariable("id") int id){
      return this.empleadoServicio.getEmpleado(id);
    }

    @PostMapping("/empleados")
    public Empleado crearEmpleado(@RequestBody Empleado empleado){
      return this.empleadoServicio.crearEmpleado(empleado);
    }


    ////////////////////////////

    @GetMapping("/users")
    public String consultarTodosLosUsuarios(String nombreEmpleado){

       // repositorio.consultarTodosLosUsuarios.list<empleado>
        return "nombres del servicio";
        //en el return va el servicio de consultar TODOS los usuarios
        //por lo general es con un metodo lis list<empleado>
    }

    @GetMapping("/users/{id}")
    public int consultarPorUnSoloUsuario(int id){
        return  123;
        //en el return debe de ir el servicio de consultar por un solo usuario
    }

    @DeleteMapping("/users/{id}")
    public String eliminarUnUsuario(Empleado empleado){
        //aca va el repositorio del usuario
        return "el empleado ha sido eliminado";
    }


}
