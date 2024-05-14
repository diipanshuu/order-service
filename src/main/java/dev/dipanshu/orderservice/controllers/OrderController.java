package dev.dipanshu.orderservice.controllers;
import dev.dipanshu.orderservice.dtos.CreateOrderRequestDto;
import dev.dipanshu.orderservice.services.OrderService;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
    }
}
