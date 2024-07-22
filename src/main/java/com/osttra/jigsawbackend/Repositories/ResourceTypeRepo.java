package com.osttra.jigsawbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osttra.jigsawbackend.Models.ResourceType;
@Repository
public interface ResourceTypeRepo extends JpaRepository<ResourceType, Integer> {
    
}
