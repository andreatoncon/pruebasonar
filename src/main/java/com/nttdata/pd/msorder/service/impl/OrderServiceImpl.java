package com.nttdata.pd.msorder.service.impl;

import com.nttdata.pd.msorder.model.Item;
import com.nttdata.pd.msorder.model.Order;
import com.nttdata.pd.msorder.model.entity.ItemEntity;
import com.nttdata.pd.msorder.model.entity.OrderEntity;
import com.nttdata.pd.msorder.repository.OrderRepository;
import com.nttdata.pd.msorder.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order orderRequest) {
        OrderEntity orderCreated = orderRepository.save(toEntity(orderRequest));
        return toOrder(orderCreated);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll().stream().map(this::toOrder).toList();
    }

    @Override
    public List<Order> getOrdersByEmail(String email) {
        return orderRepository.findAllByEmail(email).stream().map(this::toOrder).toList();
    }

    private OrderEntity toEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(order, orderEntity);
        orderEntity.setId(UUID.randomUUID());
        orderEntity.setItems(toItemEntityList(order.getItems()));
        return orderEntity;
    }

    private List<ItemEntity> toItemEntityList(List<Item> items) {
        return items.stream().map(this::toItemEntity).toList();
    }

    private ItemEntity toItemEntity(Item item) {
        ItemEntity itemEntity = new ItemEntity();

        BeanUtils.copyProperties(item, itemEntity);

        return itemEntity;
    }

    private Order toOrder(OrderEntity orderEntity) {
        Order order = new Order();
        BeanUtils.copyProperties(orderEntity, order);
        order.setId(orderEntity.getId().toString());
        order.setItems(toItems(orderEntity.getItems()));
        return order;
    }

    private List<Item> toItems(List<ItemEntity> itemEntityList) {
        return itemEntityList.stream().map(this::toItem).toList();
    }

    private Item toItem(ItemEntity itemEntity) {
        Item item = new Item();

        BeanUtils.copyProperties(itemEntity, item);

        return item;
    }

}
