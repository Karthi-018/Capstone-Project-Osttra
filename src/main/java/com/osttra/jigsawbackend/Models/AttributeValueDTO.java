package com.osttra.jigsawbackend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeValueDTO {
    private int id;
    private String value;
    private int atId; 
}
