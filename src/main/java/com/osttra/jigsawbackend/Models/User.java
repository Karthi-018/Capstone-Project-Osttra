package com.osttra.jigsawbackend.Models;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name="JigsawUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int uID;
    String name;
    long clientID;
    String email;
    String userType;
    @ManyToMany(mappedBy = "user")
    List<Role> roles;
    @ManyToMany(mappedBy="users")
    List<UserGroup> groups;
    @ManyToMany(mappedBy = "user")
    List<Permission> permissions;
}
