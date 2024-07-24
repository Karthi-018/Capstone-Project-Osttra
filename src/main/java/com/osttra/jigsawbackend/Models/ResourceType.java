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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class ResourceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rtID;
    String name;
    Boolean permCond;
    @ElementCollection
    @CollectionTable(name = "available_permissions", joinColumns = @JoinColumn(name = "rtID"))
    @Column(name = "available_permission")
    List<String> avl_permissions;
    @OneToMany(cascade=CascadeType.ALL)
    List<Resource> res;
}
