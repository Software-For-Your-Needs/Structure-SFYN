package com.example.StructureSFYN.controller;


import com.example.StructureSFYN.entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/sfyn")
public class EmpleadoControlador {


  /**  El sistema devuelve reponses 200 en la ruta /users
    con los siguientes verbos:
    GET ya
   POST
    El sistema devuelve responses 200 en la ruta
     /user/[id] con los siguientes verbos:
    GET ya
            PATCH
    DELETE **/

    @GetMapping("/users")
    public String consultarTodosLosUsuarios(String nombreEmpleado){

       // repositorio.consultarTodosLosUsuarios.list<empleado>
        return "nombres del servicio";
        //en el return va el servicio de consultar TODOS los usuarios
        //por lo general es con un metodo lis list<empleado>
    }

    @GetMapping("/users/{id}")
    public int consultarPorUnSoloUsuario(int id){
        return  123;
        //en el return debe de ir el servicio de consultar por un solo usuario
    }

    @DeleteMapping("/users/{id}")
    public String eliminarUnUsuario(Empleado empleado){
        //aca va el repositorio del usuario
        return "el empleado ha sido eliminado";
    }


}
