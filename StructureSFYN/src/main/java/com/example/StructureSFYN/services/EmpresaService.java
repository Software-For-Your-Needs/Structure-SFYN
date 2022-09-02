package com.example.StructureSFYN.services;

import com.example.StructureSFYN.entities.Empresa;
import com.example.StructureSFYN.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    //Metodo constructor

   //@Override
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    //
    @Override
    public List<Empresa>getListaEmpresa(){
        return this.empresaRepository.findAll();
    }
    @Override
    public Optional<Empresa>getEmpresa(Long id){
        return this.empresaRepository.findById(id);
    }
    @Override
    public Empresa crearEmpresa(Empresa newEmpresa){
        return  this.empresaRepository.save(newEmpresa);
    }

    @Override
    public void eliminarEmpresa(Long id){
      this.empresaRepository.deleteById();
    }

    @Override
    public Empresa editarEmpresa(Empresa empresa, Long id){
        Empresa empresaBD = repository.findById(id).get();

        if (Objects.nonNull(
                empresa.getNombreEmpresa())
                && !"".equalsIgnoreCase(
                empresa.getNombreEmpresa())) {
            empresaBD.setNombreEmpresa(
                    empresa.getNombreEmpresa());
        }
    }

}
