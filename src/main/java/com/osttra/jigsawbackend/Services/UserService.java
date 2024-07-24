package com.osttra.jigsawbackend.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import com.osttra.jigsawbackend.Models.Permission;
import com.osttra.jigsawbackend.Models.Role;
import com.osttra.jigsawbackend.Models.User;
import com.osttra.jigsawbackend.Models.UserDTO;
import com.osttra.jigsawbackend.Models.UserGroup;
import com.osttra.jigsawbackend.Repositories.PermissionRepo;
import com.osttra.jigsawbackend.Repositories.RoleRepo;
import com.osttra.jigsawbackend.Repositories.UserGroupRepo;
import com.osttra.jigsawbackend.Repositories.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    @Autowired
    UserGroupRepo ugRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    PermissionRepo permRepo;
    public List<UserDTO> getUsers(){
        List<User> us= repo.findAll();
        List<UserDTO> usDTO= new ArrayList<>();
        for(User u : us){
            UserDTO uDTO= new UserDTO();
            uDTO.setName(u.getName());
            uDTO.setClientID(u.getClientID());
            uDTO.setEmail(u.getEmail());
            uDTO.setGroupsId(u.getGroups().stream().map(grp->grp.getUgID()).toList());
            uDTO.setRoleId(u.getRoles().stream().map(rl->rl.getRID()).toList());
            uDTO.setPermissionId(u.getPermissions().stream().map(perm->perm.getPID()).toList());
            uDTO.setUserType(u.getUserType());
            usDTO.add(uDTO);
        }
        return usDTO;
    }
    
    public User getUserbyId(int uid)
    {
        return repo.findById(uid).orElse(new User());
    }

    public void updateUser(User u,int id)
    {
        User oldU=repo.findById(id).orElse(new User());
        oldU.setEmail(u.getEmail());
        oldU.setUserType(u.getUserType());
        oldU.setGroups(u.getGroups());
        oldU.setName(u.getName());
        oldU.setPermissions(u.getPermissions());
        oldU.setRoles(u.getRoles());
        oldU.setClientID(u.getClientID());
        repo.save(u);
    }

    public void addUser(UserDTO user) {
       User u= new User();
       u.setName(user.getName());
       u.setClientID(user.getClientID());
       u.setEmail(user.getEmail());
       u.setUserType(user.getUserType());
       List<Role> roles= new ArrayList<>();
       List<Permission> permissions= new ArrayList<>();
       List<UserGroup> groups= new ArrayList<>();
       for(int i : user.getGroupsId())
       {
        UserGroup g= ugRepo.findById(i).orElse(new UserGroup());
        groups.add(g);
       }
       for(int i : user.getRoleId())
       {
        Role g= roleRepo.findById(i).orElse(new Role());
        roles.add(g);
       }
       for(int i : user.getPermissionId())
       {
        Permission g= permRepo.findById(i).orElse(new Permission());
        permissions.add(g);
       }
       u.setRoles(roles);
       u.setGroups(groups);
       u.setPermissions(permissions);
       repo.save(u);
       for(Permission i :permissions)
        {
            List<User> users= i.getUser();
            users.add(u);
            i.setUser(users);
            permRepo.save(i);
        }
       for(Role i :roles)
        {
            List<User> users= i.getUser();
            users.add(u);
            i.setUser(users);
            roleRepo.save(i);
        }
       for(UserGroup i :groups)
        {
            List<User> users= i.getUsers();
            users.add(u);
            i.setUsers(users);
            ugRepo.save(i);
        }
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }
}
