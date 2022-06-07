package kr.co.patternbot.invest.controlles;

import kr.co.patternbot.invest.services.InvestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invest")
public class InvestController {
    private final InvestService service;
}
