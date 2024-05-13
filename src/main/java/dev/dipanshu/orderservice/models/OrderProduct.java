package dev.dipanshu.orderservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderProduct extends BaseModel {
    @ManyToOne
    private CustomerOrder order;

    private Long productId;

    private Integer quantity;
}
