package kr.co.patternbot.orders.controllers;


import io.swagger.annotations.ApiParam;
import kr.co.patternbot.auth.domains.Messenger;
import kr.co.patternbot.orders.domains.Orders;
import kr.co.patternbot.orders.domains.OrdersDTO;
import kr.co.patternbot.orders.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService service;

    @GetMapping("/update")
    public ResponseEntity<Messenger> update(@RequestBody Orders orders) {
        return ResponseEntity.ok(service.update(orders));
    }

    // Embeded Methods
    @GetMapping("/findAll")
    public ResponseEntity<ResponseEntity<List<Orders>>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findAll/sort")
    public ResponseEntity<List<Orders>> findAll(Sort sort) {
        return ResponseEntity.ok(service.findAll(sort));
    }

    @GetMapping("/findAll/pageable")
    public ResponseEntity<Page<Orders>>findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> delete(@RequestBody Orders orders) {
        return ResponseEntity.ok(service.delete(orders));
    }
    public ResponseEntity<Messenger> save(@ApiParam("Join Orders") @RequestBody OrdersDTO orders) {
        System.out.println("회원가입 정보: "+orders.toString());
        return ResponseEntity.ok(service.save(orders));
    }

    @GetMapping("/findById/{ordersid}")
    public ResponseEntity<Optional<Orders>> findById(@PathVariable String ordersid) {
        return ResponseEntity.ok(service.findById(ordersid));
    }

    @GetMapping("/existsById/{ordersid}")
    public ResponseEntity<Messenger> existsById(@PathVariable String ordersid) {
        return ResponseEntity.ok(service.existsById(ordersid));
    }

}
