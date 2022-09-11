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
                movimientoDineroBD.getConcepto())
                && !"".equalsIgnoreCase(
                movimientoDinero.getConcepto())) {
            movimientoDineroBD.setConcepto(
                    movimientoDinero.getConcepto());
        }

        if (Objects.nonNull(
                movimientoDineroBD.getMonto())
                && !"".equalsIgnoreCase(
                movimientoDinero.getMonto().toString())) {
            movimientoDineroBD.setMonto(
                    movimientoDinero.getMonto());

        }

        if (Objects.nonNull(
                movimientoDineroBD.getEmpleado())
                && !"".equalsIgnoreCase(
                movimientoDinero.getEmpleado().toString())) {
            movimientoDineroBD.setEmpleado(
                    movimientoDinero.getEmpleado());

        }

        if (Objects.nonNull(
                movimientoDineroBD.getEmpresa())
                && !"".equalsIgnoreCase(
                movimientoDinero.getEmpresa().toString())) {
            movimientoDineroBD.setEmpresa(
                    movimientoDinero.getEmpresa());
        }

        if (Objects.nonNull(
                movimientoDineroBD.getCreatedAt())
                && !"".equalsIgnoreCase(
                movimientoDinero.getCreatedAt().toString())) {
            movimientoDineroBD.setCreatedAt(
                    movimientoDinero.getCreatedAt());
        }

        if (Objects.nonNull(
                movimientoDineroBD.getUpdatedAt())
                && !"".equalsIgnoreCase(
                movimientoDinero.getUpdatedAt().toString())) {
            movimientoDineroBD.setUpdatedAt(
                    movimientoDinero.getUpdatedAt());
        }

        return this.movimientoDineroRepository.save(movimientoDineroBD);

    }

    public void eliminarMovimientoDinero(int id){
        this.movimientoDineroRepository.deleteById(id);
    }

    /*public List<MovimientoDinero> obtenerPorEmpresa(Integer id) {
        return movimientoDineroRepository
    }*/



}
