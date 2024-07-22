package com.osttra.jigsawbackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.jigsawbackend.Models.Attribute;
import com.osttra.jigsawbackend.Models.AttributeDTO;
import com.osttra.jigsawbackend.Models.Resource;
import com.osttra.jigsawbackend.Services.AttributeService;

@RestController
public class AttributeController {
    @Autowired
    AttributeService service;

    @GetMapping("/Resources/Attribute/{param}")
    public List<Attribute> getAttributes(@PathVariable int param) {
        return service.getAttributes(param);
    }
    @PostMapping("/Resources/Attribute")
    public String addAttribute(@RequestBody AttributeDTO r) {
        service.addAttribute(r);
        return "Successfully Stored Resource";
    }
    @RequestMapping("/Resources/Attribute/{param}")
    public Attribute getAttributeByName(@PathVariable String param,@RequestBody Resource r) {
        return service.getAttributeByResource(param, r);
    }
    @PutMapping("/Resource/Attribute")
    public String updateAttribute(@RequestBody Attribute r) {   
        service.updateAttribute(r);
        return "successfully updated";
    }
    @DeleteMapping("/Resource/Attribute/{id}")
    public String deleteAttribute(@PathVariable int id){
        service.deleteAttribute(id);
        return "Deleted Succesfully";
    }
}
