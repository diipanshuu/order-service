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

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + (productId != null ? productId.hashCode() : 0);
            result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OrderItemDto that = (OrderItemDto) o;
            return productId != null ? productId.equals(that.productId) : that.productId == null &&
                    quantity != null ? quantity.equals(that.quantity) : that.quantity == null;
        }

    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrderRequestDto that = (CreateOrderRequestDto) o;
        return customerId != null ? customerId.equals(that.customerId) : that.customerId == null &&
                items != null ? items.equals(that.items) : that.items == null;
    }

}
