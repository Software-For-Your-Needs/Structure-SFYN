package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.repositories.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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


    public List<MovimientoDinero> getListaMovimientoDinero(){
        return this.movimientoDineroRepository.findAll();
    }


    public Optional<MovimientoDinero> getMovimientoDinero(int id){
        return this.movimientoDineroRepository.findById(id);
    }


    public MovimientoDinero crearMovimientoDinero(MovimientoDinero nuevoMovimientoDinero){
        return this.movimientoDineroRepository.save(nuevoMovimientoDinero);
    }


    public MovimientoDinero editarMovimientoDinero(MovimientoDinero movimientoDinero, int id){
        MovimientoDinero movimientoDineroBD = movimientoDineroRepository.findById(id).get();

        if (Objects.nonNull(
                movimientoDineroBD.getMontoMovimiento())
                && !"".equalsIgnoreCase(
                movimientoDinero.getMontoMovimiento().toString())) {
            movimientoDineroBD.setMontoMovimiento(
                    movimientoDinero.getMontoMovimiento());
        }

        if (Objects.nonNull(
                movimientoDineroBD.getMontosPositivos())
                && !"".equalsIgnoreCase(
                movimientoDinero.getMontosPositivos().toString())) {
            movimientoDineroBD.setMontosPositivos(
                    movimientoDinero.getMontosPositivos());

        }

        if (Objects.nonNull(
                movimientoDineroBD.getMontosNegativos())
                && !"".equalsIgnoreCase(
                movimientoDinero.getMontosNegativos().toString())) {
            movimientoDineroBD.setMontosNegativos(
                    movimientoDinero.getMontosNegativos());

        }

        if (Objects.nonNull(
                movimientoDineroBD.getConceptoMovimiento())
                && !"".equalsIgnoreCase(
                movimientoDinero.getConceptoMovimiento())) {
            movimientoDineroBD.setConceptoMovimiento(
                    movimientoDinero.getConceptoMovimiento());
        }

        if (Objects.nonNull(
                movimientoDineroBD.getUsuarioContabilidad())
                && !"".equalsIgnoreCase(
                movimientoDinero.getUsuarioContabilidad())) {
            movimientoDineroBD.setUsuarioContabilidad(
                    movimientoDinero.getUsuarioContabilidad());
        }
        
        return this.movimientoDineroRepository.save(movimientoDineroBD);
                          
    }


    public void eliminarMovimientoDinero(int id){
        this.movimientoDineroRepository.deleteById(id);
    }
}
