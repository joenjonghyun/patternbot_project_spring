package kr.co.patternbot.trade.services;

import kr.co.patternbot.trade.repositories.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService{
    private final TradeRepository repository;
}
