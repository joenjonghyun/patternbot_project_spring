package kr.co.patternbot.faq.services;

import kr.co.patternbot.faq.repositories.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl {
    private final FaqRepository repository;
}
