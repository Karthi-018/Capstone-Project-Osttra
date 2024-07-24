// package com.osttra.jigsawbackend.Models;

// import java.util.List;

// import org.springframework.stereotype.Component;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// @Component
// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class Attribute {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int atID;

//     private String name;

//     @OneToMany(mappedBy = "attribute",cascade=CascadeType.ALL)
//     private List<AttributeValue> values;

//     @ManyToOne(cascade=CascadeType.ALL)
//     @JoinColumn(name="resID")
//     private Resource resource;
// }
