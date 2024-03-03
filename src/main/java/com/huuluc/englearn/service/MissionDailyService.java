package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.MissionDaily;
import com.huuluc.englearn.repository.MissionDailyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionDailyService {
    private final MissionDailyRepository missionDailyRepository;

    public List<MissionDaily> getAll() {
        return missionDailyRepository.getAll();
    }
}
