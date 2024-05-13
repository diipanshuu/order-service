package dev.dipanshu.orderservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderRequestDto {

    private Long customerId;
    private List<OrderItemDto> items;
    private String shippingAddress;

    @Getter
    @Setter
    public static class OrderItemDto {
        private Long productId;
        private Integer quantity;
    }
}
