package kr.co.patternbot.trade.repositories;

import kr.co.patternbot.trade.domains.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
