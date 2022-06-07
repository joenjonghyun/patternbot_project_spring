package kr.co.patternbot.trade.controlles;


import kr.co.patternbot.trade.services.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trades")
public class TradeController {
    private final TradeService service;
}
