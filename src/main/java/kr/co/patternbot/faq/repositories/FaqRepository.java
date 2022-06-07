package kr.co.patternbot.faq.repositories;

import kr.co.patternbot.faq.domains.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Long> {
}
