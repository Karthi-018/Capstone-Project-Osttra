package com.osttra.jigsawbackend.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.jigsawbackend.Models.Permission;
import com.osttra.jigsawbackend.Models.PermissionDTO;
import com.osttra.jigsawbackend.Models.Resource;
import com.osttra.jigsawbackend.Models.SelectedAttribute;
import com.osttra.jigsawbackend.Models.SelectedAttributeValue;
import com.osttra.jigsawbackend.Repositories.PermissionRepo;
import com.osttra.jigsawbackend.Repositories.ResourceRepo;
import com.osttra.jigsawbackend.Repositories.SelectedAttributeRepo;
import com.osttra.jigsawbackend.Repositories.SelectedAttributeValueRepo;

@Service
public class PermissionService {
    @Autowired
    PermissionRepo repo;
    @Autowired
    SelectedAttributeRepo satRepo;
    @Autowired
    ResourceRepo resrepo;
    @Autowired
    SelectedAttributeValueRepo savRepo;
    public void addPermission(PermissionDTO pDto) {
        Permission p= new Permission();
        Resource resource= resrepo.findById(pDto.getResourceID()).orElse(new Resource());
        p.setResource(resource);
        p.setAllowed_perm(pDto.getAllowed_perm());
        repo.save(p);
        List<SelectedAttribute> li= pDto.getSattribute();
        List<List<SelectedAttributeValue>> stv=pDto.getSatvalues();
        for(int i=0;i<li.size();i++)
        {
            SelectedAttribute x=li.get(i);
            satRepo.save(x);
            List<SelectedAttributeValue> list= new ArrayList<>();
            for(SelectedAttributeValue a: stv.get(i))
            {
                a.setSattribute(x);
                list.add(a);
                savRepo.save(a);
            }
            x.setValues(list);
            satRepo.save(x);
        }
        p.setData(li);
        repo.save(p);
    }
    public List<Permission> getPermissions() {
        return repo.findAll();
    }

    public void updatePermission(Permission r,int id) {
       Permission perm = repo.findById(id).orElse(new Permission());
        perm.setAllowed_perm(r.getAllowed_perm());
        perm.setData(r.getData());
        perm.setRole(r.getRole());
        perm.setUser(perm.getUser());
        perm.setResource(r.getResource());
        repo.save(perm);
    }
    
    public void deletePermission(int id){
        repo.deleteById(id);
    }
    
}
