package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.MissionDailyException;
import com.huuluc.englearn.model.MissionDaily;
import com.huuluc.englearn.mapper.MissionDailyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MissionDailyRepository {
    private final MissionDailyMapper missionDailyMapper;

    public List<MissionDaily> getAll() throws MissionDailyException {
        return missionDailyMapper.findAll();
    }
}
