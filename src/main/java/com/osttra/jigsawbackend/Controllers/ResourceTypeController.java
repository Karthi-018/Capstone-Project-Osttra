package com.osttra.jigsawbackend.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.osttra.jigsawbackend.Models.ResourceType;
import com.osttra.jigsawbackend.Services.ResourceTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class ResourceTypeController {
    @Autowired
    ResourceTypeService service;
    @GetMapping("/ResourceType")
    public List<ResourceType> getRT() {
        return service.getRT();
    }
    @PostMapping("/ResourceType")
    public String addResourceType(@RequestBody ResourceType rt) {
        service.addResourceType(rt);
        return "Successfully Stored ResourceType";
    }
    @RequestMapping("/ResourceType/{param}")
    public ResourceType getResourceTypeByID(@PathVariable int param) {
        return service.getResourceTypeByID(param);
    }
    @PostMapping("/ResourceType/{id}")
    public String updateResourceType(@RequestBody ResourceType rt,@PathVariable int id) {   
        service.updateResourceType(rt,id);
        return "successfully updated";
    }
    @DeleteMapping("/ResourceType/{id}")
    public void deleteResourceType(@PathVariable int id){
        service.deleteRT(id);
    }
}
