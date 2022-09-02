package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.repositories.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoDineroService {

    @Autowired
    private MovimientoDineroRepository movimientoDineroRepository;

    // Metodo constuctor.

    public MovimientoDineroService(MovimientoDineroRepository movimientoDineroRepository) {
        this.movimientoDineroRepository = movimientoDineroRepository;
    }

    //Métodos lógicos

    @Override
    public List<MovimientoDinero> getListaMovimientoDinero(){
        return this.movimientoDineroRepository.findAll();
    }

    @Override
    public Optional<MovimientoDinero> getMovimientoDinero(Long id){
        return this.movimientoDineroRepository.findById(id);
    }

    @Override
    public MovimientoDinero crearMovimientoDinero(MovimientoDinero nuevoMovimientoDinero){
        return this.movimientoDineroRepository.save(nuevoMovimientoDinero);
    }

    @Override
    public MovimientoDinero editarMovimientoDinero(MovimientoDinero editarMovimientoDinero){
        
    }


    @Override
    public void eliminarMovimientoDinero(Long id){
        this.movimientoDineroRepository.deleteById(id);
    }
}
