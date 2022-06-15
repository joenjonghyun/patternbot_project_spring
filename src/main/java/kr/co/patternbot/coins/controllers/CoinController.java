package kr.co.patternbot.coins.controllers;


import kr.co.patternbot.coins.services.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/coins")
public class CoinController {
    private final CoinService service;

}
