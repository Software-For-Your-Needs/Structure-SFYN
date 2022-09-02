package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.services.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sfyn")
public class EmpresaController {

    EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }
    @GetMapping("/empresas")
    public List<Empresa> ListarEmpresar(){
        return this.service.getListaEmpresa();
    }
    @GetMapping("/empresas/{id}")
    public Optional<Empresa> getEmpresa(@PathVariable("id") Long id) {
        return this.service.getEmpresa(id);
    }

    @PostMapping("/empresas")
    public Empresa crearEmpresa(@RequestBody Empresa empresa){
        return this.service.crearEmpresa(empresa);

    }

    @DeleteMapping("/empresas/{id}")
    public String eliminarEmpresa(@PathVariable("id") Long id){
        this.service.eliminarEmpresa(id);
        return "Se ha eliminado registro satisfactoriamente.";
    }
}
