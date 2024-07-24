package com.osttra.jigsawbackend.Models;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO {
    int uID;
    String name;
    long clientID;
    String email;
    String userType;
    List<Integer> roleId;
    List<Integer> groupsId;
    List<Integer> permissionId;
}
