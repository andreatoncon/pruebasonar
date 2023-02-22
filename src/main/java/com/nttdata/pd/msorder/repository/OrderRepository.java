package com.nttdata.pd.msorder.repository;

import com.nttdata.pd.msorder.model.entity.OrderEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends CassandraRepository<OrderEntity, UUID> {

    List<OrderEntity> findAllByEmail(String email);

}
