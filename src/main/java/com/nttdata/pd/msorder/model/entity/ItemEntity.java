package com.nttdata.pd.msorder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@UserDefinedType
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    private Integer id;
    private Integer quantity;
    private Double price;

}
