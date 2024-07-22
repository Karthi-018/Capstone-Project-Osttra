package com.osttra.jigsawbackend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeDTO {
    private String name;
    private int pId;
    private int resId;
}
