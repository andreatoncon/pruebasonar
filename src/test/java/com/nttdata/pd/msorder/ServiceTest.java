package com.nttdata.pd.msorder;

import com.nttdata.pd.msorder.model.Order;
import com.nttdata.pd.msorder.model.entity.OrderEntity;
import com.nttdata.pd.msorder.repository.OrderRepository;
import com.nttdata.pd.msorder.service.impl.OrderServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ServiceTest {

    @InjectMocks
    private OrderServiceImpl service;

    @Mock
    private OrderRepository repository;

    private ObjectInitializer objectInitializer;

    @BeforeEach
    public void beforeEach() {
        objectInitializer = new ObjectInitializer();
    }

    @Test
    public void testCreateOrder() {
        Mockito.when(repository.save(Mockito.any(OrderEntity.class))).thenReturn(objectInitializer.createOrderEntity());

        Order orderResponse = service.createOrder(objectInitializer.createOrder());
        Assert.assertNotNull(orderResponse);
    }

    @Test
    public void testGetAllOrders() {
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(objectInitializer.createOrderEntity()));

        List<Order> orderResponse = service.getAllOrders();
        Assert.assertNotNull(orderResponse);
    }

    @Test
    public void testGetAllOrdersByEmail() {
        Mockito.when(repository.findAllByEmail(Mockito.anyString())).thenReturn(Collections.singletonList(objectInitializer.createOrderEntity()));

        List<Order> orderResponse = service.getOrdersByEmail(objectInitializer.createOrder().getEmail());
        Assert.assertNotNull(orderResponse);
    }

}