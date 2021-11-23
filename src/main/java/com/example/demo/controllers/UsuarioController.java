package com.example.demo.controllers;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> listar(){
        return usuarioService.listar();
    }

    @PostMapping()
    public UsuarioModel save(@RequestBody UsuarioModel usuario){
        return usuarioService.save(usuario);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModel> listarId(@PathVariable("id") Long id){
        return usuarioService.listarId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.listarPrioridad(prioridad);
    }

    @DeleteMapping("/{id}")
    public String elimar(@PathVariable("id") Long id){
        boolean ok = usuarioService.eliminar(id);
        if(ok){
            return "Se elimino el usuario con id " + id;
        }else {
            return "No pudo eliminar el usuario con el id: " +id;
        }
    }

    @PutMapping
    public void actualizar(@RequestBody UsuarioModel usuario){
        usuarioService.save(usuario);
    }

}
