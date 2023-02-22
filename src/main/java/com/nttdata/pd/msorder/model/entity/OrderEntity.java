package com.nttdata.pd.msorder.model.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class OrderEntity {

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id;
    private Date createAt;
    private String shipTo;
    private String email;
    private List<ItemEntity> items;

}
