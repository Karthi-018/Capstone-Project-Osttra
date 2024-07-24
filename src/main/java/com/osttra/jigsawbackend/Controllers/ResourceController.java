package com.osttra.jigsawbackend.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.jigsawbackend.Models.Resource;
import com.osttra.jigsawbackend.Models.ResourceDataTF;
import com.osttra.jigsawbackend.Services.ResourceService;
import com.osttra.jigsawbackend.Services.ResourceTypeService;


@RestController
public class ResourceController {
    @Autowired
    ResourceService service;
    @Autowired
    ResourceTypeService rtServ;
    @GetMapping("/Resources/{param}")
    public List<ResourceDataTF> getResource(@PathVariable int param) {
        List<Resource> rs=service.getResource(param);
        List<ResourceDataTF> rtd= new ArrayList<>();
        for(Resource r : rs)
        {
            List<List<String>> atValues=new ArrayList<>();
            ResourceDataTF tf= new ResourceDataTF();
            tf.setResID(r.getResID());
            tf.setName(r.getName());
            tf.setRtID(r.getType().getRtID());
            //tf.setAtsDisplay(r.getData().stream().map(n->n.getName()).toList());
            //r.getData().forEach(at->atValues.add(at.getValues().stream().map(v->v.getValue()).toList()));
            //tf.setAtvaluesDisplay(atValues);
            rtd.add(tf);
        }
        return rtd;
    }
    @PostMapping("/Resources")
    public String addResource(@RequestBody ResourceDataTF r) {
        service.addResource(r);
        return "Successfully Stored Resource";
    }
    @PutMapping("/Resource/{id}")
    public String updateResourceType(@RequestBody Resource r,@PathVariable int id) {   
        service.updateResource(r,id);
        return "successfully updated";
    }
    @DeleteMapping("/Resource/{id}")
    public String deleteResource(@PathVariable int id){
        service.deleteResource(id);
        return "Deleted Succesfully";
    }
    
}
