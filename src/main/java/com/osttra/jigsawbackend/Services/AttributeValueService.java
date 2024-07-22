package com.osttra.jigsawbackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.jigsawbackend.Models.Attribute;
import com.osttra.jigsawbackend.Models.AttributeValue;
import com.osttra.jigsawbackend.Repositories.AttributeValueRepo;
@Service
public class AttributeValueService {
    @Autowired
    AttributeValueRepo repo;

    public List<AttributeValue> getAttributeValues(Attribute a) {
        return repo.findByAttribute(a);
    }

    public void addAttributeValue(AttributeValue v) {
        repo.save(v);
    }

    public AttributeValue getAttributeValueByName(String param,Attribute a) {
        List<AttributeValue> at= getAttributeValues(a);
        return at.stream().filter(av-> av.getValue().equals(param)).findFirst().orElse(new AttributeValue());
    }

    public void updateAttributeValue(AttributeValue r) {
       repo.save(r);
    }

    public void deleteAttributeValue(int id) {
        repo.deleteById(id);
    }
}
