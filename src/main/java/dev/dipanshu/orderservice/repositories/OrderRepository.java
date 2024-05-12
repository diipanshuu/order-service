package dev.dipanshu.orderservice.repositories;

import dev.dipanshu.orderservice.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    CustomerOrder save(CustomerOrder entity);
}
