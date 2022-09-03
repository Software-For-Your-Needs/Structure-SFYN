package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.repositories.MovimientoDineroRepository;
import com.example.StructureSFYN.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sfyn")
//@Service
public class MovimientoDineroController {
    @Autowired
    private MovimientoDineroService movimientoDineroService;

    @Autowired
    private MovimientoDineroRepository movimientoDineroRepository;

    public MovimientoDineroController(MovimientoDineroService movimientoDineroService) {
        this.movimientoDineroService = movimientoDineroService;
    }
    @GetMapping("/movimientodinero")
    public List<MovimientoDinero> getMovientoDinero(){
        //return this.movimientoDineroService.getListaMovimientoDinero();
        return movimientoDineroRepository.findAll();
    }

    @GetMapping("/movimientodinero/{id}")
    public Optional<MovimientoDinero> getMovimientoDinero(@PathVariable("id") int id){
        return this.movimientoDineroService.getMovimientoDinero(id);

    }
}
