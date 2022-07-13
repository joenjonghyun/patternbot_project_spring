package kr.co.patternbot.orders.services;

import kr.co.patternbot.auth.domains.Messenger;
import kr.co.patternbot.orders.domains.Orders;
import kr.co.patternbot.orders.domains.OrdersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    ResponseEntity<List<Orders>> findAll();

    List<Orders> findAll(Sort sort);

    Page<Orders> findAll(Pageable pageable);

    Messenger count();

    Messenger update(Orders orders);

    Messenger delete(Orders orders);

    Messenger save(OrdersDTO orders);

    Optional<Orders> findById(String ordersid);

    Messenger existsById(String ordersid);

    // custom

    List<Orders> findByOrdersname(String name);

}
