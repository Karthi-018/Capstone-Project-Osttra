// package com.osttra.jigsawbackend.Services;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.osttra.jigsawbackend.Models.Attribute;
// import com.osttra.jigsawbackend.Models.AttributeValue;
// import com.osttra.jigsawbackend.Models.AttributeValueDTO;
// import com.osttra.jigsawbackend.Models.ResourceType;
// import com.osttra.jigsawbackend.Repositories.AttributeRepo;
// import com.osttra.jigsawbackend.Repositories.AttributeValueRepo;
// @Service
// public class AttributeValueService {
//     @Autowired
//     AttributeValueRepo repo;
//     @Autowired
//     AttributeRepo aRepo;
//     public List<AttributeValue> getAttributeValues() {
//         return repo.findAll();
//     }

//     public void addAttributeValue(AttributeValueDTO avDTO) {
//         AttributeValue av= new AttributeValue();
//         Attribute att= aRepo.findById(avDTO.getAtId()).orElse(new Attribute());
//         av.setValue(avDTO.getValue());
//         av.setAttribute(att);
//         repo.save(av);
//     }

//     public AttributeValue getAttributeValueByName(String param,Attribute a) {
//         List<AttributeValue> at= getAttributeValues();
//         return at.stream().filter(av-> av.getValue().equals(param)).findFirst().orElse(new AttributeValue());
//     }

//     public void updateAttributeValue(AttributeValue r,int id) {
//        AttributeValue atv = repo.findById(id).orElse(new AttributeValue());
//         atv.setValue(r.getValue());
//         atv.setAttribute(r.getAttribute());
//         repo.save(atv);
//     }

//     public void deleteAttributeValue(int id) {
//         repo.deleteById(id);
//     }
// }
