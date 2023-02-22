package com.nttdata.pd.msorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(content = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private Date createAt;
    private String shipTo;
    private String email;
    private List<Item> items;

}
