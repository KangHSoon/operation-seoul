<template>
  <header>
    <nav class="top-nav">
      <h2>🕵️‍♂️ Operation: SEOUL</h2>
      <div class="links">
        <RouterLink to="/">지도 보기</RouterLink>
        <RouterLink to="/chat">AI 통신</RouterLink>
      </div>
    </nav>
  </header>
  <main>
    <RouterView />
  </main>
</template>

<style>
body { margin: 0; background-color: #121212; font-family: sans-serif; }
.top-nav {
  display: flex; justify-content: space-between; align-items: center;
  padding: 0 20px; background-color: #1a1a1a; color: white; border-bottom: 2px solid #333;
}
.links a { color: #00ffcc; margin-left: 20px; text-decoration: none; font-weight: bold; }
.links a:hover { color: white; }
</style>