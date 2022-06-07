package kr.co.patternbot.coin.repositories;

import kr.co.patternbot.coin.domains.Coin;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CoinRepository extends JpaRepository<Coin, Long> {
}
