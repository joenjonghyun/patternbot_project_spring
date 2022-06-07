package kr.co.patternbot.orders.services;

import kr.co.patternbot.orders.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl {
    private final OrdersRepository repository;
}
