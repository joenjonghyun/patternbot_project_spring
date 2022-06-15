package kr.co.patternbot.faqs.repositories;

import kr.co.patternbot.faqs.domains.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Long> {
}
