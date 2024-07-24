package com.osttra.jigsawbackend.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.jigsawbackend.Models.Permission;
import com.osttra.jigsawbackend.Models.PermissionDTO;
import com.osttra.jigsawbackend.Models.SelectedAttribute;
import com.osttra.jigsawbackend.Models.SelectedAttributeDTO;
import com.osttra.jigsawbackend.Models.SelectedAttributeValue;
import com.osttra.jigsawbackend.Models.SelectedAttributeValueDTO;
import com.osttra.jigsawbackend.Services.PermissionService;

@RestController
public class PermissionController {
    @Autowired
    PermissionService service;

    @PostMapping("/Permission")
    public String addPermission(@RequestBody PermissionDTO pDto) {
        service.addPermission(pDto);
        return "Succefully added Perm";
    }
    @GetMapping("/Permission")
    public List<PermissionDTO> getPermissions()
    {
        List<Permission> li=service.getPermissions();
        List<PermissionDTO> pDTO = new ArrayList<>();
        for(Permission p :li){
            List<List<SelectedAttributeValueDTO>> satv= new ArrayList<>();
            PermissionDTO pDt= new PermissionDTO();
            List<SelectedAttribute> sat=p.getData();
            List<SelectedAttributeDTO> satDTO= new ArrayList<>();
            pDt.setResourceID(p.getResource().getResID());
            pDt.setRole(p.getRole());
            pDt.setUser(p.getUser());
            pDt.setAllowed_perm(p.getAllowed_perm());
            for(SelectedAttribute at: sat)
            {
                SelectedAttributeDTO dt= new SelectedAttributeDTO();
                List<SelectedAttributeValueDTO> listOfVal= new ArrayList<>();
                dt.setName(at.getName());
                dt.setSatID(at.getSatID());
                for(SelectedAttributeValue i : at.getValues() )
                {
                    SelectedAttributeValueDTO svdto= new SelectedAttributeValueDTO();
                    svdto.setId(i.getId());
                    svdto.setSatID(at.getSatID());
                    svdto.setValue(i.getValue());
                    listOfVal.add(svdto);
                }
                satv.add(listOfVal);
                dt.setValues(listOfVal);
                satDTO.add(dt);
            }
            pDt.setSattributeDisplay(satDTO);
            pDt.setSatvalueDisplay(satv);
            pDTO.add(pDt);
        }
        return pDTO;
    }


    @PostMapping("/Permission/{id}")
    public String updateAttribute(@RequestBody Permission r,@PathVariable int id) {   
        service.updatePermission(r, id);
        return "successfully updated";
    }
    @DeleteMapping("/Permission/{id}")
    public String deleteResource(@PathVariable int id){
        service.deletePermission(id);
        return "Deleted Succesfully";
    }
}