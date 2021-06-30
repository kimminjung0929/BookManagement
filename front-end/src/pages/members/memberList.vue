<template>
  <div div class="d-flex flex-column align-items-center mt-5" style="height: 700px">
    <h3 class="mb-2">회원 목록</h3>
    <table class="table table-striped" style="width:60%">
      <thead>
        <tr>
          <th class="text-center" scope="col">회원 ID</th>
          <th class="text-center" scope="col">회원 이름</th>
          <th class="text-center" scope="col">휴대폰 번호</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="member in members" v-bind:key="member.id">
          <td class="text-center">{{ member.id }}</td>
          <td class="text-center">{{ member.name }}</td>
          <td class="text-center" >{{ member.phone }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from '@/axiosBaseURL.js';

export default {
  setup() {
    const members = ref([]);

    // 회원 가져오기
    const getMembers = async () => {
      const res = await axios.get('/member');
      members.value = res.data;
    }
    getMembers();

      
    return {
      members,
      getMembers
    }

  }
}
</script>

<style>

</style>