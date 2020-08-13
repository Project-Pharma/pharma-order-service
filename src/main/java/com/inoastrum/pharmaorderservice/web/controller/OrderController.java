package com.inoastrum.pharmaorderservice.web.controller;

import com.inoastrum.pharmaorderservice.services.OrderService;
import com.inoastrum.pharmaorderservice.web.model.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
@Slf4j
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable UUID orderId) {
        return new ResponseEntity<>(orderService.findOrderDtoById(orderId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UUID> createNewOrder(@RequestBody @Validated OrderDto orderDto) {
        return new ResponseEntity<>(orderService.createNewOrder(orderDto).getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrder(@PathVariable UUID orderId, @RequestBody @Validated OrderDto orderDto) {
        orderService.updateOrder(orderId, orderDto);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable UUID orderId) {
        orderService.deleteOrderById(orderId);
    }
}
