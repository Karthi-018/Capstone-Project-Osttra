package com.osttra.jigsawbackend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osttra.jigsawbackend.Models.Attribute;
import com.osttra.jigsawbackend.Models.AttributeValue;

@Repository
public interface AttributeValueRepo extends JpaRepository<AttributeValue, Integer> {
    List<AttributeValue> findByAttribute(Attribute attribute);
    
}
