package kr.co.patternbot.coins.repositories;

import kr.co.patternbot.coins.domains.Coin;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CoinRepository extends JpaRepository<Coin, Long> {
}
