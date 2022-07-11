package kr.co.patternbot.coins.services;

import kr.co.patternbot.auth.domains.Messenger;
import kr.co.patternbot.coins.repositories.CoinRepository;
import kr.co.patternbot.common.dataStructure.Box;
import kr.co.patternbot.coins.domains.Coin;
import kr.co.patternbot.coins.domains.CoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kr.co.patternbot.common.lambda.Lambda.longParse;
import static kr.co.patternbot.common.lambda.Lambda.string;

@Service
@RequiredArgsConstructor
public class CoinServiceImpl implements CoinService{
    private final CoinRepository repository;
    @Override
    public List<Coin> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Coin> findAll(Sort sort) {

        return repository.findAll();
    }

    @Override
    public Page<Coin> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Messenger count() {

        return Messenger.builder().message(string(repository.count())).build();
    }

    @Override
    public Messenger update(Coin coin) {
        return Messenger.builder().message("").build();
    }

    @Override
    public Messenger delete(Coin coin) {
        repository.delete(coin);
        return Messenger.builder().message("").build();
    }

    @Override
    public Messenger save(CoinDTO coin) {
        System.out.println("서비스로 전달된 회원가입 정보: "+coin.toString());
        return Messenger.builder().build();
    }

    @Override
    public Optional<Coin> findById(String coinid) {
        return repository.findById(0L); // coinid 타입이 다름
    }

    @Override
    public Messenger existsById(String coinid) {
        return repository.existsById(longParse(coinid))
                ? Messenger.builder().message("EXIST").build()
                : Messenger.builder().message("NOT_EXIST").build(); // coinid 타입이 다름
    }



    @Override
    public List<Coin> findByCoinName(String name) {
        List<Coin> ls = repository.findAll();
        Box<String, Coin> box = new Box<>();
        // ls = box.findByCoinName(ls, name);
        // ls.stream().filter(...)
        return null;
    }
}
