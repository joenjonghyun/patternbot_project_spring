package kr.co.patternbot.invest.services;

import kr.co.patternbot.invest.repositories.InvestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvestServiceImpl {
    private final InvestRepository repository;
}
