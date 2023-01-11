package com.user.service.userservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.userservice.Model.UserModel;
import com.user.service.userservice.Service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
    
    @Autowired
    UserService service;

    @GetMapping("/getAll")
    public List<UserModel> listarUsuarios() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserModel> obtenerUsuarioPorId(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PostMapping("/save")
    public UserModel guardarUsuario(@RequestBody UserModel usuario) {
        return service.saveUser(usuario);
    }

    @PutMapping("/{id}")
    public UserModel actualizar(@RequestBody UserModel usuario, @PathVariable Integer id) {
        UserModel usuarioActual = service.getUserById(id).get();

        usuarioActual.setName(usuario.getName());
        usuarioActual.setSurname(usuario.getSurname());
        usuarioActual.setEmail(usuario.getEmail());

        return service.saveUser(usuarioActual);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuarioPorId(@PathVariable Integer id) {
        boolean ok = service.deleteUserById(id);
        if(ok){
            return "Se eliminó el usuario correctamente";
        }else{
            return "No se pudo eliminar el usuario con el id: "+id;
        }
    }
}