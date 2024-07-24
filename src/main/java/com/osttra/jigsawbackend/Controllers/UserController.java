package com.osttra.jigsawbackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.jigsawbackend.Models.ResourceType;
import com.osttra.jigsawbackend.Models.User;
import com.osttra.jigsawbackend.Models.UserDTO;
import com.osttra.jigsawbackend.Services.ResourceTypeService;
import com.osttra.jigsawbackend.Services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    ResourceTypeService rtServ;

    @GetMapping("/User")
    public List<UserDTO> getUsers() {
        return service.getUsers();
    }
    @PostMapping("/User")
    public String postUser(@RequestBody UserDTO User) {
        service.addUser(User);
        return "Succesfully added user";
    }
    @PostMapping("/User/{id}")
    public String updateUser(@RequestBody User u,@PathVariable int id) {   
        service.updateUser(u,id);
        return "successfully updated";
    }
    @DeleteMapping("/User/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }
    
}