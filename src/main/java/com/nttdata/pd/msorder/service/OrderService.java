package com.nttdata.pd.msorder.service;

import com.nttdata.pd.msorder.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order orderRequest);
    List<Order> getAllOrders();
    List<Order> getOrdersByEmail(String email);

}
