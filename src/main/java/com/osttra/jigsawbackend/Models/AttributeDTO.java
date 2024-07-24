package com.osttra.jigsawbackend.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeDTO {
    private String name;
    private int resId;
    private List<AttributeValueDTO> values;
}