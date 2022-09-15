
package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.Empleado;
import com.example.StructureSFYN.entities.Profile;
import com.example.StructureSFYN.repositories.EmpleadoRepository;
import com.example.StructureSFYN.services.EmpleadoService;
import com.example.StructureSFYN.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
@Controller
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
    public String getEmpleados(Model model){
        List<Empleado> listaEmpleados = empleadoService.getListaEmpleados();
        model.addAttribute("empList", listaEmpleados);
        return "mostrarEmpleados";
    }
    @GetMapping("/nuevoempleado")
    public String agregarEmpleado(Model model){
        Empleado nuevoEmpleado = new Empleado();
        model.addAttribute("emple", nuevoEmpleado );
        return "agregarEmpleado";
    }
    @GetMapping("/empleados/{id}")
    public Optional<Empleado> getEmpleado(@PathVariable("id") int id){
        return this.empleadoService.getEmpleado(id);
    }

    @PostMapping("/guardarempleado")
    public String guardarEmpleado(Empleado empleado, RedirectAttributes redirectAttributes ){
        if(empleadoService.saveOrUpdateEmpleado(empleado) == true) {
            redirectAttributes.addFlashAttribute("mensaje", "saveOK");
            return "redirect:/sfyn/empleados";
            //this.profileService.crearProfile(empleado.getProfileEmpleado());
        }
        //return this.empleadoService.crearEmpleado(empleado);
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/sfyn/empleados";
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
