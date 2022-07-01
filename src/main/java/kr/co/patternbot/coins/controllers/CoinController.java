package kr.co.patternbot.coins.controllers;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.patternbot.auth.domains.Messenger;
import kr.co.patternbot.coins.services.CoinService;
import kr.co.patternbot.coins.domains.Coin;
import kr.co.patternbot.coins.domains.CoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/coins")
public class CoinController {
    private final CoinService service;
    public ResponseEntity<Messenger> update(@RequestBody Coin coin) {
        return ResponseEntity.ok(service.update(coin));
    }

    // Embeded Methods
    @GetMapping("/findAll")
    public ResponseEntity<List<Coin>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findAll/sort")
    public ResponseEntity<List<Coin>> findAll(Sort sort) {
        return ResponseEntity.ok(service.findAll(sort));
    }

    @GetMapping("/findAll/pageable")
    public ResponseEntity<Page<Coin>>findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> delete(@RequestBody Coin coin) {
        return ResponseEntity.ok(service.delete(coin));
    }
    public ResponseEntity<Messenger> save(@ApiParam("Join Coin") @RequestBody CoinDTO coin) {
        System.out.println("회원가입 정보: "+coin.toString());
        return ResponseEntity.ok(service.save(coin));
    }

    @GetMapping("/findById/{coinid}")
    public ResponseEntity<Optional<Coin>> findById(@PathVariable String coinid) {
        return ResponseEntity.ok(service.findById(coinid));
    }

    @GetMapping("/existsById/{coinid}")
    public ResponseEntity<Messenger> existsById(@PathVariable String coinid) {
        return ResponseEntity.ok(service.existsById(coinid));
    }
}
