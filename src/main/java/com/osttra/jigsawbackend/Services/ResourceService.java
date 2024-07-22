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
    public List<Resource> getResource(int rt) {
        return repo.findByType(rt);
    }

    public void addResource(ResourceDataTF r) {
        Resource res= new Resource();
        res.setName(r.getName());
        ResourceType rt= rtrepo.findById(r.getRtID()).orElse(new ResourceType());
        res.setType(rt);
        repo.save(res);
    }

    public Resource getResourceByName(String param,ResourceType rt) {
        List<Resource> at= getResource(rt.getRtID());
        return at.stream().filter(av-> av.getName().equals(param)).findFirst().orElse(new Resource());
    }

    public void updateResource(Resource rt) {
       repo.save(rt);
    }

    public void deleteResource(int id) {
        repo.deleteById(id);
    }

}
