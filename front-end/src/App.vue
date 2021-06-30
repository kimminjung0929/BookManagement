<template>
  <Navbar />
  <div class="container border border-dark my-2">
    <router-view />
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue';

export default {
  name: 'App',
  components: {
    Navbar,
  }
}
</script>

<style>
</style>
