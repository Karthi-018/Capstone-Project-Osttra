package com.osttra.jigsawbackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.jigsawbackend.Models.ResourceType;
import com.osttra.jigsawbackend.Repositories.ResourceTypeRepo;
@Service
public class ResourceTypeService {
    @Autowired
    ResourceTypeRepo repo;

    public List<ResourceType> getRT() {
      return  repo.findAll();
    }

    public void updateResourceType(ResourceType rt) {
        repo.save(rt);
    }

    public ResourceType getResourceTypeByID(int id) {
        return repo.findById(id).orElse(new ResourceType());
    }

    public void addResourceType(ResourceType rt) {
        repo.save(rt);
    }

    public void deleteRT(int id) {
        repo.deleteById(id);
    }

}
