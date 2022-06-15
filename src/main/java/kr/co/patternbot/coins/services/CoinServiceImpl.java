package kr.co.patternbot.coins.services;

import kr.co.patternbot.coins.repositories.CoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoinServiceImpl implements CoinService{
    private final CoinRepository repository;
}
