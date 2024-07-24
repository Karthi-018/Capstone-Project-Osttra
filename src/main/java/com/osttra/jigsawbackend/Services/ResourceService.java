package com.osttra.jigsawbackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.jigsawbackend.Models.Resource;
import com.osttra.jigsawbackend.Models.ResourceDataTF;
import com.osttra.jigsawbackend.Models.ResourceType;
import com.osttra.jigsawbackend.Repositories.ResourceRepo;
import com.osttra.jigsawbackend.Repositories.ResourceTypeRepo;
@Service
public class ResourceService {
    @Autowired
    ResourceRepo repo;
    @Autowired
    ResourceTypeRepo rtrepo;
    // @Autowired
    // AttributeRepo atrepo;
    // @Autowired
    // AttributeValueRepo atvrepo;

    public List<Resource> getResource(int rt) {
        return repo.findByType(rt);
    }

    public void addResource(ResourceDataTF r) {
        Resource res= new Resource();
        res.setName(r.getName());
        ResourceType rt= rtrepo.findById(r.getRtID()).orElse(new ResourceType());
        res.setType(rt);
        repo.save(res);
        // List<Attribute> li= r.getAts();
        // List<List<AttributeValue>> stv=r.getAtvalues();
        // for(int i=0;i<li.size();i++)
        // {
        //     Attribute x=li.get(i);
        //     atrepo.save(x);
        //     List<AttributeValue> list= new ArrayList<>();
        //     for(AttributeValue a: stv.get(i))
        //     {
        //         a.setAttribute(x);
        //         list.add(a);
        //         atvrepo.save(a);
        //     }
        //     // x.setResource(res);
        //     x.setValues(list);
        //     atrepo.save(x);
        // }
        // res.setData(li);
        // repo.save(res);
        // for(int i=0;i<li.size();i++)
        // {
        //     Attribute x=li.get(i);
        //     x.setResource(res);
        //     atrepo.save(x);
        // }

    }

    public Resource getResourceByName(String param,ResourceType rt) {
        List<Resource> at= getResource(rt.getRtID());
        return at.stream().filter(av-> av.getName().equals(param)).findFirst().orElse(new Resource());
    }

    public void updateResource(Resource r,int id) {
        Resource rold = repo.findById(id).orElse(new Resource());
        repo.findById(id);
        //rold.setData(r.getData());
        rold.setName(r.getName());
        rold.setType(r.getType());
        repo.save(rold);
    }

    public void deleteResource(int id) {
        repo.deleteById(id);
    }

    public Resource findById(int id) {
       return repo.findById(id).orElse(new Resource());
    }

}
