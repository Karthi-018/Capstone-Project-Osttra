package com.osttra.jigsawbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.osttra.jigsawbackend.Models.UserGroup;

@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup,Integer> {

}
