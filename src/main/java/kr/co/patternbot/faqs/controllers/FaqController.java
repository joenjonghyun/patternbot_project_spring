package kr.co.patternbot.faqs.controllers;

import kr.co.patternbot.faqs.services.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faqs")
public class FaqController {
    private final FaqService service;
}
