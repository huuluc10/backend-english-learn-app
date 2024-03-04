package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.model.MissionDaily;
import com.huuluc.englearn.repository.MissionDailyRepository;
import com.huuluc.englearn.service.MissionDailyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionDailyServiceImpl implements MissionDailyService {
    private final MissionDailyRepository missionDailyRepository;

    @Override
    public List<MissionDaily> getAll() {
        return missionDailyRepository.getAll();
    }
}
