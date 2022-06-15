package kr.co.patternbot.settings.repositories;

import kr.co.patternbot.settings.domains.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {
}
