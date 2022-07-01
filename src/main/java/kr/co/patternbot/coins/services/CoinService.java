package kr.co.patternbot.coins.services;


import kr.co.patternbot.auth.domains.Messenger;
import kr.co.patternbot.coins.domains.Coin;
import kr.co.patternbot.coins.domains.CoinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CoinService {

    List<Coin> findAll();

    List<Coin> findAll(Sort sort);

    Page<Coin> findAll(Pageable pageable);

    Messenger count();

    Messenger update(Coin coin);

    Messenger delete(Coin coin);

    Messenger save(CoinDTO coin);

    Optional<Coin> findById(String coinid);

    Messenger existsById(String coinid);

    // custom

    List<Coin> findByCoinName(String name);
    
}
