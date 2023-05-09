package com.novacomp.crud.controller;

import com.novacomp.crud.entity.User;
import com.novacomp.crud.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/user")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping(value = "/user/{id}")
    public  ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        User user = userService.findById(id);
        return ResponseEntity.status(user != null?
                HttpStatus.OK:HttpStatus.NOT_FOUND).body(user);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Object> saveUser(@RequestBody User user ){
        if(user.getName()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Falta el nombre");
        }
        if(user.getId()!= null && userService.findById(user.getId()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario Existe");
        }

        return  ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(user));
    }

    @PutMapping(value = "/user")
    public ResponseEntity<Object>updateUser(@RequestBody  User user){
        User currentUser = userService.findById(user.getId());
        if(currentUser == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no existe");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
    }
}
