package dev.dipanshu.orderservice.services;

import dev.dipanshu.orderservice.dtos.CreateOrderRequestDto;
import dev.dipanshu.orderservice.models.CustomerOrder;
import dev.dipanshu.orderservice.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

     public List<CustomerOrder> getAllOrders(){
         return List.of();
     }
     public CustomerOrder getOrderById(int id){
         return null;
     }

    public String  saveOrder(CreateOrderRequestDto orderRequestDto){
        String orderNumber = UUID.randomUUID().toString();
        CustomerOrder order = new CustomerOrder();
        order.setOrderNumber(orderNumber);
        order.setCustomerId(orderRequestDto.getCustomerId());
        order.setOrderAmount(1000);
        order.setShippingAddress(orderRequestDto.getShippingAddress());

        orderRepository.save(order);
        return order.getOrderNumber();
    }

     public CustomerOrder updateOrder(CustomerOrder order){
         return order;
     }

     public void deleteOrder(int id){}
}
