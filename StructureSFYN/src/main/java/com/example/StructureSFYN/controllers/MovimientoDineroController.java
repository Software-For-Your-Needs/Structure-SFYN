package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.repositories.MovimientoDineroRepository;
import com.example.StructureSFYN.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/movimientodinero/{id}")
    public Optional<MovimientoDinero> getMovimientoDinero(@PathVariable("id") int id){
        return this.movimientoDineroService.getMovimientoDinero(id);

    }

    @PostMapping("/movimientodinero")
    public MovimientoDinero crearMovimientoDinero (@RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoDineroService.crearMovimientoDinero(movimientoDinero);
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
