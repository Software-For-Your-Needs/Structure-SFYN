package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.repositories.MovimientoDineroRepository;
import com.example.StructureSFYN.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sfyn/movimientodinero")
//@Service
public class MovimientoDineroController {
    @Autowired
    private MovimientoDineroService movimientoDineroService;

    public MovimientoDineroController(MovimientoDineroService movimientoDineroService) {
        this.movimientoDineroService = movimientoDineroService;
    }
    @GetMapping
    public List<MovimientoDinero> getMovientoDinero(){
        return this.movimientoDineroService.getListaMovimientoDinero();
        //return movimientoDineroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MovimientoDinero> getMovimientoDinero(@PathVariable("id") int id){
        return this.movimientoDineroService.getMovimientoDinero(id);
    }

    @PostMapping
    public MovimientoDinero crearMovimientoDinero (@RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoDineroService.crearMovimientoDinero(movimientoDinero);
    }

    @DeleteMapping("/{id}")
    public String eliminarMovimientoDinero(@PathVariable("id") int id){
        this.movimientoDineroService.eliminarMovimientoDinero(id);
        return "Se ha eliminado un registro";
    }

    @PutMapping("/{id}")
    public MovimientoDinero editarMovimientoDinero(@PathVariable("id") int id, @RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoDineroService.editarMovimientoDinero(movimientoDinero, id);
    }

}
