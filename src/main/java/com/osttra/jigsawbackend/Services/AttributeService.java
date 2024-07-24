// package com.osttra.jigsawbackend.Services;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.osttra.jigsawbackend.Models.Attribute;
// import com.osttra.jigsawbackend.Models.AttributeDTO;
// import com.osttra.jigsawbackend.Models.AttributeValue;
// import com.osttra.jigsawbackend.Models.AttributeValueDTO;
// import com.osttra.jigsawbackend.Models.Resource;
// import com.osttra.jigsawbackend.Repositories.AttributeRepo;
// import com.osttra.jigsawbackend.Repositories.PermissionRepo;
// import com.osttra.jigsawbackend.Repositories.ResourceRepo;
// @Service
// public class AttributeService {
//     @Autowired
//     AttributeRepo repo;
//     @Autowired
//     ResourceRepo resrepo;
//     @Autowired
//     PermissionRepo prepo;
//     public List<Attribute> getAttributes(int resID) {
//         return repo.findAll();
//     }

//     public void addAttribute(AttributeDTO atd) {
//         Attribute at= new Attribute();
//         at.setName(atd.getName());
//         Resource r= resrepo.findById(atd.getResId()).orElse(new Resource());
//         //Permission p= prepo.findById(atd.getPId()).orElse(new Permission());
//         //at.setPermission(p);
//         at.setResource(r);
//         List<AttributeValue> avs= new ArrayList<>();
//         for(AttributeValueDTO avDto : atd.getValues())
//         {
//             AttributeValue av = new AttributeValue();
//             av.setAttribute(repo.findById(avDto.getAtId()).orElse(new Attribute()));
//             av.setValue(avDto.getValue());
//             avs.add(av);
//         }
//         at.setValues(avs);
//         repo.save(at);
//     }

//     public Attribute getAttributeByResource(String param,Resource r) {
//         List<Attribute> at= getAttributes(r.getResID());
//         return at.stream().filter(av-> av.getName().equals(param)).findFirst().orElse(new Attribute());
//     }

//     public void updateAttribute(Attribute rt,int id) {
//        Attribute at = repo.findById(id).orElse(new Attribute());
//         at.setName(rt.getName());
//         at.setValues(rt.getValues());
//         at.setResource(rt.getResource());
//         repo.save(at);
//     }

//     public void deleteAttribute(int id) {
//         repo.deleteById(id);
//     }

//     public List<Attribute> getAllAttribute() {
//       return repo.findAll();
//     }

// }
