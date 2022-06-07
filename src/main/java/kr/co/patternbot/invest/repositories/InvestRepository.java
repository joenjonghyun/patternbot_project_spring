package kr.co.patternbot.invest.repositories;

import kr.co.patternbot.invest.domains.Invest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestRepository extends JpaRepository<Invest, Long> {
}
