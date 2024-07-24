package com.osttra.jigsawbackend.Models;
import java.util.List;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedAttributeDTO {
   
    private int satID;

    private String name;

    private List<SelectedAttributeValueDTO> values;
  
}

