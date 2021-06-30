<template>
  <div div class="d-flex flex-column align-items-center justify-content-center" style="height: 700px">
    <h3 class="mb-2">회원 등록</h3>
    <form @submit.stop.prevent="memberSave">
      <div class="my-3">
        <label for="id" class="form-label">회원 아이디</label>
        <input type="text" class="form-control" id="id" placeholder="아이디을 입력해주세요" v-model="member.id">
      </div>
      <div class="my-3">
        <label for="name" class="form-label">회원 이름</label>
        <input type="text" class="form-control" id="name" placeholder="이름을 입력해주세요" v-model="member.name">
      </div>
      <div class="my-3">
        <label for="phone" class="form-label">휴대폰 번호</label>
        <input type="text" class="form-control" id="phone" placeholder="휴대폰 번호를 입력해주세요" v-model="member.phone">
      </div>
      <div style="color: red" v-if="valErr">{{ valErr }}</div>
      <br>
      <button type="submit" class="btn btn-primary">회원 등록</button>
    </form>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from '@/axiosBaseURL.js';
import { useRouter } from 'vue-router';

export default {
  setup() {
    const router = useRouter();

    const member = ref([]);
    const valErr = ref('');

    const memberSave = async () => {
      valErr.value = '';
      const res = await axios.post('/member', {
        id: member.value.id,
        name: member.value.name,
        phone: member.value.phone
      })
      if(res.data === '아이디가 중복 됩니다') {
        valErr.value = '아이디가 중복 됩니다';
      } else {
        alert(res.data);
        router.push({
          name: 'Home'
        }); 
      }
    }
      
    return {
      member,
      valErr,
      memberSave
    }

  }
}
</script>

<style>

</style>