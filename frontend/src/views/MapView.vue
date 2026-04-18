<template>
  <div class="map-container">
    <div class="header">
      <h2>📍 작전 지도: 덕수궁 중명전</h2>
      <p>목표 지점에 도달하여 단서를 확보하십시오.</p>
    </div>

    <div id="map" style="width: 100%; height: 550px; border-radius: 12px; border: 2px solid #00ffcc;"></div>
  </div>
</template>

<script setup>
import { onMounted } from 'vue';
import axios from 'axios';

const initMap = (missions) => {
  const container = document.getElementById('map');
  const options = {
    // 백엔드에서 온 첫 번째 미션의 좌표를 중심으로 설정, 없으면 시청역 기준
    center: new window.kakao.maps.LatLng(
        missions[0]?.targetLat || 37.5642,
        missions[0]?.targetLng || 126.9733
    ),
    level: 3
  };
  const map = new window.kakao.maps.Map(container, options);

  missions.forEach(mission => {
    // 백엔드 필드명(targetLat, targetLng) 사용
    const markerPosition = new window.kakao.maps.LatLng(mission.targetLat, mission.targetLng);
    const marker = new window.kakao.maps.Marker({
      position: markerPosition
    });
    marker.setMap(map);

    const infowindow = new window.kakao.maps.InfoWindow({
      content: `<div style="padding:10px; color:black; font-family: sans-serif;">
                  <strong style="color:#2c3e50;">${mission.title}</strong><br>
                  <span style="font-size:12px;">단서: ${mission.visionKeyword}</span>
                </div>`
    });

    window.kakao.maps.event.addListener(marker, 'click', () => {
      infowindow.open(map, marker);
    });
  });
};

onMounted(async () => {
  // 카카오 맵 라이브러리가 로드될 때까지 체크
  const checkKakao = setInterval(async () => {
    if (window.kakao && window.kakao.maps) {
      clearInterval(checkKakao);

      try {
        // 백엔드 API에서 미션 리스트 가져오기 [cite: 5]
        const response = await axios.get('http://localhost:8080/api/v1/missions');
        const missions = response.data;

        window.kakao.maps.load(() => {
          initMap(missions);
        });
      } catch (error) {
        console.error("데이터 로드 실패:", error);
        window.kakao.maps.load(() => initMap([]));
      }
    }
  }, 100);
});
</script>

<style scoped>
.map-container {
  padding: 20px;
  background-color: #1a1a1a;
  min-height: 100vh;
  color: #00ffcc;
  font-family: 'Pretendard', sans-serif;
}
.header {
  margin-bottom: 20px;
  text-align: center;
}
.header h2 {
  margin: 0;
  font-size: 1.5rem;
  letter-spacing: 2px;
}
.header p {
  font-size: 0.9rem;
  opacity: 0.8;
}
</style>