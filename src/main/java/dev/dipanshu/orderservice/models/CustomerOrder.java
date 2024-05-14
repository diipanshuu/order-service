package dev.dipanshu.orderservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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

    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> orderProducts;

}
