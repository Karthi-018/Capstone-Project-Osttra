package com.osttra.jigsawbackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.jigsawbackend.Models.ResourceType;
import com.osttra.jigsawbackend.Models.Role;
import com.osttra.jigsawbackend.Models.RoleDTO;
import com.osttra.jigsawbackend.Services.RoleService;
@RestController
public class RoleController {

    @Autowired
    RoleService roleServ;
    @GetMapping("/Roles")
    public List<RoleDTO> getAllRoles(){
        return roleServ.getAllRoles();
    }
    @PostMapping("/Roles")
    public String addRoles(@RequestBody RoleDTO dto)
    {
        roleServ.addRole(dto);
        return "succesfully added role";
    }
    @PostMapping("/Roles/{id}")
    public String updateRole(@RequestBody Role rt,@PathVariable int id) {   
        roleServ.updateRole(rt,id);
        return "successfully updated";
    }
    @DeleteMapping("/Roles/{id}")
    public void deleteRole(@PathVariable int id){
        roleServ.deleteRole(id);
    }
}
