package kr.co.patternbot.orders.repositories;

import kr.co.patternbot.orders.domains.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
