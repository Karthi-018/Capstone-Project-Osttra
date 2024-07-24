package com.osttra.jigsawbackend.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO {
    private int resourceID;
    private List<String> allowed_perm;
    private List<SelectedAttribute> sattribute;
    private List<SelectedAttributeDTO> sattributeDisplay;
    private List<List<SelectedAttributeValue>> satvalues;
    private List<List<SelectedAttributeValueDTO>> satvalueDisplay;
    private List<User> user;
    private List<Role> role;
}
