package dev.dipanshu.orderservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class CustomerOrder extends BaseModel{
    private String orderNumber;
    private Long customerId;
    private Integer orderAmount;
    private String shippingAddress;
}
