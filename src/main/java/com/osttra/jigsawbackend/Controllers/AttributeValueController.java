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
import com.osttra.jigsawbackend.Models.AttributeValue;
import com.osttra.jigsawbackend.Services.AttributeValueService;

@RestController
public class AttributeValueController {
    @Autowired
    AttributeValueService service;

    @GetMapping("/Resources/Attribute/Value")
    public List<AttributeValue> findAttributeValues(@RequestBody Attribute a) {
        return service.getAttributeValues(a);
    }
    @PostMapping("/Resources/Attribute/Value")
    public String addAttributevalue(@RequestBody AttributeValue r) {
        service.addAttributeValue(r);
        return "Successfully Stored Attributevalue";
    }
    @RequestMapping("/Resources/Attribute/Value/{param}")
    public AttributeValue getAttributeTypeByName(@PathVariable String param,@RequestBody Attribute a) {
        return service.getAttributeValueByName(param,a);
    }
    @PutMapping("/Resource/Attribute/Value/{id}")
    public String updateAttribute(@RequestBody AttributeValue r) {   
        service.updateAttributeValue(r);
        return "successfully updated";
    }
    @DeleteMapping("/Resource/Attribute/Value/{id}")
    public String deleteResource(@PathVariable int id){
        service.deleteAttributeValue(id);
        return "Deleted Succesfully";
    }

}
