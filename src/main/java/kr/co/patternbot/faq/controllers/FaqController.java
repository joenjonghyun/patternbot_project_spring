package kr.co.patternbot.faq.controllers;

import kr.co.patternbot.faq.services.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faq")
public class FaqController {
    private final FaqService service;
}
