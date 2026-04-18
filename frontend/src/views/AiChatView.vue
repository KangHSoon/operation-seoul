<template>
  <div class="chat-terminal">
    <div class="ai-response" :class="{ 'highlight': isImportant }">
      {{ displayedText }}
    </div>

    <input v-model="userQuestion" @keyup.enter="sendQuestion" placeholder="질문을 입력하세요..." />
  </div>
</template>

<script setup>
import { ref } from 'vue';

const userQuestion = ref('');
const displayedText = ref('');
const isImportant = ref(false);

// 1. 유저 질문을 백엔드(Gemini)로 전송
const sendQuestion = async () => {
  // TODO: axios.post('/api/v1/sessions/1/chat', userQuestion.value)
  // 임시 시뮬레이션: 백엔드에서 '1'(그렇다)이 왔다고 가정
  const aiCode = 1;
  displayTypingEffect(aiCode);
  userQuestion.value = ''; // 입력창 비우기
};

// 2. AI 응답 코드(1~5)에 따른 타자기 애니메이션 효과
const displayTypingEffect = (code) => {
  let fullText = "";
  if (code === 1) fullText = "그렇습니다.";
  else if (code === 2) fullText = "아닙니다.";
  else if (code === 4) {
    fullText = "핵심적인 단서에 접근했습니다.";
    isImportant.value = true;
  }

  // 글자가 한 글자씩 나타나는 타이핑 효과 로직
  displayedText.value = "";
  let i = 0;
  const interval = setInterval(() => {
    displayedText.value += fullText.charAt(i);
    i++;
    if (i >= fullText.length) clearInterval(interval);
  }, 100); // 0.1초마다 한 글자씩
};
</script>