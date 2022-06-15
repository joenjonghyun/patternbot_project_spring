package kr.co.patternbot.faqs.services;

import kr.co.patternbot.faqs.repositories.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService{
    private final FaqRepository repository;
}
