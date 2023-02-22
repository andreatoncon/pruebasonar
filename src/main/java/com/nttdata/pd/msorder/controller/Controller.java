package com.nttdata.pd.msorder.controller;

import com.nttdata.commons.model.Response;
import com.nttdata.pd.msorder.model.Order;
import com.nttdata.pd.msorder.service.OrderService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "${service.controller.path}")
@Slf4j
public class Controller {

    @Autowired
    private OrderService service;

    /**
     *
     * @param orderRequest
     * @return
     */
    @PostMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Order>> createOrder(@RequestBody Order orderRequest) {
        log.info("API request createOrder -- /order body {}", orderRequest);
        Order response = service.createOrder(orderRequest);
        log.info("API response -- {}", response);
        return new ResponseEntity<>(new Response<>(response, "Example API"), HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<Order>>> getAllOrders() {
        log.info("API request getAllOrders -- /order");
        List<Order> response = service.getAllOrders();
        log.info("API response -- {}", response);
        return new ResponseEntity<>(new Response<>(response, "Example API"), HttpStatus.OK);
    }

    /**
     *
     * @param emailFilter
     * @return
     */
    @GetMapping(path = "/order/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<Order>>> getOrdersByEmail(@PathVariable(value = "email") String emailFilter) {
        log.info("API request getOrdersByEmail -- /order/email");
        List<Order> response = service.getOrdersByEmail(emailFilter);
        log.info("API response -- {}", response);
        return new ResponseEntity<>(new Response<>(response, "Example API"), HttpStatus.OK);
    }

}