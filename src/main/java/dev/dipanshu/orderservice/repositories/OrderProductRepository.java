package dev.dipanshu.orderservice.repositories;

import dev.dipanshu.orderservice.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
    List<OrderProduct> save(Iterable<OrderProduct> entities);
}
