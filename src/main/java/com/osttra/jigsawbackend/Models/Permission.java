package com.osttra.jigsawbackend.Models;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
    @ManyToOne
    @JoinColumn(name = "resID")
    Resource resource;
    @ElementCollection
    @CollectionTable(name = "allowed_permissions", joinColumns = @JoinColumn(name = "pID"))
    @Column(name = "allowed_permission")
    private List<String> allowed_perm;
    @OneToMany(cascade=CascadeType.ALL)
    private List<SelectedAttribute> data;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "uID")
    List<User> user;
    @ManyToMany(mappedBy="permissions",cascade=CascadeType.ALL)
    List<Role> role;
}
