package com.osttra.jigsawbackend.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.jigsawbackend.Models.Permission;
import com.osttra.jigsawbackend.Models.Resource;
import com.osttra.jigsawbackend.Models.Role;
import com.osttra.jigsawbackend.Models.RoleDTO;
import com.osttra.jigsawbackend.Models.User;
import com.osttra.jigsawbackend.Models.UserGroup;
import com.osttra.jigsawbackend.Repositories.PermissionRepo;
import com.osttra.jigsawbackend.Repositories.RoleRepo;
import com.osttra.jigsawbackend.Repositories.UserRepo;
@Service
public class RoleService {

    @Autowired
    RoleRepo roleRepo;
    @Autowired
    UserRepo uRepo;
    @Autowired
    PermissionRepo pRepo;
    public List<RoleDTO> getAllRoles(){
        List<RoleDTO> resultList=new ArrayList<>();
        List<Role> allRoles=roleRepo.findAll();
        
        for(Role currRole:allRoles){
            RoleDTO currRollDTO=new RoleDTO();
            currRollDTO.setName(currRole.getName());
            List<Integer> currPerms=currRole.getPermissions().stream().map(currPerm->currPerm.getPID()).toList();
            List<Integer> currUsers=currRole.getUser().stream().map(currUser->currUser.getUID()).toList();
            currRollDTO.setPermissions(currPerms);
            currRollDTO.setUser(currUsers);
            resultList.add(currRollDTO);
        }

        return resultList;

    }
    public void addRole(RoleDTO dto) {
        Role r= new Role();
        r.setName(dto.getName());
        List<Permission> permissions= new ArrayList<>();
        List<User> users= new ArrayList<>();
        for(int i : dto.getPermissions())
        {
            Permission g= pRepo.findById(i).orElse(new Permission());
            permissions.add(g);
        }
       for(int i : dto.getUser())
       {
        User g= uRepo.findById(i).orElse(new User());
        users.add(g);
       }
       r.setPermissions(permissions);
       r.setUser(users);
       roleRepo.save(r);
    }

    public void updateRole(Role r,int id) {
        Role rold = roleRepo.findById(id).orElse(new Role());
        rold.setName(r.getName());
        rold.setPermissions(r.getPermissions());
        rold.setUser(r.getUser());
        roleRepo.save(rold);
    }

    public void deleteRole(int id) {
        roleRepo.deleteById(id);
    }
}
