package com.osttra.jigsawbackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.jigsawbackend.Models.Resource;
import com.osttra.jigsawbackend.Services.ResourceService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.osttra.jigsawbackend.Models.ResourceDataTF;
import com.osttra.jigsawbackend.Models.ResourceType;


@RestController
public class ResourceController {
    @Autowired
    ResourceService service;
    
    @GetMapping("/Resources/{param}")
    public List<Resource> getResource(@PathVariable int param) {
        return service.getResource(param);
    }
    @PostMapping("/Resources")
    public String addResource(@RequestBody ResourceDataTF r) {
        service.addResource(r);
        return "Successfully Stored Resource";
    }
    @RequestMapping("/Resources/{param}")
    public Resource getResourceTypeByName(@PathVariable String param,@RequestBody ResourceType rt) {
        return service.getResourceByName(param,rt);
    }
    @PutMapping("/Resource/{id}")
    public String updateResourceType(@RequestBody Resource r) {   
        service.updateResource(r);
        return "successfully updated";
    }
    @DeleteMapping("/Resource/{id}")
    public String deleteResource(@PathVariable int id){
        service.deleteResource(id);
        return "Deleted Succesfully";
    }
    
}
