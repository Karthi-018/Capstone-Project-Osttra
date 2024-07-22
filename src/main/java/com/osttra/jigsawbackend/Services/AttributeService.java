package com.osttra.jigsawbackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.jigsawbackend.Models.Attribute;
import com.osttra.jigsawbackend.Models.AttributeDTO;
import com.osttra.jigsawbackend.Models.Permission;
import com.osttra.jigsawbackend.Models.Resource;
import com.osttra.jigsawbackend.Repositories.AttributeRepo;
import com.osttra.jigsawbackend.Repositories.PermissionRepo;
import com.osttra.jigsawbackend.Repositories.ResourceRepo;
@Service
public class AttributeService {
    @Autowired
    AttributeRepo repo;
    @Autowired
    ResourceRepo resrepo;
    @Autowired
    PermissionRepo prepo;
    public List<Attribute> getAttributes(int resID) {
        return repo.findByResource(resID);
    }

    public void addAttribute(AttributeDTO atd) {
        Attribute at= new Attribute();
        at.setName(atd.getName());
        Resource r= resrepo.findById(atd.getResId()).orElse(new Resource());
        Permission p= prepo.findById(atd.getPId()).orElse(new Permission());
        at.setPermission(p);
        at.setResource(r);
        repo.save(at);
    }

    public Attribute getAttributeByResource(String param,Resource r) {
        List<Attribute> at= getAttributes(r.getResID());
        return at.stream().filter(av-> av.getName().equals(param)).findFirst().orElse(new Attribute());
    }
    public Attribute getAttributeByPermission(String param,Permission p) {
        List<Attribute> at= repo.findByPermission(p.getPID());
        return at.stream().filter(av-> av.getName().equals(param)).findFirst().orElse(new Attribute());
    }

    public void updateAttribute(Attribute rt) {
       repo.save(rt);
    }

    public void deleteAttribute(int id) {
        repo.deleteById(id);
    }

}
