package com.osttra.jigsawbackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.jigsawbackend.Models.User;
import com.osttra.jigsawbackend.Repositories.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo rp;
    public List<User> getUsers(){
        return rp.findAll();
    }
    
    public User getUserbyId(int uid)
    {
        return rp.findById(uid).orElse(new User());
    }

    public void updateUser(User u)
    {
        rp.save(u);
    }
}
