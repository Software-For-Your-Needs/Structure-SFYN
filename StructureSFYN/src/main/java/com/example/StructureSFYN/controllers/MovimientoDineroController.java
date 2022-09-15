package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.repositories.MovimientoDineroRepository;
import com.example.StructureSFYN.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sfyn")
//@Service
public class MovimientoDineroController {
    @Autowired
    private MovimientoDineroService movimientoDineroService;

    public MovimientoDineroController(MovimientoDineroService movimientoDineroService) {
        this.movimientoDineroService = movimientoDineroService;
    }
    @GetMapping("/movimientodinero")
    public String getMovientoDinero(Model model){
        List <MovimientoDinero> listaMovimientoDinero = movimientoDineroService.getListaMovimientoDinero();
        model.addAttribute("movilist", listaMovimientoDinero);
        return "mostrarMovimientoDinero";
    }

    @GetMapping("/nuevomovimientodinero")
    public String agregarMovimientoDinero (Model model){
        MovimientoDinero nuevoMovimientoDinero = new MovimientoDinero();
        model.addAttribute("mov",nuevoMovimientoDinero);
        return "agregarMovimientoDinero";
    }
    @GetMapping("/movimientodinero/{id}")
    public Optional<MovimientoDinero> getMovimientoDinero(@PathVariable("id") int id){
        return this.movimientoDineroService.getMovimientoDinero(id);

    }

    @PostMapping("/guardarmovimientodinero")
    public String guardarMovimientoDinero (MovimientoDinero movimientoDinero, RedirectAttributes redirectAttributes ){
        if(movimientoDineroService.saveOrUpdateMovimientoDinero(movimientoDinero) == true){
            redirectAttributes.addFlashAttribute("mensaje", "saveOK");
            return "redirect:/sfyn/movimientodinero";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/sfyn/movimientodinero";

    }

    @DeleteMapping("/movimientodinero/{id}")
    public String eliminarMovimientoDinero(@PathVariable("id") int id){
        this.movimientoDineroService.eliminarMovimientoDinero(id);
        return "Se ha eliminado un registro";
    }

    @PutMapping("/movimientodinero/{id}")
    public MovimientoDinero editarMovimientoDinero(@PathVariable("id") int id, @RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoDineroService.editarMovimientoDinero(movimientoDinero, id);

    }

}
