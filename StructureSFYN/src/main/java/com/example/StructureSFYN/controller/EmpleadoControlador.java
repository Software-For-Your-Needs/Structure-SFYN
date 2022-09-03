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

    @PutMapping("/empleado/{id}")
    public Empleado editarEmpleado(@PathVariable("id")int id, @RequestBody Empleado empleado){
        return this.empleadoServicio.editarEmpleado(empleado, id);
    }

}
