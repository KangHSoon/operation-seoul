package com.operation.seoul.service;

import com.operation.seoul.domain.Mission;
import com.operation.seoul.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    // DB에서 모든 미션 정보를 가져옵니다.
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }
}