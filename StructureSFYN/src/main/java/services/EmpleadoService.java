package services;

import com.example.StructureSFYN.entities.Empleado;
import com.example.StructureSFYN.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowire
    private EmpleadoRepository empleadoRepository;

    //Método Constructor
    public EmpleadoService (EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    //Métodos Lógicos
    @Override
    public List <Empleado> getListaEmpleados(){
        return this.empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> getEmpleado(long id){
        return this.empleadoRepository.findById(id);
    }

    @Override
    public Empleado crearEmpleado(Empleado nuevoEmpleado){
        return this.empleadoRepository.save(nuevoEmpleado);
    }

    @Override
    public Empleado editarEmpleado(Empleado editarEmpleado){
        return this.empleadoRepository.update(editarEmpleado);

    }

    @Override
    public void eliminarEmpleado(Long id) {
        this.empleadoRepository.deleteById(id);
    }
    

}
