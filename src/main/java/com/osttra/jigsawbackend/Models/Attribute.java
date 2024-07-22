package com.osttra.jigsawbackend.Models;

import java.util.Set;

import org.springframework.stereotype.Component;

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
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int atID;

    private String name;

    @OneToMany(mappedBy = "attribute")
    private Set<AttributeValue> values;
    @ManyToOne
    @JoinColumn(name = "pID")
    private Permission permission;
    @ManyToOne
    @JoinColumn(name = "resID")
    private Resource resource;
}
