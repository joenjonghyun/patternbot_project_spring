package kr.co.patternbot.orders.services;

import kr.co.patternbot.auth.domains.Messenger;
import kr.co.patternbot.orders.domains.Orders;
import kr.co.patternbot.orders.domains.OrdersDTO;
import kr.co.patternbot.orders.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{
    private final OrdersRepository repository;

    @Override
    public List<Orders> findAll() {
        return null;
    }

    @Override
    public List<Orders> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Messenger count() {
        return null;
    }

    @Override
    public Messenger update(Orders orders) {
        return null;
    }

    @Override
    public Messenger delete(Orders orders) {
        return null;
    }

    @Override
    public Messenger save(OrdersDTO orders) {
        return null;
    }

    @Override
    public Optional<Orders> findById(String ordersid) {
        return Optional.empty();
    }

    @Override
    public Messenger existsById(String ordersid) {
        return null;
    }

    @Override
    public List<Orders> findByOrdersName(String name) {
        return null;
    }
}
