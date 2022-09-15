package com.example.StructureSFYN.controllers;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.services.EmpresaService;
import com.example.StructureSFYN.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@RequestMapping("/sfyn")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private MovimientoDineroService movimientoDineroService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/empresas")
    public String getEmpresas(Model model) {
        List<Empresa> listaEmpresas = empresaService.getListaEmpresa();
        model.addAttribute("emplist", listaEmpresas);
        return "mostrarEmpresas";
    }
    @GetMapping("/nuevaempresa")
    public String agregarEmpresa(Model model){
    Empresa nuevaEmpresa = new Empresa();
    model.addAttribute("emp", nuevaEmpresa);
    return "agregarEmpresa";
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable("id") int id) {
        if(this.empresaService.getEmpresa(id) != null){
            return new ResponseEntity<Empresa>(this.empresaService.getEmpresa(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
        }
        
    }

    @PostMapping("/guardarempresa")
    public String guardarEmpresa(Empresa empresa, RedirectAttributes redirectAttributes) {
        if(empresaService.saveOrUpdateEmpresa(empresa) == true){
            redirectAttributes.addFlashAttribute("mensaje", "saveOK");
            return "redirect:/sfyn/empresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/sfyn/empresas"; //aqui hace retorno a la lista de empresas pasando por el html
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

    @PostMapping("/empresas/{id}/movimientos")
    public MovimientoDinero crearMovimientoEmpresa(@PathVariable("id") int id, MovimientoDinero newMovimientoDinero) {
        this.movimientoDineroService.crearMovimientoDinero(newMovimientoDinero);
        List<MovimientoDinero> transacciones = this.empresaService.getEmpresa(id).getTransacciones();
        transacciones.add(newMovimientoDinero);
        this.empresaService.getEmpresa(id).setTransacciones(transacciones);
        return newMovimientoDinero;
    }

    /* @PostMapping("/empresas/{id}/movimientos")
    public Empresa crearMovimientoEmpresa(@RequestBody Empresa transacciones){
         List<MovimientoDinero> crearMovimientoDinero = this.movimientoDineroService.crearMovimientoDinero();
        return this.movimientoDineroService.crearMovimientoDinero(transacciones);
    } */


    @DeleteMapping("/empresas/{id}/movimientos")
    public String elimiarMovimientoEmpresa(@PathVariable("id") int id){
        this.movimientoDineroService.eliminarMovimientoDinero(id);
        return "se ha eliminado el registro correctamente";
    }

    @PatchMapping("/empresas/{idEmpresa}/movimientos")
    public Empresa  editar(@PathVariable("idEmpresa") int id, @RequestBody MovimientoDinero movimientoDinero){
       return this.empresaService.editarMovimientoDineroEmpresa(id, movimientoDinero);
    }

   /* @PutMapping("/empresas/{id}")
    public Empresa editarEmpresa(@PathVariable("id") int id, @RequestBody Empresa empresa) {
        return this.empresaService.editarEmpresa(empresa, id);
    } */




}