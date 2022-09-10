package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.services.EmpresaService;
import com.example.StructureSFYN.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/sfyn/empresas")
@Service
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private MovimientoDineroService movimientoDineroService;
    
    @GetMapping
    public ResponseEntity<List<Empresa>> getEmpresas() {
        if(this.empresaService.getListaEmpresa() != null){
            return new ResponseEntity<List<Empresa>>(this.empresaService.getListaEmpresa(), HttpStatus.OK);
        }else{
            return new ResponseEntity<List<Empresa>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable("id") int id) {
        if(this.empresaService.getEmpresa(id) != null){
            return new ResponseEntity<Empresa>(this.empresaService.getEmpresa(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return this.empresaService.crearEmpresa(empresa);
    }

    @DeleteMapping("/{id}")
    public String eliminarEmpresa(@PathVariable("id") int id) {
        this.empresaService.eliminarEmpresa(id);
        return "Se ha eliminado un registro";
    }

    @PutMapping("/{id}")
    public Empresa editarEmpresa(@PathVariable("id") int id, @RequestBody Empresa empresa) {
        return this.empresaService.editarEmpresa(empresa, id);
    }

    // Empresa y movimiento dinero
    @GetMapping("/{id}/movimientos")
    public Set<MovimientoDinero> getMovimientoEmpresa(@PathVariable("id") int id) {
        return this.empresaService.getEmpresa(id).getTransacciones();
    }

    @PostMapping("/{id}/movimientos")
    public MovimientoDinero crearMovimientoEmpresa(@PathVariable("id") int id, MovimientoDinero newMovimientoDinero) {
        this.movimientoDineroService.crearMovimientoDinero(newMovimientoDinero);
        Set<MovimientoDinero> transacciones = empresaService.getEmpresa(id).getTransacciones();
        transacciones.add(newMovimientoDinero);
        this.empresaService.getEmpresa(id).setTransacciones(transacciones);
        return newMovimientoDinero;
    }
}