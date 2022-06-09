package kr.co.patternbot.setting.repositories;

import kr.co.patternbot.setting.domains.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {
}
