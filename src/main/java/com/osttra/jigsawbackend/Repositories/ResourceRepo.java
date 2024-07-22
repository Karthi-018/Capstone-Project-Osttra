package com.osttra.jigsawbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.osttra.jigsawbackend.Models.Resource;

import java.util.List;


@Repository
public interface ResourceRepo extends JpaRepository<Resource, Integer> {
   // List<Resource> findByType(ResourceType type);
    @Query("SELECT r FROM Resource r WHERE r.type.rtID = :rtID")
    List<Resource> findByType(int rtID);
}
