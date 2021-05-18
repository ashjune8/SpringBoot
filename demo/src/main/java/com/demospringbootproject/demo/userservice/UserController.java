package com.demospringbootproject.demo.userservice;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/getUsers")
    public ArrayList<UserBean> getAllUsers(){

        return this.userService.getAllUsers();


    }

    @GetMapping("/getUser/{id}")
    public UserBean findUser(@PathVariable Integer id) throws Exception{

        UserBean user = this.userService.getUser(id);

        if(user == null){
            
            throw new UserException("not found in database, id=" + id);
        }

        return user;
    }


    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody UserBean user){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
        
    }
    
}
