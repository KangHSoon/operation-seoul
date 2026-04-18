package com.operation.seoul.controller;

import com.operation.seoul.domain.Mission;
import com.operation.seoul.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/missions")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping
    public List<Mission> getMissions() {
        // 이제 가짜 리스트가 아니라, DB에서 가져온 진짜 데이터를 반환합니다!
        return missionService.getAllMissions();
    }
}