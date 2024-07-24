// package com.osttra.jigsawbackend.Models;

// import org.springframework.stereotype.Component;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// @Component
// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class AttributeValue {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;

//     private String value;

//     @ManyToOne(cascade=CascadeType.ALL)
//     @JoinColumn(name = "atID")
//     private Attribute attribute;
// }
