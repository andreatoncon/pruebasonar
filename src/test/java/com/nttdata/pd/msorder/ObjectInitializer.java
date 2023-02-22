package com.nttdata.pd.msorder;

import com.nttdata.pd.msorder.model.Item;
import com.nttdata.pd.msorder.model.Order;
import com.nttdata.pd.msorder.model.entity.ItemEntity;
import com.nttdata.pd.msorder.model.entity.OrderEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ObjectInitializer {

    public Order createOrder() {
        Order order = new Order();

        order.setId("3e217903-d50e-43a2-9826-33f524e5b188");
        order.setShipTo("shipto@emeail.com");
        order.setEmail("owner@email.com");
        order.setCreateAt(new Date());
        order.setItems(createItems());

        return order;
    }

    public List<Item> createItems() {
        return List.of(new Item(1, 1, 1.50));
    }

    public OrderEntity createOrderEntity() {
        OrderEntity order = new OrderEntity();

        order.setId(UUID.fromString("3e217903-d50e-43a2-9826-33f524e5b188"));
        order.setShipTo("shipto@emeail.com");
        order.setEmail("owner@email.com");
        order.setCreateAt(new Date());
        order.setItems(createItemsEntity());

        return order;
    }

    public List<ItemEntity> createItemsEntity() {
        return List.of(new ItemEntity(1, 1, 1.50));
    }

}
