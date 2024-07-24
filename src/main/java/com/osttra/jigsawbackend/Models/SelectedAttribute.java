package com.osttra.jigsawbackend.Models;

import java.util.List;

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
public class SelectedAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int satID;

    private String name;

    @OneToMany(mappedBy = "sattribute")
    private List<SelectedAttributeValue> values;
  
}
