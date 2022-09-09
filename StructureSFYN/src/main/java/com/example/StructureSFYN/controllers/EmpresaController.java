package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.services.EmpresaService;
import com.example.StructureSFYN.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sfyn")
@Service
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private MovimientoDineroService movimientoDineroService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/empresas")
    public List<Empresa> getEmpresas() {
        return this.empresaService.getListaEmpresa();
    }

    @GetMapping("/empresas/{id}")
    public Empresa getEmpresa(@PathVariable("id") int id) {
        return this.empresaService.getEmpresa(id);
    }

    @PostMapping("/empresas")
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return this.empresaService.crearEmpresa(empresa);
    }

    @DeleteMapping("/empresas/{id}")
    public String eliminarEmpresa(@PathVariable("id") int id) {
        this.empresaService.eliminarEmpresa(id);
        return "Se ha eliminado un registro";
    }

    @PutMapping("/empresas/{id}")
    public Empresa editarEmpresa(@PathVariable("id") int id, @RequestBody Empresa empresa) {
        return this.empresaService.editarEmpresa(empresa, id);
    }

    // Empresa y movimiento dinero
    @GetMapping("empresas/{id}/movimientos")
    public List<MovimientoDinero> getMovimientoEmpresa(@PathVariable("id") int id) {
        return this.empresaService.getEmpresa(id).getTransacciones();
    }

    @PostMapping("empresas/{id}/movimientos")
    public MovimientoDinero crearMovimientoEmpresa(@PathVariable("id") int id, MovimientoDinero newMovimientoDinero) {
        this.movimientoDineroService.crearMovimientoDinero(newMovimientoDinero);
        List<MovimientoDinero> transacciones = this.empresaService.getEmpresa(id).getTransacciones();
        transacciones.add(newMovimientoDinero);
        this.empresaService.getEmpresa(id).setTransacciones(transacciones);
        return newMovimientoDinero;
    }
}