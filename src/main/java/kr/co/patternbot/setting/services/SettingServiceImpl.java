package kr.co.patternbot.setting.services;

import kr.co.patternbot.setting.repositories.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {
    private final SettingRepository repository;
}
