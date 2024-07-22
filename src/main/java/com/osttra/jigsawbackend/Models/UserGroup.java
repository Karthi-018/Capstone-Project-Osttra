package com.osttra.jigsawbackend.Models;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ugID;
    String name;
    @ManyToMany
    List<User> users;
}
