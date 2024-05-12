package dev.dipanshu.orderservice.controllers;
import dev.dipanshu.orderservice.dtos.CreateOrderRequestDto;
import dev.dipanshu.orderservice.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;
    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public String createOrder(@RequestBody CreateOrderRequestDto orderRequestDto){
        return orderService.saveOrder(orderRequestDto);
    }
}
