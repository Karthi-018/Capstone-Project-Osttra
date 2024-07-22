package com.osttra.jigsawbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osttra.jigsawbackend.Models.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission,Integer> {

}
