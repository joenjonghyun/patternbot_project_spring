package kr.co.patternbot.coin.controllers;


import kr.co.patternbot.coin.services.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/coin")
public class CoinController {
    private final CoinService service;

}
