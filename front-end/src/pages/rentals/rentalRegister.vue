<template>
  <div div class="d-flex flex-column align-items-center justify-content-center" style="height: 700px">
    <h3 class="mb-2">도서 대여</h3>
    <form style="width: 300px" @submit.stop.prevent="rentalSave">
      <div class="my-3">
        <label for="" class="form-label">회원 아이디</label>
        <select id="" class="form-select" v-model="selectMemberId">
          <option v-for="m in memberId" :key="m">{{ m }}</option>
        </select>
      </div>
      <div class="my-3">
        <label for="" class="form-label">도서명</label>
        <select id="" class="form-select" v-model="selectBookName">
          <option v-for="b in bookName" :key="b">{{ b }}</option>
        </select>
      </div>
      <br>
      <div class="my-3 text-center">
        <button type="submit" class="btn btn-primary">도서 대여</button>
      </div>
    </form>
  </div>
</template>

<script>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from '@/axiosBaseURL.js';

export default {
  setup() {
    const bookName = ref([]);
    const memberId = ref([]);
    const router = useRouter();

    const selectMemberId = ref('');
    const selectBookName = ref('');
    
    const getMemberAndBook = async () => {
      const res = await axios.get('/rental/category');
      bookName.value = res.data.bookName;
      memberId.value = res.data.memberId;
    }
    getMemberAndBook();

    const rentalSave = async () => {
      const res = await axios.post('/rental', {
        memberId: selectMemberId.value,
        bookName: selectBookName.value
      })
      alert(res.data);
      router.push({
        name: 'Home'
      }); 
      
    }

    return {
      bookName,
      memberId,
      selectMemberId,
      selectBookName,
      getMemberAndBook,
      rentalSave
    }

    }
}
</script>

<style>

</style>