import { createRouter, createWebHistory } from 'vue-router'
import MapView from '../views/MapView.vue'
import AiChatView from '../views/AiChatView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'map',
      component: MapView
    },
    {
      path: '/chat',
      name: 'chat',
      component: AiChatView
    }
  ]
})

export default router