package com.operation.seoul.service;

import org.springframework.stereotype.Service;

@Service
public class GeminiAiService {

    /**
     * 유저의 질문과 정답을 비교하여 1~5 사이의 코드만 반환하는 AI 분류기
     */
    public int getAiResponseCode(String userQuestion, String actualAnswer) {
        // TODO: 프롬프트 세팅
        // "너는 방탈출 게임의 조력자야. 정답은 [actualAnswer]고, 유저의 질문은 [userQuestion]이야.
        // 무조건 1(그렇다), 2(아니다), 3(관계없다), 4(중요한 단서다), 5(오류) 중 숫자 하나만 대답해."

        // TODO: Google Gemini API 호출 로직 작성

        return 1; // 임시 반환값
    }
}