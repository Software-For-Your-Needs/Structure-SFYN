package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.entities.MovimientoDinero;
import com.example.StructureSFYN.repositories.EmpresaRepository;
import com.example.StructureSFYN.repositories.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class EmpresaService{
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private MovimientoDineroService movimientoDineroService;

    @Autowired
    private MovimientoDineroRepository movimientoDineroRepository;

    //Metodo constructor

    //@Override
    //public EmpresaService(EmpresaRepository empresaRepository) {
    //    this.empresaRepository = empresaRepository;
    //}

    //
    // @Override
    public List<Empresa>getListaEmpresa(){
        return this.empresaRepository.findAll();
    }
    // @Override
    public Empresa getEmpresa(int id){
        if(!this.empresaRepository.findById(id).isEmpty()){
            return this.empresaRepository.findById(id).get();
        }else{return null;}
        
    }
    // @Override
    public boolean saveOrUpdateEmpresa(Empresa empresa) {
        Empresa emp = empresaRepository.save(empresa);
        if (empresaRepository.findById(emp.getId()) != null) {
            return true;
        }
        return false;

    }

    //@Override
    public void eliminarEmpresa(int id){
        this.empresaRepository.deleteById(id);
    }

    // @Override
    public Empresa editarEmpresa(Empresa empresa, int id) {
        Empresa empresaBD = empresaRepository.findById(id).get();

        if (Objects.nonNull(empresa.getId())) {
            empresaBD.setNombreEmpresa(empresa.getNombreEmpresa());
            empresaBD.setCiudadEmpresa(empresa.getCiudadEmpresa());
            empresaBD.setDireccionEmpresa(empresa.getDireccionEmpresa());
            empresaBD.setNitEmpresa(empresa.getNitEmpresa());
            empresaBD.setCorreoEmpresa(empresa.getCorreoEmpresa());
            empresaBD.setTipoEmpresa(empresa.getTipoEmpresa());
            empresaBD.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
            empresaBD.setTransacciones(empresa.getTransacciones());
            empresaBD.setEmpleadoList(empresa.getEmpleadoList());
            empresaBD.setUpdatedAt(new Date());
        }
        return empresaRepository.save(empresaBD);
    }

    public Empresa editarMovimientoEmpresa(Empresa empresa, int id) {
        Empresa empresaBD = empresaRepository.findById(id).get();

        if (Objects.nonNull(
                empresa.getTransacciones())
                && !"".equalsIgnoreCase(
                empresa.getTransacciones().toString())) {
            empresaBD.setTransacciones(
                    empresa.getTransacciones());
        }
        return
                empresaRepository.save
                        (empresaBD);
    }

    public  Empresa editarMovimientoDineroEmpresa(Integer id, MovimientoDinero movimientoDinero){
        MovimientoDinero movimientoDineroBD = movimientoDineroRepository.findById(movimientoDinero.getId()).get();

         movimientoDineroBD.setConcepto(movimientoDinero.getConcepto());
         movimientoDineroBD.setMonto(movimientoDinero.getMonto());
         movimientoDineroBD.setUpdatedAt(new Date());

         this.movimientoDineroRepository.save(movimientoDineroBD);

         return empresaRepository.findById(id).get();
    }
}
