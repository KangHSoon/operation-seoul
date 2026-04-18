<template>
  <div class="map-container">
    <div id="map" style="width: 100%; height: 100vh;"></div>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';

// 미션 목록 데이터를 담을 변수
const missionList = ref([]);

// 1. 백엔드에서 미션 위치 데이터(targetLat, targetLng) 가져오기
const fetchMissions = async () => {
  // TODO: axios.get('/api/v1/missions') 호출
};

// 2. 지도 초기화 및 다크 테마 적용
const initMap = () => {
  // TODO: Kakao/Naver 지도 객체 생성 및 다크 모드 속성 적용
};

// 3. 지도 위 마커 클릭 이벤트
const handleMarkerClick = (missionId) => {
  // TODO: 해당 미션의 브리핑(역사적 배경) 모달 띄우기
  console.log("선택된 작전 번호:", missionId);
};

onMounted(() => {
  fetchMissions();
  initMap();
});
</script>

<style scoped>
/* 다크 테마 컨셉 CSS */
.map-container { background-color: #121212; }
</style>