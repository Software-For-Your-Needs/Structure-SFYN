
package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.Empleado;
import com.example.StructureSFYN.entities.Profile;
import com.example.StructureSFYN.repositories.EmpleadoRepository;
import com.example.StructureSFYN.services.EmpleadoService;
import com.example.StructureSFYN.services.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@Controller
@Slf4j
@RequestMapping("/sfyn")
public class EmpleadoControlador {


    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    ProfileService profileService;

    @Autowired
    EmpleadoRepository empleadoRepository;

    public EmpleadoControlador (EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }


    @GetMapping("/empleados123")
    public String inicio(Model model){

        List<Empleado> listaEmpleados = empleadoService.getListaEmpleados();

        model.addAttribute("empleados", listaEmpleados);

        return "empleadoVista";
    }

    @GetMapping("/empleados")
    public List<Empleado> getEmpleado(){

        return this.empleadoService.getListaEmpleados();
    }
    @GetMapping("/empleados/{id}")
    public Optional<Empleado> getEmpleado(@PathVariable("id") int id){
        return this.empleadoService.getEmpleado(id);
    }

    @PostMapping("/empleados")
    public Empleado crearEmpleado(@RequestBody Empleado empleado){
        this.profileService.crearProfile(empleado.getProfileEmpleado());
        return this.empleadoService.crearEmpleado(empleado);
    }

    @PutMapping("/empleados/{id}")
    public Empleado editarEmpleado(@PathVariable("id")int id, @RequestBody Empleado empleado){
        Profile profile = empleado.getProfileEmpleado();
        this.profileService.editarProfile(profile, profile.getId());
        return this.empleadoService.editarEmpleado(empleado, id);
    }

    @DeleteMapping("/empleados/{id}")
    public String eliminarEmpleado(@PathVariable("id")int id){
        this.empleadoService.eliminarEmpleado(id);
        return "Se ha eliminado un registro";

    }
}
