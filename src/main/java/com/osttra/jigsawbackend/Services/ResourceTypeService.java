package com.osttra.jigsawbackend.Services;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.jigsawbackend.Models.ResourceType;
import com.osttra.jigsawbackend.Repositories.ResourceTypeRepo;

import jakarta.persistence.CascadeType;
import jakarta.transaction.Transactional;
@Service
public class ResourceTypeService {
    @Autowired
    ResourceTypeRepo repo;

    public List<ResourceType> getRT() {
      return  repo.findAll();
    }
    @Transactional
    public void updateResourceType(ResourceType rt,int id) {
        ResourceType existingResourceType = repo.findById(id).orElse(new ResourceType());
        existingResourceType.setName(rt.getName());
        existingResourceType.setAvl_permissions(rt.getAvl_permissions());
        repo.save(existingResourceType);
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
