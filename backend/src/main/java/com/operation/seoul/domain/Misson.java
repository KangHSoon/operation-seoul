package com.operation.seoul.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Mission {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 미션 고유 식별자

    private Long regionId; // 관할 구역 ID (향후 지자체 확장용)

    private String title; // 미션 제목 (예: 중명전의 비밀)

    private Double targetLat; // 목표 지점 위도
    private Double targetLng; // 목표 지점 경도

    private String visionKeyword; // Vision AI가 인식해야 할 핵심 안내판 글귀/현판

    private String answerKeyword; // 유저가 최종적으로 맞혀야 할 정답 키워드
}