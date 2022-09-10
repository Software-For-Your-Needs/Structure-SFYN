
package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.Empleado;
import com.example.StructureSFYN.entities.Profile;
import com.example.StructureSFYN.repositories.EmpleadoRepository;
import com.example.StructureSFYN.services.EmpleadoService;
import com.example.StructureSFYN.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/sfyn")
public class EmpleadoControlador {


    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    ProfileService profileService;

    public EmpleadoControlador (EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> getEmpleado(){

        if(this.empleadoService.getListaEmpleados() != null){
            return new ResponseEntity<List<Empleado>>(this.empleadoService.getListaEmpleados(), HttpStatus.OK);
        }else{
            return new ResponseEntity<List<Empleado>>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable("id") int id){
        if(this.empleadoService.getEmpleado(id) != null){
            return new ResponseEntity<Empleado>(this.empleadoService.getEmpleado(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/empleados")
    public Empleado crearEmpleado(@RequestBody Empleado empleado){
        System.out.println("Step1");
        //this.profileService.crearProfile(empleado.getProfileEmpleado());
        return this.empleadoService.crearEmpleado(empleado);
    }

    @PutMapping("/empleados/{id}")
    public Empleado editarEmpleado(@PathVariable("id")int id, @RequestBody Empleado empleado){
        Profile profile = empleado.getProfile();
        this.profileService.editarProfile(profile, profile.getId());
        return this.empleadoService.editarEmpleado(empleado, id);
    }

    @DeleteMapping("/empleados/{id}")
    public String eliminarEmpleado(@PathVariable("id")int id){
        this.empleadoService.eliminarEmpleado(id);
        return "Se ha eliminado un registro";

    }
}
