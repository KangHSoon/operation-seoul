package com.operation.seoul.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessions")
@CrossOrigin(origins = "http://localhost:5173") // 프론트엔드 통신 에러 방지
public class GameSessionController {

    /**
     * 1. 카메라 현장 인증 및 세션(타이머) 시작
     * 프론트엔드에서 보낸 사진을 Vision API로 검증합니다.
     */
    @PostMapping("/verify")
    public String verifyVision(/* 사진 파일 및 위치 정보 DTO */) {
        // 로직: VisionApiService 호출 -> 키워드 일치 시 GameSession 생성
        return "인증 성공 및 타이머 시작";
    }

    /**
     * 2. AI 바다거북 스프 질문 (20회 제한)
     */
    @PostMapping("/{sessionId}/chat")
    public String askAiQuestion(@PathVariable Long sessionId, @RequestBody String question) {
        // 로직: 횟수 체크 -> GeminiAiService 호출 -> 1~5 결과 반환
        return "1"; // 예: 1(그렇다) 반환
    }

    /**
     * 3. 최종 정답 제출
     */
    @PostMapping("/{sessionId}/answer")
    public String submitFinalAnswer(@PathVariable Long sessionId, @RequestBody String userAnswer) {
        // 로직: Mission의 answerKeyword와 단순 비교 -> 정답 시 상태 CLEARED 처리
        return "정답입니다.";
    }
}