package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.services.EmpresaService;
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

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }
    @GetMapping("/empresas")
    public List<Empresa> getEmpresas(){
        return this.empresaService.getListaEmpresa();
    }
    @GetMapping("/empresas/{id}")
    public Optional<Empresa> getEmpresa(@PathVariable("id") int id){
        return this.empresaService.getEmpresa(id);
    }
    @PostMapping("/empresas")
    public Empresa crearEmpresa(@RequestBody Empresa empresa){
        return this.empresaService.crearEmpresa(empresa);
    }
    @DeleteMapping("/empresas/{id}")
    public String eliminarEmpresa(@PathVariable("id") int id){
        this.empresaService.eliminarEmpresa(id);
        return "Se ha eliminado un registro";
    }
    @PutMapping("/empresas/{id}")
    public Empresa editarEmpresa(@PathVariable("id") int id, @RequestBody Empresa empresa){
        return this.empresaService.editarEmpresa(empresa, id);
    }
}
