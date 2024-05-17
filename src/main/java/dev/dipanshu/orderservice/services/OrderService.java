package dev.dipanshu.orderservice.services;

import dev.dipanshu.orderservice.dtos.CreateOrderRequestDto;
import dev.dipanshu.orderservice.models.CustomerOrder;
import dev.dipanshu.orderservice.models.OrderProduct;
import dev.dipanshu.orderservice.repositories.OrderProductRepository;
import dev.dipanshu.orderservice.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private RestTemplate restTemplate;
    public OrderService(OrderRepository orderRepository, OrderProductRepository orderProductRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.restTemplate = restTemplate;
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

        List<OrderProduct> orderProductList = new ArrayList<>();
        List<CreateOrderRequestDto.OrderItemDto> items = orderRequestDto.getItems();
        for (CreateOrderRequestDto.OrderItemDto item : items) {

            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setProductId(item.getProductId());
            orderProduct.setQuantity(item.getQuantity());
            orderProductList.add(orderProduct);

        }

        orderRepository.save(order);
        orderProductRepository.saveAll(orderProductList);

        // Calling the payment service to get the link
//        String paymentLink = restTemplate.postForObject("http://localhost:9090/payments",
//                null,String.class);

//        return order.getOrderNumber() + " " + paymentLink;
        return String.valueOf(orderRequestDto.hashCode());
    }

     public CustomerOrder updateOrder(CustomerOrder order){
         return order;
     }

     public void deleteOrder(long id){
        orderRepository.deleteById(id);
     }
}
