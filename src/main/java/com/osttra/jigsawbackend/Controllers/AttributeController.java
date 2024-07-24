// package com.osttra.jigsawbackend.Controllers;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.osttra.jigsawbackend.Models.Attribute;
// import com.osttra.jigsawbackend.Models.AttributeDTO;
// import com.osttra.jigsawbackend.Models.AttributeValue;
// import com.osttra.jigsawbackend.Models.AttributeValueDTO;
// import com.osttra.jigsawbackend.Models.Resource;
// import com.osttra.jigsawbackend.Services.AttributeService;

// @RestController
// public class AttributeController {
//     @Autowired
//     AttributeService service;

//     @GetMapping("/Resources/Attribute")
//     public List<AttributeDTO> getAttributes() {
//         List<Attribute> rs=service.getAllAttribute();
//         List<AttributeDTO> rtd= new ArrayList<>();
//         for(Attribute r : rs)
//         {
//             List<AttributeValueDTO> avList = new ArrayList<>();
//             AttributeDTO atd= new AttributeDTO();
//             atd.setName(r.getName());
//             atd.setResId(r.getResource().getResID());
            
//             for(AttributeValue av: r.getValues())
//             {   
//                 AttributeValueDTO avDTO= new AttributeValueDTO();
//                 avDTO.setAtId(av.getAttribute().getAtID());
//                 avDTO.setValue(av.getValue());
//                 avList.add(avDTO);
//             }
//             atd.setValues(avList);
//             rtd.add(atd);
//         }
//         return rtd;
    
//     }
//     @PostMapping("/Resources/Attribute")
//     public String addAttribute(@RequestBody AttributeDTO r) {
//         service.addAttribute(r);
//         return "Successfully Stored Attribute";
//     }
//     @RequestMapping("/Resources/Attribute/{param}")
//     public Attribute getAttributeByName(@PathVariable String param,@RequestBody Resource r) {
//         return service.getAttributeByResource(param, r);
//     }
//     @PostMapping("/Resource/Attribute/{id}")
//     public String updateAttribute(@RequestBody Attribute r,@PathVariable int id) {   
//         service.updateAttribute(r,id);
//         return "successfully updated";
//     }
//     @DeleteMapping("/Resource/Attribute/{id}")
//     public String deleteAttribute(@PathVariable int id){
//         service.deleteAttribute(id);
//         return "Deleted Succesfully";
//     }
// }
