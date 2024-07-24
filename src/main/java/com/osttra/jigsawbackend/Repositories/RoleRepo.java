package com.osttra.jigsawbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osttra.jigsawbackend.Models.Role;
import com.osttra.jigsawbackend.Models.User;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {

}
