package com.osttra.jigsawbackend.Models;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pID;
    String resource_type;
    String resource;
    @ElementCollection
    @CollectionTable(name = "allowed_permissions", joinColumns = @JoinColumn(name = "pID"))
    @Column(name = "allowed_permission")
    private List<String> allowed_perm;
    @OneToMany(mappedBy = "permission")
    private List<Attribute> data;
    @ManyToOne
    @JoinColumn(name = "uID")
    User user;
    @ManyToOne
    @JoinColumn(name = "rID")
    Role role;
}
