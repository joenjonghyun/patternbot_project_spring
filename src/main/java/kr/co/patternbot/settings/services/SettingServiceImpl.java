package kr.co.patternbot.settings.services;

import kr.co.patternbot.settings.repositories.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {
    private final SettingRepository repository;
}
